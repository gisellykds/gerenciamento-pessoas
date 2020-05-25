package br.com.gerenciamento.pessoas.facade.impl;

import br.com.gerenciamento.pessoas.facade.PessoaFacade;
import br.com.gerenciamento.pessoas.mapper.PessoaMapper;
import br.com.gerenciamento.pessoas.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaFacadeImpl implements PessoaFacade {

    private PessoaRepository repository;
    private final PessoaMapper mapper = PessoaMapper.INSTANCE;

}
