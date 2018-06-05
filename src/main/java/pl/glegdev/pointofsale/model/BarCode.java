package pl.glegdev.pointofsale.model;

public class BarCode {

    private String value;

    public BarCode(String code) {
        this.value = code;
    }

    public String getValue() {
        return value;
    }
}
