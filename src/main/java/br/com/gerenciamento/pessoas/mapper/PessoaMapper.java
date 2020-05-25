package br.com.gerenciamento.pessoas.mapper;

import br.com.gerenciamento.pessoas.dto.PessoaDTO;
import br.com.gerenciamento.pessoas.dto.PessoaRespostaDTO;
import br.com.gerenciamento.pessoas.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapper {
    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    Pessoa toEntity(PessoaDTO pessoaDTO);

    PessoaRespostaDTO toResposta(Pessoa pessoa);

}
