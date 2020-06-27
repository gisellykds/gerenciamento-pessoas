package br.com.gerenciamento.pessoas.facade;

import br.com.gerenciamento.pessoas.model.MessageResponse;
import br.com.gerenciamento.pessoas.model.PersonResponse;
import br.com.gerenciamento.pessoas.model.PersonDTO;
import java.util.List;

public interface PersonFacade {
    public PersonResponse create(PersonDTO entrada);
    public List<PersonResponse> getAll();
    public PersonResponse getById(Long id);
    public List<PersonResponse> getAllActiveOrInactive(String active);
    public MessageResponse inactivePersonById(Long id);
    public MessageResponse activePersonById(Long id);
}
