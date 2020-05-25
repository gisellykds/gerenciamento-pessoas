package br.com.gerenciamento.pessoas.repository;

import br.com.gerenciamento.pessoas.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
