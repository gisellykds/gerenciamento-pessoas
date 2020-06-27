package br.com.gerenciamento.pessoas.facade.impl;

import br.com.gerenciamento.pessoas.mapper.PersonMapper;
import br.com.gerenciamento.pessoas.model.MessageResponse;
import br.com.gerenciamento.pessoas.model.PersonResponse;
import br.com.gerenciamento.pessoas.model.PersonDTO;
import br.com.gerenciamento.pessoas.model.Person;
import br.com.gerenciamento.pessoas.utils.exceptions.AlreadyUpdateException;
import br.com.gerenciamento.pessoas.utils.exceptions.NotFoundException;
import br.com.gerenciamento.pessoas.facade.PersonFacade;
import br.com.gerenciamento.pessoas.repository.PersonRepository;
import br.com.gerenciamento.pessoas.utils.exceptions.ParameterNotIdentifyException;
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
        Person entity = mapper.toEntityFromDto(entrada);
        entity.setActive(true);
        entity = repository.save(entity);
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
    public List<PersonResponse> getAllActiveOrInactive(String active) {
        Boolean activeEntity = verifyActive(active);
        List<Person> allPeople = verifyNotEmptyCriteria(activeEntity);
        return allPeople.stream()
                .map(mapper::toResponseFromEntity)
                .collect(Collectors.toList());
    }

    private Boolean verifyActive(String active) {
        if (active.equals("active"))
            return true;
        if(active.equals("inactive"))
            return false;
        throw new ParameterNotIdentifyException(active);
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

    private List<Person> verifyNotEmptyCriteria(Boolean active){
        List<Person> list = repository.findAllByActive(active);
        if(list.isEmpty())
            throw new NotFoundException();
        return list;
    }

    private Person inactivePerson(Person entity){
        if(entity.getActive().equals(false))
            throw new AlreadyUpdateException("active");
        entity.setActive(false);
        return entity;
    }

    private Person activePerson(Person entity){
        if(entity.getActive().equals(true))
            throw new AlreadyUpdateException("inactive");
        entity.setActive(true);
        return entity;
    }
}
