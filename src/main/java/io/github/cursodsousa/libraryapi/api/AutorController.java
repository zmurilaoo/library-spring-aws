package io.github.cursodsousa.libraryapi.api;

import io.github.cursodsousa.libraryapi.dto.AutorDto;
import io.github.cursodsousa.libraryapi.dto.ErroResposta;
import io.github.cursodsousa.libraryapi.dto.RespostaDto;
import io.github.cursodsousa.libraryapi.exceptions.OperacaoNaoPermetidaExeception;
import io.github.cursodsousa.libraryapi.exceptions.RegistroDuplicado;
import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.repository.AutorRepository;
import io.github.cursodsousa.libraryapi.service.AutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/autores")
@RequiredArgsConstructor
public class AutorController {


    private final AutorRepository autorRepository;


    private final AutorService autorService;

    @PostMapping
    public ResponseEntity<Object > salvar(@RequestBody @Valid AutorDto autorDto) {
        try {
            Autor autor = autorDto.mapearAutor(autorDto);
            autorService.verificarSalvar(autor);

            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(autor.getId()).toUri();

            return ResponseEntity.created(location).body(new RespostaDto( "Autor Criado com sucesso", autor));

        } catch (RegistroDuplicado e) {
             var erroDto = ErroResposta.conflito( e.getMessage());
             return ResponseEntity.status(erroDto.status()).body(erroDto);
        }

    }

    @GetMapping({"{id}"})
    public ResponseEntity<AutorDto> obterPorId( @PathVariable("id") String id ) {
        var idAutor = UUID.fromString(id);
        autorService.obterPorId(idAutor);
        Optional<Autor> pesquisar = autorService.obterPorId(idAutor);

        if (pesquisar.isPresent()) {
            Autor autor = pesquisar.get();
            AutorDto dto = new AutorDto(autor.getId(), autor.getNome(), autor.getDataNascimento(), autor.getNacionalidade());
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<Object> deletar(@PathVariable String id) {
        try {
            var deletarId = UUID.fromString(id);
            Optional<Autor> pesquisar = autorService.obterPorId(deletarId);

            if (pesquisar.isPresent()) {
                ResponseEntity.notFound().build();
            }

            autorService.deletar(pesquisar.get());

            return ResponseEntity.noContent().build();

        } catch (OperacaoNaoPermetidaExeception e) {
            var erroDelete = ErroResposta.respostaPadrao(e.getMessage());
            return ResponseEntity.status(erroDelete.status()).body(erroDelete);
        }

    }

    @GetMapping
    public ResponseEntity<List<AutorDto>> pesquisar(@RequestParam(value = "nome", required = false)String nome, @RequestParam(value = "nacionalidade", required = false)String nacionalidade) {

        List<Autor> autores =  autorService.filtro(nome, nacionalidade);

        List<AutorDto> recebe = autores.stream().map(autor -> new AutorDto(autor.getId(),
                autor.getNome(),
                autor.getDataNascimento(),
                autor.getNacionalidade())).collect(Collectors.toList());

        return ResponseEntity.ok(recebe);

    }

    @PutMapping("{id}")
    public ResponseEntity<ErroResposta> atualizar(@PathVariable("id") String id, @RequestBody AutorDto dto) {
        return autorService.autalizar(id, dto);
    }

}
