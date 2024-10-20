import com.google.gson.annotations.SerializedName;

public class Divisa {
 private double valor;

    public Divisa(Moneda moneda) {
        this.valor= Double.parseDouble(moneda.conversion_result());
    }

    @Override
    public String toString() {
        return "corresponde a "+ valor;
    }
}


