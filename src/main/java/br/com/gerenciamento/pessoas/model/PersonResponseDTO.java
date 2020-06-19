package br.com.gerenciamento.pessoas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.br.*;
import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponseDTO {

    private Long id;

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
