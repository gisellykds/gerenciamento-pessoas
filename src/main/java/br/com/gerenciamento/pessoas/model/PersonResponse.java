package br.com.gerenciamento.pessoas.model;

import lombok.*;

@Data
public class PersonResponse {

    private String name;

    private String cpf;

    private Boolean active;

}
