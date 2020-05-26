package br.com.gerenciamento.pessoas.controller;

import br.com.gerenciamento.pessoas.dto.PessoaDTO;
import br.com.gerenciamento.pessoas.dto.PessoaRespostaDTO;
import br.com.gerenciamento.pessoas.entity.Pessoa;
import br.com.gerenciamento.pessoas.exceptions.PessoaNotFoundException;
import br.com.gerenciamento.pessoas.facade.PessoaFacade;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api/v1/pessoas")
@CrossOrigin
@Configuration
public class PessoaController {

    private PessoaFacade pessoaFacade;

    @GetMapping("")
    public List<PessoaRespostaDTO> obterTodos() {
        return pessoaFacade.obterTodos();
    }

    @GetMapping("/{id}")
    public PessoaRespostaDTO obterId(@PathVariable @NotNull Long id) {
        return pessoaFacade.obterId(id);
    }

    @PostMapping("")
    public PessoaRespostaDTO salvar(@RequestBody @Valid PessoaDTO entrada){
        return pessoaFacade.salvar(entrada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PessoaNotFoundException {
        pessoaFacade.deletar(id);
    }
    
}
