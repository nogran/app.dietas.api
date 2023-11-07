package enums;

public enum ObjetivoEnum {
    Hipertrofia("Hipertrofia"),
    Definicao("Definicao"),
    ManterPeso("Manter Peso");

    private final String value;

    ObjetivoEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
