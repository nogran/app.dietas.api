package entidade;

public class Exercicio {
    private Atividade atividade;
    private int tempo;
    private double caloria;

    public Atividade getAtividade() {
        return atividade;
    }

    public int getTempo() {
        return tempo;
    }

    public double getCaloria() {
        return caloria;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public void setCaloria(double caloria) {
        this.caloria = caloria;
    }

    public Exercicio(Atividade atividade, int tempo, double caloria) {
        this.atividade = atividade;
        this.tempo = tempo;
        this.caloria = caloria;
    }

    public Exercicio() {
    }
}
