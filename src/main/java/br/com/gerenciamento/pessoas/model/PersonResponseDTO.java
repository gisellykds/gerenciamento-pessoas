package br.com.gerenciamento.pessoas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.br.*;
import javax.validation.constraints.*;

@Data
public class PersonResponseDTO {
    @NotBlank
    @JsonProperty("nome")
    private String firstName;

    @NotBlank
    @JsonProperty("sobrenome")
    private String lastName;

    @NotBlank
    @CPF
    private String cpf;
}
