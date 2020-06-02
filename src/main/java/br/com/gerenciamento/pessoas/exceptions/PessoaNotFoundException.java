package br.com.gerenciamento.pessoas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Pessoa com id não encontrada.")
@Getter
public class PessoaNotFoundException extends RuntimeException {

    public PessoaNotFoundException(Long id) {
        super("Pessoa com id: "+ id +" não encontrada.");
    }
}