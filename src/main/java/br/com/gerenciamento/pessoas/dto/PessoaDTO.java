package br.com.gerenciamento.pessoas.dto;

import lombok.*;
import org.hibernate.validator.constraints.br.*;
import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @CPF
    private String cpf;

}
