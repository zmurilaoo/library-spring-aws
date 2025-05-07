package io.github.cursodsousa.libraryapi.service;


import io.github.cursodsousa.libraryapi.dto.AutorDto;
import io.github.cursodsousa.libraryapi.dto.ErroResposta;
import io.github.cursodsousa.libraryapi.exceptions.OperacaoNaoPermetidaExeception;
import io.github.cursodsousa.libraryapi.exceptions.RegistroDuplicado;
import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.repository.AutorRepository;
import io.github.cursodsousa.libraryapi.repository.LivroRepository;
import io.github.cursodsousa.libraryapi.validador.AutorValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AutorService {

    @Autowired
    private  final AutorRepository autorRepository;
    private final AutorValidator validator;
    private final LivroRepository repository;




    public Autor verificarSalvar(Autor autor ) {
        validator.validar(autor);

        return autorRepository.save(autor);
    }

    public Optional<Autor> obterPorId(UUID id) {
        return autorRepository.findById(id);

    }


    public void deletar(Autor autor) {
        if (vereficarLivro(autor)) {
            throw  new OperacaoNaoPermetidaExeception("Esse autor possui livros, não é permetido remover!");
        }
        autorRepository.delete(autor);
    }

    public List<Autor> filtro(String nome, String nascionalidade)  {

        if(nome != null && nascionalidade != null){
            autorRepository.findByNomeAndNacionalidade(nome, nascionalidade);

        }

        if (nome!= null) {
            autorRepository.findByNome(nome);
        }


        if (nascionalidade != null) {
            autorRepository.findByNacionalidade(nascionalidade);
        }


        return autorRepository.findAll();
    }


    public void atualizarPrime(Autor autor) {
        validator.validar(autor);

        autorRepository.save(autor);

    }

    public ResponseEntity<ErroResposta> autalizar(@PathVariable("id") String id, @RequestBody AutorDto dto ) {
        try {
            var idAutor = UUID.fromString(id);


            Optional<Autor> definir = obterPorId(idAutor);

            if (definir.isEmpty()) {
                ResponseEntity.notFound().build();
            }

            var autor = definir.get();
            autor.setNome(dto.nome());
            autor.setDataNascimento(dto.dataNascimento());
            autor.setNacionalidade(dto.nacionalidade());

            atualizarPrime(autor);


            return ResponseEntity.noContent().build();

        } catch (RegistroDuplicado e) {
           var erroDto = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDto.status()).body(erroDto);

        }
    }

    public boolean vereficarLivro(Autor autor ){
        return repository.existByAutor(autor);
    }
}
