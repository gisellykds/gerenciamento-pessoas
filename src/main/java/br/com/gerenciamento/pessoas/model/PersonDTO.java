package br.com.gerenciamento.pessoas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.br.*;
import javax.validation.constraints.*;

@Builder
@Data
public class PersonDTO {

    @NotBlank
    @JsonProperty("first_name")
    private String firstName;

    @NotBlank
    @JsonProperty("last_name")
    private String lastName;

    @NotBlank
    @CPF
    private String cpf;

}
