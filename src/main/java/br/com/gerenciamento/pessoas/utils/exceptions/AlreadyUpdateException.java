package br.com.gerenciamento.pessoas.utils.exceptions;

public class AlreadyUpdateException extends RuntimeException {
    public AlreadyUpdateException(String parameter){
        super("This register is already " + parameter);
    }
}
