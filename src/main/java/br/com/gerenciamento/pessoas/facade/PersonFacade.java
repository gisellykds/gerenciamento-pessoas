package br.com.gerenciamento.pessoas.facade;

import br.com.gerenciamento.pessoas.model.PersonResponseDTO;
import br.com.gerenciamento.pessoas.model.dto.PersonDTO;
import java.util.List;

public interface PersonFacade {
    public PersonResponseDTO create(PersonDTO entrada);
    public List<PersonResponseDTO> getAll();
    public PersonResponseDTO getById(Long id);
    public void deleteById(Long id);
}
