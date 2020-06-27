package br.com.gerenciamento.pessoas.template;

import br.com.gerenciamento.pessoas.model.PersonResponse;
import br.com.gerenciamento.pessoas.model.PersonDTO;
import br.com.gerenciamento.pessoas.model.Person;

public class PersonTemplate {
    private final Person person = new Person();
    private final PersonResponse personResponseDTO = new PersonResponse();
    private final PersonDTO personDto = PersonDTO.builder().cpf("709.998.950-38").name("first").build();

    public Person getPerson(){
        person.setId(1L);
        person.setCpf("709.998.950-38");
        person.setName("name");
        person.setActive(true);
        return person;
    }

    public PersonResponse getPersonResponseDTO(){
        personResponseDTO.setCpf("709.998.950-38");
        personResponseDTO.setName("name");
        personResponseDTO.setActive(true);
        return personResponseDTO;
    }

    public PersonDTO getPersonDto(){
        return personDto;
    }
}
