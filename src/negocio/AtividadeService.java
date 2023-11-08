package negocio;

import entidade.Atividade;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rafae
 */

public class AtividadeService {

    private String nome;
    private float met;
    private Map<String, Float> atividadesCadastradas;
    private static final String CAMINHO_ARQUIVO = "src/arquivo/atividades.txt";

    public AtividadeService() {
        atividadesCadastradas = new HashMap<>();
        carregarAtividades();
    }

    public void criarAtividade(String nomeAtividade, Float met) throws Exception {
        if (atividadesCadastradas.containsKey(nomeAtividade)) {
            throw new Exception("Atividade já cadastrada!");
        }
        if (met < 0) {
            throw new Exception("O valor do MET não pode ser negativo.");
        }
        atividadesCadastradas.put(nomeAtividade, met);
        salvarAtividadesNoArquivo(); // Chama o método para salvar as atividades no arquivo
        System.out.println("Atividade criada com sucesso!");
        System.out.println();
    }

    public void removerAtividade(String nomeAtividade) throws Exception {
        if (atividadesCadastradas.containsKey(nomeAtividade)) {
            atividadesCadastradas.remove(nomeAtividade);
            salvarAtividadesNoArquivo(); // Chama o método para salvar as atividades no arquivo
        } else {
            System.out.println("Atividade não cadastrada, não é possível remover!");
        }
    }

    public void listarAtividades() throws Exception {
        if (atividadesCadastradas.isEmpty()) {
            throw new Exception("Nao existe atividade cadastrada");
        } else {
            for (Map.Entry<String, Float> entry : atividadesCadastradas.entrySet()) {
                String nomeAtividade = entry.getKey();
                double m = entry.getValue();
                System.out.println(nomeAtividade + ": " + m + " MET");
            }
        }
    }

    private void salvarAtividadesNoArquivo() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (Map.Entry<String, Float> entry : atividadesCadastradas.entrySet()) {
                String nomeAtividade = entry.getKey();
                double met = entry.getValue();
                bw.write(nomeAtividade + "," + met);
                bw.newLine(); // Para avançar para a próxima linha no arquivo
            }
        }
    }

    private void carregarAtividades() {
        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2) {
                    String nomeAtividade = partes[0];
                    Float met = (float) Double.parseDouble(partes[1]);
                    atividadesCadastradas.put(nomeAtividade, met);
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public Atividade buscarAtividadePorNome(String nomeAtividade) {
        if (atividadesCadastradas.containsKey(nomeAtividade)) {
            double met = atividadesCadastradas.get(nomeAtividade);
            return new Atividade(nomeAtividade, (float) met);
        }
        return null; // Retorna null se a atividade não for encontrada
    }

}
