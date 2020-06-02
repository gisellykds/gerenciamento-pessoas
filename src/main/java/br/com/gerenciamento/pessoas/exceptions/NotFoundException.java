package br.com.gerenciamento.pessoas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Not Found")
public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super("Nenhum cadastro encontrado.");
    }
}
