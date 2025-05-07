package io.github.cursodsousa.libraryapi.dto;

import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.model.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record AutorDto(java.util.UUID id,
                       //@Bean Validation
                       @Size(max = 30, message = "O campo deve conter apenas 30 caracteres.")
                       @NotBlank(message = "Campo Obrigatório") // Aqui seria uma validação para string não vim fazia, ou nula
                       String nome,
                       @NotNull(message = "Campo Obrigatório") // Para campos, no caso vc não pode deixar a data pela metade, tem finalizar os campos
                       LocalDate dataNascimento,
                       @NotBlank(message = "Campo Obrigatório")
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
