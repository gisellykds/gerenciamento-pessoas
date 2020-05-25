package br.com.gerenciamento.pessoas.controller;

import br.com.gerenciamento.pessoas.facade.PessoaFacade;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api/v1/pessoas")
@CrossOrigin
@Configuration
public class PessoaController {

    private PessoaFacade pessoaFacade;


}
