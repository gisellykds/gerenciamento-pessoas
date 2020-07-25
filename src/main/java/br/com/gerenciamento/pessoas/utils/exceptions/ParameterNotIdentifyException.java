package br.com.gerenciamento.pessoas.utils.exceptions;

public class ParameterNotIdentifyException extends RuntimeException {
    public ParameterNotIdentifyException(String active){
        super("Parameter {" + active + "} not identify");
    }
}
