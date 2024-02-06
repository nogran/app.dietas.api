package com.nogran.app.dietas.service;

import com.nogran.app.dietas.model.User;
import java.util.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private final MetabolismService metabolismService;

  public void cadastrarUsuario(User user) {
    try {
      adicionarUsuario(user);
    } catch (Exception e) {
      System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
    }
    var metabolismo =
        metabolismService.calcularMetabolismoBasal(
            user.getBirthDate(), user.getGender(), user.getWeight(), user.getHeight());
    user.getMetabolism().setBasalMetabolicRate(metabolismo);
  }

  public void desativarUsuario(Scanner scanner) {}

  public User entrarComUsuario(String email) {
    return null;
  }

  private void adicionarUsuario(User user) {}
}
