package actividad04.ejercicio02;

public class Vendedor {

    private String nombre;
    private String apellido;
    private int edad;

    public Vendedor() {
        this.nombre = "Sin nombre";
        this.apellido = "Sin apellido";
        this.edad = 0;
        

    }

    public Vendedor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    String mostrarDatos() {
        if (nombre.trim().isEmpty() || apellido.trim().isEmpty() || edad == 0) {
            throw new IllegalArgumentException("Todos los campos deben estar completos");
            
        }
        return "Nombre: " + nombre + "\nApellido: " + apellido + "\nEdad: " + edad;






        



    }

    boolean verificarEdad(int edad) {
      
        if (!(edad >= 0 && edad <= 120)) {
            throw new IllegalArgumentException("La edad no puede ser negativa ni mayor a 120.");
        }
        else if (edad < 18) {
            throw new IllegalArgumentException("El vendedor debe ser mayor de edad.");
        }
        else {
            this.edad = edad;
            return true;
        }


    }
}
