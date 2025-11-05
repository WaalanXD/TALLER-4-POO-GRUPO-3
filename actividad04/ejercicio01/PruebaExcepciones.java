package actividad04.ejercicio01;

public class PruebaExcepciones {
    

    public static double calcularDivision(double numerador, double denominador) {

        if (denominador == 0) {
            throw new IllegalArgumentException("División por cero no permitida.");
        }
        return numerador / denominador;

    }
 
    public static String ObtenerMensaje(String mensaje) {
        if (mensaje.isEmpty() == false) {
            return mensaje;
            
        } 

        return "texto vacío";
    }
}