package com.nogran.app.dietas.service;

import com.nogran.app.dietas.model.Refeicao;
import com.nogran.app.dietas.model.Usuario;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RefeicaoService {

  public void adicionarRefeicao(Refeicao refeicao, Usuario usuario) throws ParseException {
    LocalDateTime hoje = LocalDateTime.now();

    if (usuario.getRefeicoes() == null) {
      usuario.setRefeicoes(new ArrayList<>());
    }

    Refeicao refeicaoAtual =
        usuario.getRefeicoes().stream()
            .filter(d -> d.getDataCriacao().isEqual(hoje))
            .findFirst()
            .orElse(null);

    if (refeicaoAtual != null) {
      usuario.getRefeicoes().add(refeicao);
    } else {
      Refeicao novaRefeicao = new Refeicao();
      novaRefeicao.setDataCriacao(LocalDateTime.now());
      novaRefeicao.setTotalCalorias(novaRefeicao.getTotalCalorias());
      usuario.getRefeicoes().add(novaRefeicao);
    }
  }

  public List<Refeicao> mostrarRefeicoes(Usuario usuario, LocalDateTime date) {
    if (usuario.getRefeicoes() == null) {
      System.out.println("Nenhuma refeicao cadastrada.");
      System.out.println();
      return new ArrayList<>();
    }

    List<Refeicao> refeicoesDoDia =
        usuario.getRefeicoes().stream()
            .filter(refeicao -> refeicao.getDataCriacao().isEqual(date))
            .collect(Collectors.toList());

    // Exibe as refeições do dia
    for (Refeicao refeicao : refeicoesDoDia) {
      System.out.println("Tipo da Refeição: " + refeicao.getNome());
      System.out.println("Alimentos: " + refeicao.getAlimentos());
    }
    return refeicoesDoDia;
  }

  public void excluirRefeicao(Refeicao refeicao, Usuario usuario) {}

  public Refeicao buscarRefeicoesPorDia(Usuario usuario, LocalDateTime data) throws Exception {
    if (usuario.getRefeicoes() == null) {
      System.out.println("Nenhuma refeicao cadastrada.");
      return null;
    }

    List<Refeicao> refeicoesEncontradas =
        usuario.getRefeicoes().stream()
            .filter(refeicao -> refeicao.getDataCriacao().isEqual(data))
            .collect(Collectors.toList());

    if (refeicoesEncontradas.size() == 0) {
      System.out.println("Refeicoes nao cadastrada");
    }

    if (refeicoesEncontradas.size() > 1) {
      throw new Exception("Refeicao duplicada!");
    }

    return refeicoesEncontradas.get(0);
  }
}
