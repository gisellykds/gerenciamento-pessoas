package br.com.gerenciamento.pessoas.facade.impl;

import br.com.gerenciamento.pessoas.mapper.PersonMapper;
import br.com.gerenciamento.pessoas.model.MessageResponse;
import br.com.gerenciamento.pessoas.model.PersonResponse;
import br.com.gerenciamento.pessoas.model.PersonDTO;
import br.com.gerenciamento.pessoas.model.Person;
import br.com.gerenciamento.pessoas.utils.exceptions.AlreadyUpdate;
import br.com.gerenciamento.pessoas.utils.exceptions.NotFoundException;
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
    public PersonResponse create(PersonDTO entrada) {
        Person entity = repository.save(mapper.toEntityFromDto(entrada));
        PersonResponse resposta = mapper.toResponseFromEntity(entity);
        return resposta;
    }

    @Override
    public List<PersonResponse> getAll() {
        List<Person> allPeople = verifyNotEmpty();
        return allPeople.stream()
                .map(mapper::toResponseFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PersonResponse getById(Long id) {
        Person entity = verifyIfExists(id);
        PersonResponse resposta = mapper.toResponseFromEntity(entity);
        return resposta;
    }

    @Override
    public List<PersonResponse> getAllActive() {
        List<Person> allPeople = verifyNotEmptyActive();
        return allPeople.stream()
                .map(mapper::toResponseFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MessageResponse inactivePersonById(Long id) {
       Person entity = inactivePerson(verifyIfExists(id));
       repository.save(entity);
       return new MessageResponse("Successfully inactive!");
    }

    @Override
    public MessageResponse activePersonById(Long id) {
        Person entity = activePerson(verifyIfExists(id));
        repository.save(entity);
        return new MessageResponse("Successfully ative!");
    }

    private Person verifyIfExists(Long id){
        return repository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    private List<Person> verifyNotEmpty(){
        List<Person> list = repository.findAll();
        if(list.isEmpty())
            throw new NotFoundException();
        return list;
    }

    private List<Person> verifyNotEmptyActive(){
        List<Person> list = repository.findAllByActive(true);
        if(list.isEmpty())
            throw new NotFoundException();
        return list;
    }

    private Person inactivePerson(Person entity){
        if(entity.getActive().equals(false))
            throw new AlreadyUpdate("active");
        entity.setActive(false);
        return entity;
    }

    private Person activePerson(Person entity){
        if(entity.getActive().equals(true))
            throw new AlreadyUpdate("inactive");
        entity.setActive(true);
        return entity;
    }
}
