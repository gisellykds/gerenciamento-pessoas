package br.com.gerenciamento.pessoas.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nenhum cadastro encontrado.")
@Getter
public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        super("Nenhum cadastro encontrado.");
    }
}
