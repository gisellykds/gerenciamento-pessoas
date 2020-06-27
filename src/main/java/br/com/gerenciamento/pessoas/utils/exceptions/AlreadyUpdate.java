package br.com.gerenciamento.pessoas.utils.exceptions;

public class AlreadyUpdate extends RuntimeException {
    public AlreadyUpdate(String parameter){
        super("This register is already " + parameter);
    }
}
