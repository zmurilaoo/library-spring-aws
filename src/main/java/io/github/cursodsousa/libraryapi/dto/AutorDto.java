package io.github.cursodsousa.libraryapi.dto;

import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.model.Livro;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record AutorDto(java.util.UUID id,
                       String nome,
                       LocalDate dataNascimento,
                       String nacionalidade)
{



    public Autor mapearAutor(AutorDto autorDto) {
        Autor autor =  new Autor();

        autor.setNome(autorDto.nome());
        autor.setDataNascimento(autorDto.dataNascimento);
        autor.setNacionalidade(autorDto.nacionalidade );

        return autor;
    }



}
