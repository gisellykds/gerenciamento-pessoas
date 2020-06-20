package br.com.gerenciamento.pessoas.mapper;

import br.com.gerenciamento.pessoas.model.PersonResponseDTO;
import br.com.gerenciamento.pessoas.model.dto.PersonDTO;
import br.com.gerenciamento.pessoas.model.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toEntityFromDto(PersonDTO pessoaDTO);

    PersonResponseDTO toResponseFromEntity(Person pessoa);

}
