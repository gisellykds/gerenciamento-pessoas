package br.com.gerenciamento.pessoas.utils.exceptions;

public class ParameterNotIdentify extends RuntimeException {
    public ParameterNotIdentify(String active){
        super("Parameter " + active + "} not identify");
    }
}
