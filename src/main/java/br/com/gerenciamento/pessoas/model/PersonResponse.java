package br.com.gerenciamento.pessoas.model;

import br.com.gerenciamento.pessoas.utils.enums.RolePerson;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.br.*;
import javax.validation.constraints.*;

@Data
public class PersonResponse {

    private String name;

    private String cpf;

    private Boolean active;

    private RolePerson role;
}
