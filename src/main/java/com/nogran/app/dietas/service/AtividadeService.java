package com.nogran.app.dietas.service;

import com.nogran.app.dietas.model.Atividade;
import java.util.Map;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AtividadeService {

  private final String nome;
  private final float met;
  private final Map<String, Float> atividadesCadastradas;

  public void criarAtividade(String nomeAtividade, Float met) throws Exception {
    if (atividadesCadastradas.containsKey(nomeAtividade)) {
      throw new Exception("Atividade já cadastrada!");
    }
    if (met < 0) {
      throw new Exception("O valor do MET não pode ser negativo.");
    }
    atividadesCadastradas.put(nomeAtividade, met);
  }

  public void removerAtividade(String nomeAtividade) {}

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

  public Atividade buscarAtividadePorNome(String nomeAtividade) {
    if (atividadesCadastradas.containsKey(nomeAtividade)) {
      double met = atividadesCadastradas.get(nomeAtividade);
      return new Atividade(nomeAtividade, (float) met);
    }
    return null; // Retorna null se a atividade não for encontrada
  }
}
