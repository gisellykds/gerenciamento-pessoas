package br.com.gerenciamento.pessoas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Nenhum cadastro encontrado.")
public class NotFoundException extends RuntimeException{

}
