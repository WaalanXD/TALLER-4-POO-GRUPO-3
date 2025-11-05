package actividad04.ejercicio04;

public class EquipoMaratonProgramacion {

    private String nombreEquipo;
    private String universidad;
    private String lenguajeProgramacion;
    private Programador[] programadores;
    private int tamañoEquipo;


    public EquipoMaratonProgramacion() {

        this.nombreEquipo = "Sin nombre";
        this.universidad = "Sin universidad";
        this.lenguajeProgramacion = "Sin lenguaje";
        this.tamañoEquipo = 0;
        this.programadores = new Programador[0];
    }

    public EquipoMaratonProgramacion(String nombreEquipo, String universidad, String lenguajeProgramacion) {
        this.nombreEquipo = nombreEquipo;
        this.universidad = universidad;
        this.lenguajeProgramacion = lenguajeProgramacion;
        this.tamañoEquipo = 0;
        this.programadores = new Programador[3];
    }

    boolean estaLleno() {
        return tamañoEquipo == programadores.length;
    }

    void añadir(Programador p) throws Exception {
 
        if (estaLleno() == true) {
            throw new Exception("El equipo esta completo. No se pueden agregar más programadores.");
        }
        programadores[tamañoEquipo] = p;
        tamañoEquipo++;

    }

    static void validarCampo(String campo) throws Exception {

        for (int i = 0; i < campo.length(); i++) {
            char c = campo.charAt(i);
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException("Los campos no deben contener números.");

            }

        }
        
        if (campo.trim().isEmpty()) {
            throw new IllegalArgumentException("Los campos no deben estar vacíos.");
        }

        if (campo.length() > 20) {
            throw new IllegalArgumentException("Cada campo debe tener un máximo de 20 caracteres.");
        }

        if (campo.length() < 3) {
            throw new IllegalArgumentException("Cada campo debe tener al menos 3 caracteres.");
        }
    }


}



