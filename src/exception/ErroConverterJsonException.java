package exception;

public class ErroConverterJsonException extends RuntimeException {
    public ErroConverterJsonException(String arquivo, Exception e) {
        super("Erro ao converter JSON do arquivo: " + arquivo, e);
    }
}
