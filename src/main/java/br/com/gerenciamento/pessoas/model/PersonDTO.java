package br.com.gerenciamento.pessoas.model;

import br.com.gerenciamento.pessoas.utils.enums.RolePerson;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.br.*;
import javax.validation.constraints.*;

@Builder
@Data
public class PersonDTO {

    @NotBlank
    @JsonProperty("name")
    private String name;

    @NotBlank
    @CPF
    private String cpf;


}
