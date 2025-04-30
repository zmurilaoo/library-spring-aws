package io.github.cursodsousa.libraryapi.dto;

import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.model.Livro;

import java.time.LocalDate;
import java.util.List;

public record AutorDto(java.util.UUID id,
                       String nome,
                       LocalDate dataNascimento,
                       String nascionalidade, List<Livro> livros)
{


    public Autor mapearAutor(AutorDto autorDto) {
        Autor autor =  new Autor();

        autor.setNome(autorDto.nome());
        autor.setDataNascimento(autorDto.dataNascimento);
        autor.setNascionalidade(autorDto.nascionalidade );

        return autor;
    }



}
