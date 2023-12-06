package com.nogran.app.dietas.service;

import com.nogran.app.dietas.model.Usuario;
import java.time.LocalDate;
import java.util.*;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

  public void cadastrarUsuario(Usuario usuario) {
    try {
      adicionarUsuario(usuario);
    } catch (Exception e) {
      System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
    }
    var metabolismo =
        calcularMetabolismoBasal(
            usuario.getDataNascimento(), usuario.getSexo(), usuario.getPeso(), usuario.getAltura());
    usuario.setMetabolismoBasal(metabolismo);
  }

  public void desativarUsuario(Scanner scanner) {}

  public Usuario entrarComUsuario(String email) {
    return null;
  }

  private void adicionarUsuario(Usuario usuario) {}

  private float calcularMetabolismoBasal(
      LocalDate dataNascimento, String sexo, float peso, float altura) {
    int idade = calcularIdade(dataNascimento);

    int coeficiente = 0;
    if (sexo.equals('M')) {
      coeficiente = 5;
    } else if (sexo.equals("F")) {
      coeficiente = -161;
    }
    return (10 * peso) * 6.25F * altura - (5 * idade) + coeficiente;
  }

  private Integer calcularIdade(LocalDate date) {
    Calendar cal = GregorianCalendar.getInstance();
    int anoAtual = cal.get(Calendar.YEAR);
    int idade = anoAtual - date.getYear(); // Calcula a idade apenas com os anos
    int diaAtual = cal.get(Calendar.DAY_OF_MONTH);
    int mesAtual = cal.get(Calendar.MONTH);

    if (date.getDayOfMonth() >= diaAtual && date.getMonth().getValue() >= mesAtual) {
      idade--;
    }
    return idade;
  }
}
