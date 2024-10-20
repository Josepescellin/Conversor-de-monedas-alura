import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        ConversorDeMoneda convertir = new ConversorDeMoneda();
        int valorDeUsuario = 0;
        int contador=0;

        List<String> divisas= new ArrayList<>();


        String menu = """
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real Brasileño
                4) Real Brasileño =>> Dólar
                5) Dólar =>> Peso Colombiano
                6) Peso Colombiano =>> Dólar
                7) Salir
                """;

        String mensaje = "Ingrese el valor que desea convertir:";

        System.out.println("***********************");
        System.out.println("Bienvenido al conversor de Monedas");
        System.out.println("Escoja una de las siguientes conversiones a ejecutar=");
        System.out.println("\n" + menu);
        System.out.println("\n***********************");

        Moneda moneda = null;
        String divisa = null;
        try {

            while (valorDeUsuario != 7) {
                if (contador > 0) {
                    System.out.println("***********************");
                    System.out.println("Escoja una de las siguientes conversiones a ejecutar=");
                    System.out.println("\n" + menu);
                    System.out.println("\n***********************");
                }
                valorDeUsuario = teclado.nextInt();


                switch (valorDeUsuario) {
                    case 1:
                        System.out.println(mensaje);
                        convertir.setMonedaBase("USD");
                        convertir.setMonedaConvercion("ARS");
                        var cantidad = Integer.valueOf(teclado.nextInt());

                        moneda = convertir.convierteMoneda(cantidad);
                        divisa = "El valor de " + cantidad + " " + convertir.getMonedaBase() +" " + new Divisa(moneda) + " "+ convertir.getMonedaConvercion();
                        System.out.println(divisa);

                        break;

                    case 2:
                        System.out.println(mensaje);
                        convertir.setMonedaBase("ARS");
                        convertir.setMonedaConvercion("USD");
                        cantidad = Integer.valueOf((int) teclado.nextDouble());

                        moneda = convertir.convierteMoneda((int) cantidad);
                        divisa = "El valor de " + cantidad + " " + convertir.getMonedaBase() +" " + new Divisa(moneda) + " "+ convertir.getMonedaConvercion();
                        System.out.println(divisa);


                        break;

                    case 3:
                        System.out.println(mensaje);
                        convertir.setMonedaBase("USD");
                        convertir.setMonedaConvercion("BRL");
                        cantidad = Integer.valueOf((int) teclado.nextDouble());

                        moneda = convertir.convierteMoneda((int) cantidad);
                        divisa = "El valor de " + cantidad + " " + convertir.getMonedaBase() +" " + new Divisa(moneda) + " "+ convertir.getMonedaConvercion();
                        System.out.println(divisa);

                        break;

                    case 4:
                        System.out.println(mensaje);
                        convertir.setMonedaBase("BRL");
                        convertir.setMonedaConvercion("USD");
                        cantidad = Integer.valueOf((int) teclado.nextDouble());

                        moneda = convertir.convierteMoneda((int) cantidad);
                        divisa = "El valor de " + cantidad + " " + convertir.getMonedaBase() +" " + new Divisa(moneda) + " "+ convertir.getMonedaConvercion();
                        System.out.println(divisa);

                        break;

                    case 5:
                        System.out.println(mensaje);
                        convertir.setMonedaBase("USD");
                        convertir.setMonedaConvercion("COP");
                        cantidad = Integer.valueOf((int) teclado.nextDouble());

                        moneda = convertir.convierteMoneda((int) cantidad);
                        divisa = "El valor de " + cantidad + " " + convertir.getMonedaBase() +" " + new Divisa(moneda) + " "+ convertir.getMonedaConvercion();
                        System.out.println(divisa);

                        break;

                    case 6:
                        System.out.println(mensaje);
                        convertir.setMonedaBase("COP");
                        convertir.setMonedaConvercion("USD");
                        cantidad = Integer.valueOf((int) teclado.nextDouble());

                        moneda = convertir.convierteMoneda((int) cantidad);
                        divisa = "El valor de " + cantidad + " " + convertir.getMonedaBase() +" " + new Divisa(moneda) + " "+ convertir.getMonedaConvercion();
                        System.out.println(divisa);

                        break;

                }
                contador++;
                divisas.add(divisa);
            }
        } catch (Exception e) {
            System.out.println("Error en la conversion" + e.getMessage());
        }
        System.out.println("Cerrando programa!!");

        GuardarHistorial conversiones = new GuardarHistorial();
        conversiones.historial(divisas);
    }
}

