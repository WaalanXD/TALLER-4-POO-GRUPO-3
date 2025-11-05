package actividad04.ejercicio05;
import java.io.*;


public class LeerArchivo {
    private String nombreArchivo = "actividad04/ejercicio05/txtPrueba.txt";
    private FileInputStream archivo; 
    private InputStreamReader conversor; 
    private BufferedReader filtro; 
    private String línea;
    private String contenido = "";

    public String verArchivo() {

        try {
            if (nombreArchivo.isEmpty()) {
                throw new IllegalArgumentException("El nombre del archivo no puede estar vacío.");
            }
            
            archivo = new FileInputStream(nombreArchivo);
            conversor = new InputStreamReader(archivo);
            filtro = new BufferedReader(conversor);
            línea = filtro.readLine();
            while (línea != null) {
                contenido += línea + "\n";
                línea = filtro.readLine(); 
            }
            filtro.close(); 
        } catch (IOException e) { 
            throw new RuntimeException("Error al leer el archivo: " +  e.getMessage());
            
        } 
        return contenido;
    }
}

