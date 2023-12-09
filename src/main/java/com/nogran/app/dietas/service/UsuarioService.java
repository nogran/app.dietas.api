package com.nogran.app.dietas.service;

import com.nogran.app.dietas.model.Usuario;
import java.util.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

  private final MetabolismoService metabolismoService;

  public void cadastrarUsuario(Usuario usuario) {
    try {
      adicionarUsuario(usuario);
    } catch (Exception e) {
      System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
    }
    var metabolismo =
        metabolismoService.calcularMetabolismoBasal(
            usuario.getDataNascimento(), usuario.getSexo(), usuario.getPeso(), usuario.getAltura());
    usuario.getMetabolismo().setTaxaMetabolicaBasal(metabolismo);
  }

  public void desativarUsuario(Scanner scanner) {}

  public Usuario entrarComUsuario(String email) {
    return null;
  }

  private void adicionarUsuario(Usuario usuario) {}
}
