package entidade;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class DiarioExercicios {
    private List<Exercicio> exercicios;
    private LocalDate date;
    private int totalMinutos;
    private double totalCalorias;

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public LocalDate getDate() {
        return date;
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTotalMinutos(int totalMinutos) {
        this.totalMinutos = totalMinutos;
    }

    public void setTotalCalorias(double totalCalorias) {
        this.totalCalorias = totalCalorias;
    }
}
