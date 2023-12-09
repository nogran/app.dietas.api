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

  public Alimento buscarAlimentoPeloNome(String nomeAlimento) {
    return alimentosCadastrados.get(nomeAlimento);
  }

  private float calcularCaloria(float kcal, float quantidade) {
    return kcal * quantidade;
  }
}
