package br.com.gerenciamento.pessoas.service;

import br.com.gerenciamento.pessoas.facade.impl.PersonFacadeImpl;
import br.com.gerenciamento.pessoas.mapper.PersonMapper;
import br.com.gerenciamento.pessoas.model.PersonResponse;
import br.com.gerenciamento.pessoas.model.PersonDTO;
import br.com.gerenciamento.pessoas.model.Person;
import br.com.gerenciamento.pessoas.repository.PersonRepository;
import br.com.gerenciamento.pessoas.template.PersonTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class PersonFacadeTest {

    @InjectMocks
    PersonFacadeImpl personFacade;

    @Mock
    PersonMapper personMapper;

    @Mock
    PersonRepository personRepository;

    PersonTemplate template = new PersonTemplate();

    @Before
    public void init(){
        this.personFacade = new PersonFacadeImpl(personRepository);
    }

    @Test
    public void mustCreatePerson(){
        //given
        PersonDTO dto = template.getPersonDto();
        Person entity = template.getPerson();
        when(personMapper.toEntityFromDto(dto)).thenReturn(entity);
        when(personRepository.save(any(Person.class))).thenReturn(entity);
        //when
        PersonResponse responseDTO = personFacade.create(dto);
        //then
        assertNotNull(responseDTO);
        verify(personRepository, times(1)).save(any(Person.class));
    }

    @Test
    public void mustGetAllPerson(){
        //given
        List<Person> entities = Collections.singletonList(template.getPerson());
        when(personRepository.findAll()).thenReturn(entities);
        //when
        List<PersonResponse> responseDTOList = personFacade.getAll();
        //then
        assertNotNull(responseDTOList);
        assertFalse(responseDTOList.isEmpty());
        verify(personRepository, times(1)).findAll();
    }

    @Test
    public void mustGetByIdPerson(){
        //given
        Person entity = template.getPerson();
        when(personRepository.findById(anyLong())).thenReturn(Optional.ofNullable(entity));
        //when
        PersonResponse response = personFacade.getById(1L);
        //then
        assertNotNull(response);
        verify(personRepository, times(1)).findById(anyLong());
    }

    @Test
    public void mustDeleteByIdPerson(){
        //given
        Person entity = template.getPerson();
        when(personRepository.findById(anyLong())).thenReturn(Optional.ofNullable(entity));
        //when
        String response = personFacade.deleteById(1L);
        //then
        assertNotNull(response);
        verify(personRepository, times(1)).findById(anyLong());
    }
}
