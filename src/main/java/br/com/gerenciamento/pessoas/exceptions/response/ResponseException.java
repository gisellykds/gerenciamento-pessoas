package br.com.gerenciamento.pessoas.exceptions.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseException {
    private String message;
}
