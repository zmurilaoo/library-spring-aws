package io.github.cursodsousa.libraryapi.api;

import io.github.cursodsousa.libraryapi.dto.AutorDto;
import io.github.cursodsousa.libraryapi.dto.RespostaDto;
import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.repository.AutorRepository;
import io.github.cursodsousa.libraryapi.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private  AutorRepository autorRepository;

    @Autowired
    private  AutorService autorService;

    @PostMapping
    public ResponseEntity<RespostaDto> salvar(@RequestBody @Valid AutorDto autorDto) {
        Autor autor = autorDto.mapearAutor(autorDto);
        autorService.verificarSalvar(autor);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autor.getId()).toUri();

        return ResponseEntity.created(location).body(new RespostaDto( "Autor Criado com sucesso", autor));

    }

    @GetMapping({"{id}"})
    public ResponseEntity<AutorDto> obterPorId( @PathVariable("id") String id ) {
        var idAutor = UUID.fromString(id);
        autorService.obterPorId(idAutor);
        Optional<Autor> pesquisar = autorService.obterPorId(idAutor);

        if (pesquisar.isPresent()) {
            Autor autor = pesquisar.get();
            AutorDto dto = new AutorDto(autor.getId(), autor.getNome(), autor.getDataNascimento(), autor.getNascionalidade());
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping({"id"})
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        var deletarId = UUID.fromString(id);
        Optional<Autor> pesquisar = autorService.obterPorId(deletarId);

        if (pesquisar.isPresent()) {
            ResponseEntity.notFound().build();
        }

        autorService.deletar(pesquisar.get());

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<List<AutorDto>> pesquisar(String nome, String nacionalidade) {

        autorRepository.findByNomeAndNacionalidade(nome, nacionalidade);




    }

}
