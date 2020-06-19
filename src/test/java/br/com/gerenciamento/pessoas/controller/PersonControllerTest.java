package br.com.gerenciamento.pessoas.controller;

import br.com.gerenciamento.pessoas.facade.impl.PersonFacadeImpl;
import br.com.gerenciamento.pessoas.model.PersonResponseDTO;
import br.com.gerenciamento.pessoas.model.dto.PersonDTO;
import br.com.gerenciamento.pessoas.template.PersonTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class PersonControllerTest {
    @Mock()
    PersonFacadeImpl personFacade;

    PersonController personController;

    PersonTemplate template = new PersonTemplate();

    @Before()
    public void init(){
        this.personController = new PersonController(personFacade);
    }

    @Test
    public void mustCreatePerson(){
        //given
        PersonDTO personDTO = template.getPersonDto();
        PersonResponseDTO personResponseDTO = template.getPersonResponseDTO();
        when(personFacade.create(any(PersonDTO.class))).thenReturn(personResponseDTO);

        //when
        ResponseEntity<PersonResponseDTO> response = personController.create(personDTO);

        //then
        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        verify(personFacade, times(1)).create(any(PersonDTO.class));
    }

    @Test
    public void mustGetPerson(){
        //given
        List<PersonResponseDTO> personResponseDTOList = Collections.singletonList(template.getPersonResponseDTO());
        when(personFacade.getAll()).thenReturn(personResponseDTOList);

        //when
        ResponseEntity<List<PersonResponseDTO>> response = personController.getAll();

        //then
        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        verify(personFacade, times(1)).getAll();
    }

    @Test
    public void mustGetPersonById(){
        //given
        PersonResponseDTO personResponseDTO = template.getPersonResponseDTO();
        when(personFacade.getById(anyLong())).thenReturn(personResponseDTO);

        //when
        ResponseEntity<PersonResponseDTO> response = personController.getById(1L);

        //then
        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        verify(personFacade, times(1)).getById(anyLong());
    }

    @Test
    public void mustDeletePersonById(){
        //given
        when(personFacade.deleteById(anyLong())).thenReturn("Successfully deleted");
        //when
        ResponseEntity<String> response = personController.deleteById(1L);
        //then
        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        verify(personFacade, times(1)).deleteById(anyLong());
    }
}
