package negocio;

import entidade.Exercicio;

public class ExercicioService {

    AtividadeService atividadeService = new AtividadeService();

    public Exercicio criarExercicio() throws Exception {
        Exercicio exercicio = new Exercicio();

        System.out.println("Digite a Atividade do exercicio");
        atividadeService.listarAtividades();
        System.out.println("Digite o nome do exercicio");
        System.out.println("Digite o tempo do exercicio");

        return exercicio;
    }

    private void calcularGastoCalorico(Exercicio exercicio, float peso) {
        var caloria = exercicio.getAtividade().getMet() * peso * exercicio.getTempo() / 60;
        exercicio.setCaloria(caloria);
    }

}
