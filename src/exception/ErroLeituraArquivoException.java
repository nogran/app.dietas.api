package exception;

public class ErroLeituraArquivoException extends RuntimeException {
    public ErroLeituraArquivoException(String arquivo, Exception e) {
        super("Erro ao ler o arquivo: " + arquivo, e);
    }
}
