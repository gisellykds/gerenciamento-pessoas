package br.com.gerenciamento.pessoas.facade.impl;

import br.com.gerenciamento.pessoas.mapper.PersonMapper;
import br.com.gerenciamento.pessoas.model.PersonResponseDTO;
import br.com.gerenciamento.pessoas.model.dto.PersonDTO;
import br.com.gerenciamento.pessoas.model.entity.Person;
import br.com.gerenciamento.pessoas.exceptions.NotFoundException;
import br.com.gerenciamento.pessoas.facade.PersonFacade;
import br.com.gerenciamento.pessoas.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonFacadeImpl implements PersonFacade {

    private PersonRepository repository;
    private final PersonMapper mapper = PersonMapper.INSTANCE;

    @Override
    public PersonResponseDTO create(PersonDTO entrada) {
        Person entity = repository.save(mapper.toEntityFromDto(entrada));
        PersonResponseDTO resposta = mapper.toResponseFromEntity(entity);
        return resposta;
    }

    @Override
    public List<PersonResponseDTO> getAll() {
        List<Person> allPeople = verifyNotEmpty();
        return allPeople.stream()
                .map(mapper::toResponseFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PersonResponseDTO getById(Long id) {
        Person entity = verifyIfExists(id);
        PersonResponseDTO resposta = mapper.toResponseFromEntity(entity);
        return resposta;
    }

    @Override
    public String deleteById(Long id) {
        verifyIfExists(id);
        repository.deleteById(id);
        return "Successfully deleted!";
    }

    private Person verifyIfExists(Long id) throws NotFoundException {
        return repository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    private List<Person> verifyNotEmpty() throws NotFoundException{
        List<Person> list = repository.findAll();
        return list.stream().findAny().map(pessoa -> list)
                .orElseThrow(NotFoundException::new);
    }

}
