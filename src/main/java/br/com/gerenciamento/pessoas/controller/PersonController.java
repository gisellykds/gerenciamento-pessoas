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
    public List<PersonResponseDTO> getAll() {
        return personFacade.getAll();
    }

    @GetMapping("/{id}")
    public PersonResponseDTO getById(@PathVariable @NotNull Long id) {
        return personFacade.getById(id);
    }

    @PostMapping("")
    public PersonResponseDTO create(@RequestBody @Valid PersonDTO entrada){
        return personFacade.create(entrada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id)  {
        personFacade.deleteById(id);
    }

}
