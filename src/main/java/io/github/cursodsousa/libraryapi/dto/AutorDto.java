package io.github.cursodsousa.libraryapi.dto;

import io.github.cursodsousa.libraryapi.model.Autor;

import java.time.LocalDate;

public record AutorDto(java.util.UUID id,
                       String nome,
                       LocalDate dataNascimento,
                       String nascionalidade)
{


    public Autor mapearAutor(AutorDto autorDto) {
        Autor autor =  new Autor();

        autor.setNome(autorDto.nome());
        autor.setDataNascimento(autorDto.dataNascimento);
        autor.setNascionalidade(autorDto.nascionalidade );

        return autor;
    }



}
