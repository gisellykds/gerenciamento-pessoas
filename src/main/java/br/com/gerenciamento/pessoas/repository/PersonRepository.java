package br.com.gerenciamento.pessoas.repository;

import br.com.gerenciamento.pessoas.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
