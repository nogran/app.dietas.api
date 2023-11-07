package entidade;

import java.time.LocalDate;
import java.util.List;

public class Refeicao {

    private List<Alimento> alimentos;

    private LocalDate localDate;

    private double totalCalorias;

    private String tipo;

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public double getTotalCalorias() {
        return totalCalorias;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setTotalCalorias(double totalCalorias) {
        this.totalCalorias = totalCalorias;
    }
}
