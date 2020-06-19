package br.com.gerenciamento.pessoas.mapper;

import br.com.gerenciamento.pessoas.model.PersonResponseDTO;
import br.com.gerenciamento.pessoas.model.dto.PersonDTO;
import br.com.gerenciamento.pessoas.model.entity.Person;
import br.com.gerenciamento.pessoas.template.PersonTemplate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class PersonMapperTest {
    @Spy
    PersonMapper personMapper = Mappers.getMapper(PersonMapper.class);

    PersonTemplate template = new PersonTemplate();

    @Before
    public void init(){

    }

    @Test
    public void mustConvertToEntityFromDto(){
        //given
        PersonDTO dto = template.getPersonDto();
        //when
        Person entity = personMapper.toEntityFromDto(dto);
        //then
        assertNotNull(entity);
        verify(personMapper, times(1)).toEntityFromDto(any(PersonDTO.class));
    }

    @Test
    public void mustConvertToEntityFromDtoNull(){
        //given
        PersonDTO dto = null;
        //when
        Person entity = personMapper.toEntityFromDto(dto);
        //then
        assertNull(entity);
        verify(personMapper, times(1)).toEntityFromDto(null);
    }

    @Test
    public void mustConvertToRespostaFromEntity(){
        //given
        Person entity = template.getPerson();
        //when
        PersonResponseDTO responseDTO = personMapper.toResponseFromEntity(entity);
        //then
        assertNotNull(responseDTO);
        verify(personMapper, times(1)).toResponseFromEntity(any(Person.class));
    }

    @Test
    public void mustConvertToRespostaFromEntityNull(){
        //given
        Person entity = null;
        //when
        PersonResponseDTO responseDTO = personMapper.toResponseFromEntity(entity);
        //then
        assertNull(responseDTO);
        verify(personMapper, times(1)).toResponseFromEntity(null);
    }
}
