package br.com.gerenciamento.pessoas.controller;

import br.com.gerenciamento.pessoas.model.PersonResponseDTO;
import br.com.gerenciamento.pessoas.model.dto.PersonDTO;
import br.com.gerenciamento.pessoas.facade.PersonFacade;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api/v1/person")
@CrossOrigin
@Configuration
public class PersonController {

    private PersonFacade personFacade;

    @GetMapping("")
    public ResponseEntity<List<PersonResponseDTO>> getAll() {
        return ResponseEntity.ok(personFacade.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> getById(@PathVariable @NotNull Long id) {
        return ResponseEntity.ok(personFacade.getById(id));
    }

    @PostMapping("")
    public ResponseEntity<PersonResponseDTO> create(@RequestBody @Valid PersonDTO entrada){
        return new ResponseEntity(personFacade.create(entrada), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id)  {
        String message = personFacade.deleteById(id);
        return ResponseEntity.ok(message);
    }

}
