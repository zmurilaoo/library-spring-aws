package io.github.cursodsousa.libraryapi.service;


import io.github.cursodsousa.libraryapi.dto.AutorDto;
import io.github.cursodsousa.libraryapi.exceptions.AutorExeception;
import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;


    public Autor verificarSalvar(Autor autor ) {
        if (autor == null){
            throw new AutorExeception("Infelizmente nome não pode ser nulo! ");
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


    public List<Autor> filtro(String nome, String nacionalidade) {
        if (nome != null && nacionalidade != null) {
            autorRepository.findByNomeAndNacionalidade(nome, nacionalidade);
        }

        if (nome != null) {
            autorRepository.findByNome(nome);
        }

        if (nacionalidade != null) {
            autorRepository.findByNacionalidade(nacionalidade);
        }

        return autorRepository.findAll();

    }


}
