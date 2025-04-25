package io.github.cursodsousa.libraryapi.service;


import io.github.cursodsousa.libraryapi.exceptions.ClienteExeception;
import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;


    public Autor verificarSalvar(Autor autor ) {
        if (autor == null){
            throw new ClienteExeception("Infelizmente nome não pode ser nulo! ");
        }

        autorRepository.save(autor);

        return autor;
    }

    public Optional<Autor> obterPorId(UUID id) {
        return autorRepository.findById(id);
    }


    public void deletar(Autor autor) {
        autorRepository.delete(autor);
    }
}
