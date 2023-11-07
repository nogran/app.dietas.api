package enums;

import java.util.Arrays;

public enum TipoRefeicaoEnum {
    CAFE_DA_MANHA("Cafe da Manha"),
    ALMOCO("Almoco"),
    LANCHE("Lanche"),
    JANTA("Janta");

    private final String tipo;

    TipoRefeicaoEnum(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void listarValores() {
        Arrays.stream(TipoRefeicaoEnum.values()).toList().forEach(i -> System.out.println(i.getTipo()));
    }

    public static TipoRefeicaoEnum getTipo(String tipo) {
        for (TipoRefeicaoEnum objetivo : TipoRefeicaoEnum.values()) {
            if (objetivo.getTipo().equalsIgnoreCase(tipo)) {
                return objetivo;
            }
        }
        throw new IllegalArgumentException("Objetivo não encontrado para o tipo: " + tipo);
    }

}