package br.com.gerenciamento.pessoas.exceptions.controller;

import br.com.gerenciamento.pessoas.exceptions.NotFoundException;
import br.com.gerenciamento.pessoas.exceptions.response.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotFoundException.class)
    ResponseException NotFoundException(HttpServletRequest request, NotFoundException exception) {
        return new ResponseException(request, exception);
    }

}
