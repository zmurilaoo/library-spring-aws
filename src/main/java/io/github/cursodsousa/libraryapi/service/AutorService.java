package io.github.cursodsousa.libraryapi.service;


import io.github.cursodsousa.libraryapi.dto.AutorDto;
import io.github.cursodsousa.libraryapi.exceptions.AutorExeception;
import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public void update(String id) {
        var idAutor =  UUID.fromString(id);

        Optional<Autor> buscar = autorRepository.findById(idAutor);

        if (buscar.isPresent()) {
            Autor AutorEncotrado = buscar.get();

            AutorEncotrado.setNacionalidade("Holandes");

            autorRepository.save(AutorEncotrado);



        }else{
            ResponseEntity.noContent();
        }
    }






}
