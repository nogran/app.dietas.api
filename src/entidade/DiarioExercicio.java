package entidade;

import java.time.LocalDate;
import java.util.List;

public class DiarioExercicio {
    private List<Exercicio> exercicios;
    private LocalDate data;
    private int totalMinutos;
    private double totalCalorias;

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public LocalDate getData() {
        return data;
    }

    public int getTotalMinutos() {
        return totalMinutos;
    }

    public double getTotalCalorias() {
        return totalCalorias;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setTotalMinutos(int totalMinutos) {
        this.totalMinutos = totalMinutos;
    }

    public void setTotalCalorias(double totalCalorias) {
        this.totalCalorias = totalCalorias;
    }
}
