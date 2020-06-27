package br.com.gerenciamento.pessoas.template;

import br.com.gerenciamento.pessoas.model.PersonResponse;
import br.com.gerenciamento.pessoas.model.PersonDTO;
import br.com.gerenciamento.pessoas.model.Person;

public class PersonTemplate {
    private final Person person = new Person();
    private final PersonResponse personResponseDTO = new PersonResponse();
    private final PersonDTO personDto = PersonDTO.builder().cpf("709.998.950-38").firstName("first").lastName("last").build();

    public Person getPerson(){
        person.setId(1L);
        person.setCpf("709.998.950-38");
        person.setFirstName("first");
        person.setLastName("last");
        return person;
    }

    public PersonResponse getPersonResponseDTO(){
        personResponseDTO.setCpf("709.998.950-38");
        personResponseDTO.setFirstName("first");
        personResponseDTO.setLastName("last");
        return personResponseDTO;
    }

    public PersonDTO getPersonDto(){
        return personDto;
    }
}
