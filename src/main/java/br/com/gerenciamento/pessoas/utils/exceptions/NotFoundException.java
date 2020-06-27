package br.com.gerenciamento.pessoas.utils.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super("No registration found.");
    }
}
