package br.com.gerenciamento.pessoas.facade.impl;

import br.com.gerenciamento.pessoas.dto.PessoaDTO;
import br.com.gerenciamento.pessoas.dto.PessoaRespostaDTO;
import br.com.gerenciamento.pessoas.entity.Pessoa;
import br.com.gerenciamento.pessoas.exceptions.NotFoundException;
import br.com.gerenciamento.pessoas.exceptions.PessoaNotFoundException;
import br.com.gerenciamento.pessoas.facade.PessoaFacade;
import br.com.gerenciamento.pessoas.mapper.PessoaMapper;
import br.com.gerenciamento.pessoas.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaFacadeImpl implements PessoaFacade {

    private PessoaRepository repository;
    private final PessoaMapper mapper = PessoaMapper.INSTANCE;

    @Override
    public PessoaRespostaDTO salvar(PessoaDTO entrada) {
        Pessoa entity = repository.save(mapper.toEntity(entrada));
        PessoaRespostaDTO resposta = mapper.toResposta(entity);
        return resposta;
    }

    @Override
    public List<PessoaRespostaDTO> obterTodos() {
        List<Pessoa> allPeople = verifyEmpty(repository.findAll());
        return allPeople.stream()
                .map(mapper::toResposta)
                .collect(Collectors.toList());
    }

    @Override
    public PessoaRespostaDTO obterId(Long id) throws PessoaNotFoundException{
        Pessoa entity = verifyIfExists(id);
        PessoaRespostaDTO resposta = mapper.toResposta(entity);
        return resposta;
    }

    @Override
    public void deletar(Long id) throws PessoaNotFoundException{
        verifyIfExists(id);
        repository.deleteById(id);
    }

    private Pessoa verifyIfExists(Long id) throws PessoaNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id));
    }

    private List<Pessoa> verifyEmpty(List<Pessoa> lista) throws PessoaNotFoundException{
        if (lista.isEmpty())
            throw new NotFoundException();
        return lista;
    }

}
