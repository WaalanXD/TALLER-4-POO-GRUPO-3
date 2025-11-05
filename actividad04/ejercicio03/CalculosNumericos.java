package actividad04.ejercicio03;

public class CalculosNumericos {

    public static double calcularLogaritmoNeperiano(double valor) {
        
        if (valor <= 0) {
            throw new IllegalArgumentException("Error: Ingrese un número positivo.");
        }
        return Math.log(valor);
    }

    public static  double calcularRaizCuadrada(double valor) {
  
        if (valor < 0) {
            throw new IllegalArgumentException("Error: Ingrese un número mayor o igual a cero.");
        }
        return Math.sqrt(valor);
    }


}

    

