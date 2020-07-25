package br.com.gerenciamento.pessoas.utils.exceptions.controller;

import br.com.gerenciamento.pessoas.utils.exceptions.AlreadyUpdateException;
import br.com.gerenciamento.pessoas.utils.exceptions.NotFoundException;
import br.com.gerenciamento.pessoas.utils.exceptions.ParameterNotIdentifyException;
import br.com.gerenciamento.pessoas.utils.exceptions.response.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
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

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(AlreadyUpdateException.class)
    ResponseException AlreadyUpdateException(HttpServletRequest request, AlreadyUpdateException exception) {
        return new ResponseException(request, exception);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ParameterNotIdentifyException.class)
    ResponseException ParameterNotIdentifyException(HttpServletRequest request, ParameterNotIdentifyException exception) {
        return new ResponseException(request, exception);
    }

}

