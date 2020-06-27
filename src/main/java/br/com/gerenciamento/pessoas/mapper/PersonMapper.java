package br.com.gerenciamento.pessoas.mapper;

import br.com.gerenciamento.pessoas.model.PersonResponse;
import br.com.gerenciamento.pessoas.model.PersonDTO;
import br.com.gerenciamento.pessoas.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "active", ignore = true),
    })
    Person toEntityFromDto(PersonDTO pessoaDTO);

    PersonResponse toResponseFromEntity(Person pessoa);

}
