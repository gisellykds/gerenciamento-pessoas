package br.com.gerenciamento.pessoas.controller;

import br.com.gerenciamento.pessoas.model.PersonResponseDTO;
import br.com.gerenciamento.pessoas.model.dto.PersonDTO;
import br.com.gerenciamento.pessoas.facade.PersonFacade;
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
public class PersonController {

    private PersonFacade personFacade;

    @GetMapping("")
    public List<PersonResponseDTO> obterTodos() {
        return personFacade.obterTodos();
    }

    @GetMapping("/{id}")
    public PersonResponseDTO obterId(@PathVariable @NotNull Long id) {
        return personFacade.obterId(id);
    }

    @PostMapping("")
    public PersonResponseDTO salvar(@RequestBody @Valid PersonDTO entrada){
        return personFacade.salvar(entrada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id)  {
        personFacade.deletar(id);
    }

}
