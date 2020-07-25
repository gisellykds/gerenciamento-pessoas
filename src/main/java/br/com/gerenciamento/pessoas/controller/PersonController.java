package br.com.gerenciamento.pessoas.controller;

import br.com.gerenciamento.pessoas.model.MessageResponse;
import br.com.gerenciamento.pessoas.model.PersonResponse;
import br.com.gerenciamento.pessoas.model.PersonDTO;
import br.com.gerenciamento.pessoas.facade.PersonFacade;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api/v1/person")
@CrossOrigin
@Configuration
@Validated
public class PersonController {

    private PersonFacade personFacade;

    @GetMapping("")
    public ResponseEntity<List<PersonResponse>> getAll() {
        return ResponseEntity.ok(personFacade.getAll());
    }

    @GetMapping("/get")
    public ResponseEntity<List<PersonResponse>> getAllActive(@RequestParam(value = "status") String active) {
        return ResponseEntity.ok(personFacade.getAllActiveOrInactive(active));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> getById(@PathVariable @NotNull Long id) {
        return ResponseEntity.ok(personFacade.getById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<PersonResponse> create(@RequestBody @Valid PersonDTO input){
        return new ResponseEntity(personFacade.create(input), HttpStatus.CREATED);
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<MessageResponse> activeById(@PathVariable @NotNull Long id)  {
        return ResponseEntity.ok(personFacade.activePersonById(id));
    }

    @PutMapping("/inactive/{id}")
    public ResponseEntity<MessageResponse> inactiveById(@PathVariable @NotNull Long id)  {
        return ResponseEntity.ok(personFacade.inactivePersonById(id));
    }
}
