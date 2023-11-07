package entidade;

import java.time.LocalDate;
import java.util.List;

public class Refeicao {
    private String nome;

    private List<Alimento> alimentos;

    private LocalDate dataRefeicao;

    private double totalCalorias;

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public LocalDate getDataRefeicao() {
        return dataRefeicao;
    }

    public double getTotalCalorias() {
        return totalCalorias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    public void setDataRefeicao(LocalDate dataRefeicao) {
        this.dataRefeicao = dataRefeicao;
    }

    public void setTotalCalorias(double totalCalorias) {
        this.totalCalorias = totalCalorias;
    }

    public Refeicao(String nome, List<Alimento> alimentos, LocalDate dataRefeicao) {
        this.nome = nome;
        this.alimentos = alimentos;
        this.dataRefeicao = dataRefeicao;
    }

    public Refeicao() {
    }
}
