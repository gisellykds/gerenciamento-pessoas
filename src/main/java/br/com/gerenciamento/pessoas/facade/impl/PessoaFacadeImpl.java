package br.com.gerenciamento.pessoas.facade.impl;

import br.com.gerenciamento.pessoas.dto.PessoaDTO;
import br.com.gerenciamento.pessoas.dto.PessoaRespostaDTO;
import br.com.gerenciamento.pessoas.entity.Pessoa;
import br.com.gerenciamento.pessoas.exceptions.NotFoundException;
import br.com.gerenciamento.pessoas.facade.PessoaFacade;
import br.com.gerenciamento.pessoas.mapper.PessoaMapper;
import br.com.gerenciamento.pessoas.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        List<Pessoa> allPeople = verifyNotEmpty();
        return allPeople.stream()
                .map(mapper::toResposta)
                .collect(Collectors.toList());
    }

    @Override
    public PessoaRespostaDTO obterId(Long id) {
        Pessoa entity = verifyIfExists(id);
        PessoaRespostaDTO resposta = mapper.toResposta(entity);
        return resposta;
    }

    @Override
    public void deletar(Long id) {
        verifyIfExists(id);
        repository.deleteById(id);
    }

    private Pessoa verifyIfExists(Long id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    private List<Pessoa> verifyNotEmpty() throws NotFoundException{
        List<Pessoa> list = repository.findAll();
        return list.stream().findAny().map(pessoa -> list)
                .orElseThrow(NotFoundException::new);
    }

}
