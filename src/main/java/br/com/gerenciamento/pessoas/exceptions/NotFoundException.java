package br.com.gerenciamento.pessoas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super("No registration found.");
    }
}
