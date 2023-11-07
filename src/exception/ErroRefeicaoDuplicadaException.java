package exception;

public class ErroRefeicaoDuplicadaException extends RuntimeException {
    public ErroRefeicaoDuplicadaException(String refeicao, Exception e) {
        super("Refeicao duplicada: " + refeicao, e);
    }
}
