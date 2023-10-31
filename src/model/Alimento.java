package model;

public class Alimento {
    private String nome;
    private float quantidade;
    private float carboidrato;
    private float proteina;
    private float gordura;
    private float totalCaloria;

    public String getNome() {
        return nome;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public float getCarboidrato() {
        return carboidrato;
    }

    public float getProteina() {
        return proteina;
    }

    public float getGordura() {
        return gordura;
    }

    public float getTotalCaloria() {
        return totalCaloria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public void setCarboidrato(float carboidrato) {
        this.carboidrato = carboidrato;
    }

    public void setProteina(float proteina) {
        this.proteina = proteina;
    }

    public void setGordura(float gordura) {
        this.gordura = gordura;
    }

    public void setTotalCaloria(float totalCaloria) {
        this.totalCaloria = totalCaloria;
    }

    public Alimento(String nome, float quantidade, float carboidrato, float proteina, float gordura) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.carboidrato = carboidrato;
        this.proteina = proteina;
        this.gordura = gordura;
        this.totalCaloria = calcularCaloria();
    }

    private float calcularCaloria() {
        var proteinaKcal = 4;
        var carboidratoKcal = 4;
        var gorduraKcal = 9;

        return this.carboidrato * carboidratoKcal
                + this.proteina * proteinaKcal
                + this.gordura * gorduraKcal;
    }

}
