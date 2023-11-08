package negocio;

import entidade.Alimento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AlimentoService {

    private final Map<String, Alimento> alimentosCadastrados;
    private static final String CAMINHO_ARQUIVO = "src/arquivo/alimentos.txt";

    public AlimentoService() {
        this.alimentosCadastrados = new HashMap<>();
        this.carregarAlimentos();
    }

    public void adicionarAlimento(Alimento alimento) throws Exception {
        if (alimentosCadastrados.containsKey(alimento.getNome())) {
            throw new Exception("Alimento já cadastrado!");
        }
        alimentosCadastrados.put(alimento.getNome(), alimento);
    }

    public void removerAlimento(String nomeAlimento) throws Exception {
        if (alimentosCadastrados.containsKey(nomeAlimento)) {
            alimentosCadastrados.remove(nomeAlimento);
        } else {
            throw new Exception("Alimento não cadastrado, não é possível remover!");
        }
    }

    public void mostrarAlimentos() throws Exception {
        if (alimentosCadastrados.isEmpty()) {
            throw new Exception("Não existem alimentos cadastrados.");
        } else {
            for (Map.Entry<String, Alimento> entry : alimentosCadastrados.entrySet()) {
                Alimento alimento = entry.getValue();
                System.out.println("Nome: " + alimento.getNome());
                System.out.println("Carboidrato: " + alimento.getCarboidrato() + "g");
                System.out.println("Proteína: " + alimento.getProteina() + "g");
                System.out.println("Gordura: " + alimento.getGordura() + "g");
                System.out.println("Calorias: " + alimento.getTotalCaloria() + " kcal");
                System.out.println();
            }
        }
    }

    private void carregarAlimentos() {
        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 5) {
                    String nome = partes[0];
                    float quantidade = Float.parseFloat(partes[1]);
                    float carboidrato = Float.parseFloat(partes[2]);
                    float proteina = Float.parseFloat(partes[3]);
                    float gordura = Float.parseFloat(partes[4]);
                    Alimento alimento = new Alimento(nome, quantidade, carboidrato, proteina, gordura);
                    alimentosCadastrados.put(nome, alimento);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Alimento buscarAlimentoPeloNome(String nomeAlimento) {
        return alimentosCadastrados.get(nomeAlimento);
    }
}
