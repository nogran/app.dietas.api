package negocio;

import entidade.DiarioExercicios;
import entidade.Exercicio;
import entidade.Usuario;

import java.time.LocalDate;
import java.util.List;

public class DiarioExerciciosService {

    public void adicionarExercicio(List<DiarioExercicios> diarioExercicios, Exercicio exercicio, Usuario usuario) {
        LocalDate hoje = LocalDate.now();

        // Ele filtra na lista para achar diario da data atual
        DiarioExercicios diarioAtual = diarioExercicios.stream()
                .filter(d -> d.getDate().isEqual(hoje))
                .findFirst()
                .orElse(null);

        if (diarioAtual != null) {
            // Se já existe um DiarioExercicios para o dia atual, adiciona o exercício a ele
            diarioAtual.getExercicios().add(exercicio);
        } else {
            // Se não existe um DiarioExercicios para o dia atual, cria um novo
            DiarioExercicios novoDiario = new DiarioExercicios();
            novoDiario.setDate(hoje);
            novoDiario.getExercicios().add(exercicio);
            diarioExercicios.add(novoDiario);
        }
    }
}
