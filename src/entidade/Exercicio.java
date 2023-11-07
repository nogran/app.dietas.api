package entidade;

public class Exercicio {
    private Atividade atividade;
    private int tempo;
    private double calorias;

    public Atividade getAtividade() {
        return atividade;
    }

    public int getTempo() {
        return tempo;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }
}
