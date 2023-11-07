package negocio;

import entidade.Exercicio;

public class ExercicioService {

    private double calcularGastoCalorico(Exercicio exercicio, float peso) {
        var caloria = exercicio.getAtividade().getMet() * peso * exercicio.getTempo() / 60;
        exercicio.setCalorias(caloria);
        return caloria;
    }
}
