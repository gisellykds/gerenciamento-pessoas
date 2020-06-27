package br.com.gerenciamento.pessoas.model;

import br.com.gerenciamento.pessoas.utils.enums.RolePerson;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private Boolean active;

//    @Column(nullable = false)
//    private RolePerson role;

}
