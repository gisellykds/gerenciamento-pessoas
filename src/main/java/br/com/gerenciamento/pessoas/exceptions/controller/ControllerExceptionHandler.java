package br.com.gerenciamento.pessoas.exceptions.controller;

import br.com.gerenciamento.pessoas.exceptions.NotFoundException;
import br.com.gerenciamento.pessoas.exceptions.PessoaNotFoundException;
import br.com.gerenciamento.pessoas.exceptions.response.ResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(PessoaNotFoundException.class)
    public ResponseEntity<?> notFoundPerson(RuntimeException exception) {
        return ResponseEntity.badRequest().body(
                new ResponseException(exception.getMessage())
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundListPerson(RuntimeException exception) {
        return ResponseEntity.badRequest().body(
                new ResponseException(exception.getMessage())
        );
    }

}
