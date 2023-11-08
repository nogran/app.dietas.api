package negocio;

import entidade.DiarioExercicio;
import entidade.Exercicio;
import entidade.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DiarioExercicioService {

    ExercicioService exercicioService = new ExercicioService();

    public void adicionarExercicio(Usuario usuario, Exercicio exercicio) throws Exception {

        LocalDate hoje = LocalDate.now();

        DiarioExercicio diarioAtual = usuario.getDiarioExercicios().stream()
                .filter(d -> d.getData().isEqual(hoje))
                .findFirst()
                .orElse(null);

        if (diarioAtual != null) {
            // Se já existe um DiarioExercicios para o dia atual, adiciona o exercício a ele
            diarioAtual.getExercicios().add(exercicio);
        } else {
            // Se não existe um DiarioExercicios para o dia atual, cria um novo
            DiarioExercicio novoDiario = new DiarioExercicio();
            novoDiario.setData(hoje);
            novoDiario.getExercicios().add(exercicio);
            usuario.getDiarioExercicios().add(novoDiario);
        }
    }

    public void mostrarResumoDeExercicios(Usuario usuario) {
        if (usuario.getDiarioExercicios() == null || usuario.getDiarioExercicios().isEmpty()) {
            System.out.println("Não existem registros de exercícios no diário.");
            System.out.println();
        } else {
            System.out.println("Diário de Exercícios de " + usuario.getNome() + ":");
            for (DiarioExercicio exercicio : usuario.getDiarioExercicios()) {
                System.out.println("Data: " + exercicio.getData());
                System.out.println("Tempo (minutos): " + exercicio.getTotalMinutos());
                System.out.println("Calorias (kcal): " + exercicio.getTotalCalorias());
                System.out.println();
            }
        }
    }

    public void mostrarResumoDeExercicios(Usuario usuario, LocalDate localDate) {
        List<DiarioExercicio> atividadesNaData = usuario.getDiarioExercicios()
                .stream()
                .filter(exercicio -> exercicio.getData().isEqual(localDate))
                .collect(Collectors.toList());

        if (atividadesNaData.isEmpty()) {
            System.out.println("Não existem registros de atividades na data especificada.");
        } else {
            System.out.println("Resumo de Atividades de " + usuario.getNome() + " para " + localDate + ":");
            for (DiarioExercicio exercicio : atividadesNaData) {
                System.out.println("Exercícios: " + exercicio.getExercicios());
                System.out.println("Tempo (minutos): " + exercicio.getTotalMinutos());
                System.out.println("Calorias (kcal): " + exercicio.getTotalCalorias());
                System.out.println();
            }
        }
    }

    public void listarDiarioExercicios(Usuario usuario) {
        if (usuario.getDiarioExercicios() == null || usuario.getDiarioExercicios().isEmpty()) {
            System.out.println("Não existem registros de exercícios no diário.");
        } else {
            System.out.println("Diário de Exercícios de " + usuario.getNome() + ":");
            for (DiarioExercicio exercicio : usuario.getDiarioExercicios()) {
                System.out.println("Data: " + exercicio.getData());
                System.out.println("Exercício: " + exercicio.getExercicios());
                System.out.println("Tempo (minutos): " + exercicio.getTotalMinutos());
                System.out.println("Calorias (kcal): " + exercicio.getTotalCalorias());
                System.out.println();
            }
        }
    }

    public void removerExercicio(Usuario usuario, Exercicio exercicio) {
        LocalDate hoje = LocalDate.now();

        DiarioExercicio diarioAtual = usuario.getDiarioExercicios().stream()
                .filter(d -> d.getData().isEqual(hoje))
                .findFirst()
                .orElse(null);

        if (diarioAtual != null) {
            // Se já existe um DiarioExercicios para o dia atual, tenta remover o exercício dele
            if (diarioAtual.getExercicios().remove(exercicio)) {
                System.out.println("Exercício removido com sucesso.");
            } else {
                System.out.println("Exercício não encontrado no diário.");
            }
        } else {
            System.out.println("Não há registro de exercícios para o dia atual.");
        }
    }

}
