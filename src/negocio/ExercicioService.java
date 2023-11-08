package negocio;

import entidade.Atividade;

public class ExercicioService {

    public float calcularGastoCalorico(float met, float peso, int tempo) {
        return met * peso * tempo / 60;
    }

}
