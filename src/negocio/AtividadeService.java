package negocio;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rafae
 */

public class AtividadeService {

    private String nome;
    private float met;

    private Map<String, Double> atividadesCadastradas;

    private static final String CAMINHO_ARQUIVO = "src/arquivo/atividades.txt";


    public AtividadeService() {
        atividadesCadastradas = new HashMap<>();
        carregarAtividades();
    }

    private void carregarAtividades() {
        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2) {
                    String nomeAtividade = partes[0];
                    double met = Double.parseDouble(partes[1]);
                    atividadesCadastradas.put(nomeAtividade, met);
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void adicionarAtividade(String nomeAtividade, double met) throws Exception {
        if (atividadesCadastradas.containsKey(nomeAtividade)) {
            throw new Exception("Atividade já cadastrada!");
        }
        if (met < 0) {
            throw new Exception("O valor do MET não pode ser negativo.");
        }
        atividadesCadastradas.put(nomeAtividade, met);
        salvarAtividadesNoArquivo(); // Chama o método para salvar as atividades no arquivo
    }

    public void removerAtividade(String nomeAtividade) throws Exception {
        if (atividadesCadastradas.containsKey(nomeAtividade)) {
            atividadesCadastradas.remove(nomeAtividade);
            salvarAtividadesNoArquivo(); // Chama o método para salvar as atividades no arquivo
        } else {
            throw new Exception("Atividade não cadastrada, não é possível remover!");
        }
    }

    public void mostrarAtividades() throws Exception {
        if (atividadesCadastradas.isEmpty()) {
            throw new Exception("Nao existe atividade cadastrada");
        } else {
            for (Map.Entry<String, Double> entry : atividadesCadastradas.entrySet()) {
                String nomeAtividade = entry.getKey();
                double m = entry.getValue();
                System.out.println(nomeAtividade + ": " + m + " MET");
            }
        }
    }

    private void salvarAtividadesNoArquivo() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (Map.Entry<String, Double> entry : atividadesCadastradas.entrySet()) {
                String nomeAtividade = entry.getKey();
                double met = entry.getValue();
                bw.write(nomeAtividade + "," + met);
                bw.newLine(); // Para avançar para a próxima linha no arquivo
            }
        }
    }

}
