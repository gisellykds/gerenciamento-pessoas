package br.com.gerenciamento.pessoas.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.br.*;
import javax.validation.constraints.*;

@Data
@Builder
public class PersonDTO {

    @NotBlank
    @JsonProperty("name")
    private String firstName;

    @NotBlank
    @JsonProperty("lastname")
    private String lastName;

    @NotBlank
    @CPF
    private String cpf;

}
