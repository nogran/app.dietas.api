package entidade;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private float peso;
    private int altura;
    private String sexo;
    private String objetivo;
    private float metabolismoBasal;
    private List<DiarioExercicios> diarioExercicios;
    private List<Refeicao> refeicoes;
    private Date dataCriacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public float getMetabolismoBasal() {
        return metabolismoBasal;
    }

    public void setMetabolismoBasal(float metabolismoBasal) {
        this.metabolismoBasal = metabolismoBasal;
    }

    public List<DiarioExercicios> getDiarioExercicios() {
        return diarioExercicios;
    }

    public void setDiarioExercicios(List<DiarioExercicios> diarioExercicios) {
        this.diarioExercicios = diarioExercicios;
    }

    public List<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(List<Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario(String nome, String email, LocalDate dataNascimento, float peso, int altura, String sexo, String objetivo) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
        this.objetivo = objetivo;
    }

    public Usuario() {
    }
}
