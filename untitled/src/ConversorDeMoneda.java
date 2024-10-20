import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ConversorDeMoneda {
        private String monedaBase;
        private String monedaConvercion;

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaConvercion() {
        return monedaConvercion;
    }

    public void setMonedaConvercion(String monedaConvercion) {
        this.monedaConvercion = monedaConvercion;
    }


    public Moneda convierteMoneda (int cantidad){

        String direccion = "https://v6.exchangerate-api.com/v6/f9a8bd9c03122e5d5de014f0/pair/"
                +monedaBase+"/"+monedaConvercion+"/"+cantidad;



        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
            try {
                HttpResponse<String> response;
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                return new Gson().fromJson(response.body(),Moneda.class);

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Error en la conversion del valor");
            }

    }
}
