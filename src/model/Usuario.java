package model;

import java.util.List;

public class Usuario {
    private int idade;
    private float peso;
    private int altura;
    private float metabolismoBasal;
    private String objetivo;
    private String sexo;
    private List<Float> macronutrientes;
    private List<DiarioAtividades> diarioAtividades;
    private List<DiarioRefeicoes> diarioRefeicoes;

    public void calcularMetabolismoBasal() {
        int idade = this.idade;
        String sexo = this.sexo;

        int coeficiente = 0;
        if (sexo.equals('M')) {
            coeficiente = 5;
        } else if (sexo.equals("F")) {
            coeficiente = -161;
        }
        this.metabolismoBasal = (10 * peso) * 6.25F * altura - (5 * idade) + coeficiente;
    }

    public List<DiarioRefeicoes> consultarHistoricoRefeicoes() {
        return this.diarioRefeicoes;
    }

    public List<DiarioAtividades> consultarHistoricoAtividades() {
        return this.diarioAtividades;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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

    public List<Float> getMacronutrientes() {
        return macronutrientes;
    }

    public void setMacronutrientes(List<Float> macronutrientes) {
        this.macronutrientes = macronutrientes;
    }

    public List<DiarioAtividades> getDiarioAtividades() {
        return diarioAtividades;
    }

    public void setDiarioAtividades(List<DiarioAtividades> diarioAtividades) {
        this.diarioAtividades = diarioAtividades;
    }

    public List<DiarioRefeicoes> getDiarioRefeicoes() {
        return diarioRefeicoes;
    }

    public void setDiarioRefeicoes(List<DiarioRefeicoes> diarioRefeicoes) {
        this.diarioRefeicoes = diarioRefeicoes;
    }

    public Usuario(int idade, float peso, int altura, String sexo, List<Float> macronutrientes,
                   List<DiarioAtividades> diarioAtividades, List<DiarioRefeicoes> diarioRefeicoes) {
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
        this.macronutrientes = macronutrientes;
        this.diarioAtividades = diarioAtividades;
        this.diarioRefeicoes = diarioRefeicoes;
    }
}
