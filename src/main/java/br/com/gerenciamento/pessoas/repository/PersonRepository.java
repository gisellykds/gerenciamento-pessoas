package br.com.gerenciamento.pessoas.repository;

import br.com.gerenciamento.pessoas.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByActive(boolean active);
}
