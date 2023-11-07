package entidade;

public class Atividade {
    private String nome;
    private float met;

    public Atividade(String nome, float met) {
        this.nome = nome;
        this.met = met;
    }

    public Atividade() {
    }

    public String getNome() {
        return nome;
    }

    public float getMet() {
        return met;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMet(float met) {
        this.met = met;
    }

}
