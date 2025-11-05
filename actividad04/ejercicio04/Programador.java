package actividad04.ejercicio04;

public class Programador {
    
    private String nombre;
    private String apellido;

    public Programador() {
        this.nombre = "Sin nombre";
        this.apellido = "Sin apellido";
    }

    public Programador(String nombre, String apellido) {
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

}
