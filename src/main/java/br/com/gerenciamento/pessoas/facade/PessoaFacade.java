package br.com.gerenciamento.pessoas.facade;

import br.com.gerenciamento.pessoas.dto.PessoaDTO;
import br.com.gerenciamento.pessoas.dto.PessoaRespostaDTO;

import java.util.List;

public interface PessoaFacade {
    public PessoaRespostaDTO salvar(PessoaDTO entrada);
    public List<PessoaRespostaDTO> obterTodos();
    public PessoaRespostaDTO obterId(Long id);
    public void deletar(Long id);
}
