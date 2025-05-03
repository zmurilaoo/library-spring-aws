package io.github.cursodsousa.libraryapi.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErroResposta(int status, String mensagem, List<ErroCampo>erros ){

    //Erro mais genérico é 400 -e vai ser chamado esse aqui
    public static ErroResposta respostaPadrao(String mensagem) {
        return new ErroResposta(HttpStatus.BAD_REQUEST.value(),mensagem, List.of());
    }

    public static ErroResposta conflito(String mensagem) {
        return new ErroResposta(HttpStatus.CONTINUE.value(), mensagem, List.of());
    }
}
