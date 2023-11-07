package exception;

public class ErroSalvarArquivoException extends RuntimeException {
    public ErroSalvarArquivoException(String arquivo, Exception e) {
        super("Erro ao salvar arquivo: " + arquivo, e);
    }
}
