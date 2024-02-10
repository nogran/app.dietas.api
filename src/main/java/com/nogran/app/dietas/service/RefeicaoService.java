//package com.nogran.app.dietas.service;
//
//import com.nogran.app.dietas.model.Meal;
//import com.nogran.app.dietas.model.User;
//import java.text.ParseException;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class RefeicaoService {
//
//  public void adicionarRefeicao(Meal meal, User user) throws ParseException {
//    LocalDateTime hoje = LocalDateTime.now();
//
//    if (user.getMeals() == null) {
//      user.setMeals(new ArrayList<>());
//    }
//
//    Meal mealAtual =
//        user.getMeals().stream()
//            .filter(d -> d.getDataCriacao().isEqual(hoje))
//            .findFirst()
//            .orElse(null);
//
//    if (mealAtual != null) {
//      user.getMeals().add(meal);
//    } else {
//      Meal novaMeal = new Meal();
//      novaMeal.setDataCriacao(LocalDateTime.now());
//      novaMeal.setTotalCalorias(novaMeal.getTotalCalorias());
//      user.getMeals().add(novaMeal);
//    }
//  }
//
//  public List<Meal> mostrarRefeicoes(User user, LocalDateTime date) {
//    if (user.getMeals() == null) {
//      System.out.println("Nenhuma refeicao cadastrada.");
//      System.out.println();
//      return new ArrayList<>();
//    }
//
//    List<Meal> refeicoesDoDia =
//        user.getMeals().stream()
//            .filter(meal -> meal.getDataCriacao().isEqual(date))
//            .collect(Collectors.toList());
//
//    // Exibe as refeições do dia
//    for (Meal meal : refeicoesDoDia) {
//      System.out.println("Tipo da Refeição: " + meal.getNome());
//      System.out.println("Alimentos: " + meal.getFoods());
//    }
//    return refeicoesDoDia;
//  }
//
//  public void excluirRefeicao(Meal meal, User user) {}
//
//  public Meal buscarRefeicoesPorDia(User user, LocalDateTime data) throws Exception {
//    if (user.getMeals() == null) {
//      System.out.println("Nenhuma refeicao cadastrada.");
//      return null;
//    }
//
//    List<Meal> refeicoesEncontradas =
//        user.getMeals().stream()
//            .filter(meal -> meal.getDataCriacao().isEqual(data))
//            .collect(Collectors.toList());
//
//    if (refeicoesEncontradas.size() == 0) {
//      System.out.println("Refeicoes nao cadastrada");
//    }
//
//    if (refeicoesEncontradas.size() > 1) {
//      throw new Exception("Refeicao duplicada!");
//    }
//
//    return refeicoesEncontradas.get(0);
//  }
//}
