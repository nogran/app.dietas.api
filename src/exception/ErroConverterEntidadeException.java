package exception;

public class ErroConverterEntidadeException extends RuntimeException {
    public ErroConverterEntidadeException(String entidade, Exception e) {
        super("Erro ao converter Entidade para JSON: " + entidade, e);
    }
}
