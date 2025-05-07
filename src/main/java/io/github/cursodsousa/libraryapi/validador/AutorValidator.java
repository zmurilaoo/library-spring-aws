package io.github.cursodsousa.libraryapi.validador;


import io.github.cursodsousa.libraryapi.exceptions.RegistroDuplicado;
import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AutorValidator {

    @Autowired
    private AutorRepository repository;


    public void validar(Autor autor) {
        if (existeAutorDuplicado(autor)){
            throw new RegistroDuplicado("Autor já cadastrado!");
        }

    }
    
    public boolean existeAutorDuplicado(Autor autor){
        Optional<Autor> autorEncontrado = repository.findByNomeAndDataNascimentoAndNacionalidade(autor.getNome(), autor.getDataNascimento(), autor.getNacionalidade());


        if (autor.getId() == null) {
            return autorEncontrado.isPresent();
        }

        return !autor.getId().equals(autorEncontrado.get().getId()) && autorEncontrado.isPresent();
    }
}
