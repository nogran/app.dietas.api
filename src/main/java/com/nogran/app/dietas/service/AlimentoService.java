package com.nogran.app.dietas.service;

import com.nogran.app.dietas.model.Alimento;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlimentoService {

  private final Map<String, Alimento> alimentosCadastrados;

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

  public Alimento buscarAlimentoPeloNome(String nomeAlimento) {
    return alimentosCadastrados.get(nomeAlimento);
  }
}
