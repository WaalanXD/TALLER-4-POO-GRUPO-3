package actividad04.ejercicio04;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    
    
    private Container contenedor;
    
    private JTextField nombreEquipoField, universidadField, lenguajeField, nombreIntegrante1Field, 
    apellidoIntegrante1Field, nombreIntegrante2Field, apellidoIntegrante2Field, nombreIntegrante3Field, 
    apellidoIntegrante3Field;

    private JLabel nombreEquipoLabel, datosIntegrantesLabel, universidadLabel, lenguajeLabel, nombreIntegrante1Label, 
    apellidoIntegrante1Label, nombreIntegrante2Label, apellidoIntegrante2Label, nombreIntegrante3Label, apellidoIntegrante3Label, mensajeLabel;

    private JButton ingresarButton, borrarButton;

    public VentanaPrincipal() {
        inicio();
        setTitle("Registro de Equipo de Programación");
       
        setSize(600, 560);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicio() {

        contenedor = getContentPane();
        contenedor.setLayout(null);

        nombreEquipoLabel = new JLabel("Nombre del Equipo:");
        nombreEquipoLabel.setBounds(30, 30, 150, 25);
        contenedor.add(nombreEquipoLabel);

        nombreEquipoField = new JTextField();
        nombreEquipoField.setBounds(200, 30, 200, 25);
        contenedor.add(nombreEquipoField);

        universidadLabel = new JLabel("Universidad:");
        universidadLabel.setBounds(30, 70, 150, 25);
        contenedor.add(universidadLabel);

        universidadField = new JTextField();
        universidadField.setBounds(200, 70, 200, 25);
        contenedor.add(universidadField);

        lenguajeLabel = new JLabel("Lenguaje de Programación:");
        lenguajeLabel.setBounds(30, 110, 170, 25);
        contenedor.add(lenguajeLabel);

        lenguajeField = new JTextField();
        lenguajeField.setBounds(200, 110, 200, 25);
        contenedor.add(lenguajeField);

        datosIntegrantesLabel = new JLabel("Datos de los Integrantes:");
        datosIntegrantesLabel.setBounds(30, 150, 200, 25);
        contenedor.add(datosIntegrantesLabel);


        nombreIntegrante1Label = new JLabel("Nombre Integrante 1:");
        nombreIntegrante1Label.setBounds(30, 190, 150, 25);
        contenedor.add(nombreIntegrante1Label);

        nombreIntegrante1Field = new JTextField();
        nombreIntegrante1Field.setBounds(200, 190, 200, 25);
        contenedor.add(nombreIntegrante1Field);

        apellidoIntegrante1Label = new JLabel("Apellido Integrante 1:");
        apellidoIntegrante1Label.setBounds(30, 230, 150, 25);
        contenedor.add(apellidoIntegrante1Label);

        apellidoIntegrante1Field = new JTextField();
        apellidoIntegrante1Field.setBounds(200, 230, 200, 25);
        contenedor.add(apellidoIntegrante1Field);

   
        nombreIntegrante2Label = new JLabel("Nombre Integrante 2:");
        nombreIntegrante2Label.setBounds(30, 270, 150, 25);
        contenedor.add(nombreIntegrante2Label);

        nombreIntegrante2Field = new JTextField();
        nombreIntegrante2Field.setBounds(200, 270, 200, 25);
        contenedor.add(nombreIntegrante2Field);

        apellidoIntegrante2Label = new JLabel("Apellido Integrante 2:");
        apellidoIntegrante2Label.setBounds(30, 310, 150, 25);
        contenedor.add(apellidoIntegrante2Label);

        apellidoIntegrante2Field = new JTextField();
        apellidoIntegrante2Field.setBounds(200, 310, 200, 25);
        contenedor.add(apellidoIntegrante2Field);

 
        nombreIntegrante3Label = new JLabel("Nombre Integrante 3:");
        nombreIntegrante3Label.setBounds(30, 350, 150, 25);
        contenedor.add(nombreIntegrante3Label);

        nombreIntegrante3Field = new JTextField();
        nombreIntegrante3Field.setBounds(200, 350, 200, 25);
        contenedor.add(nombreIntegrante3Field);

        apellidoIntegrante3Label = new JLabel("Apellido Integrante 3:");
        apellidoIntegrante3Label.setBounds(30, 390, 150, 25);
        contenedor.add(apellidoIntegrante3Label);

        apellidoIntegrante3Field = new JTextField();
        apellidoIntegrante3Field.setBounds(200, 390, 200, 25);
        contenedor.add(apellidoIntegrante3Field);

        ingresarButton = new JButton("Ingresar");
        ingresarButton.setBounds(100, 430, 100, 25);
        contenedor.add(ingresarButton);
        ingresarButton.addActionListener(this);

        borrarButton = new JButton("Borrar");
        borrarButton.setBounds(250, 430, 100, 25);
        contenedor.add(borrarButton);
        borrarButton.addActionListener(this);

        mensajeLabel = new JLabel("");
        mensajeLabel.setBounds(30, 460, 400, 25);
        contenedor.add(mensajeLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

        if (e.getSource() == ingresarButton) {

            String nombreEquipo = nombreEquipoField.getText();
            String universidad = universidadField.getText();
            String lenguaje = lenguajeField.getText();

            String nombre1 = nombreIntegrante1Field.getText();
            String apellido1 = apellidoIntegrante1Field.getText();
            Programador integrante1 = new Programador(nombre1, apellido1);

            String nombre2 = nombreIntegrante2Field.getText();
            String apellido2 = apellidoIntegrante2Field.getText();
            Programador integrante2 = new Programador(nombre2, apellido2);

            String nombre3 = nombreIntegrante3Field.getText();
            String apellido3 = apellidoIntegrante3Field.getText();
            Programador integrante3 = new Programador(nombre3, apellido3);

            EquipoMaratonProgramacion equipo = new EquipoMaratonProgramacion(nombreEquipo, universidad, lenguaje);
                EquipoMaratonProgramacion.validarCampo(nombreEquipo);
                EquipoMaratonProgramacion.validarCampo(universidad);
                EquipoMaratonProgramacion.validarCampo(lenguaje);
                EquipoMaratonProgramacion.validarCampo(nombre1);
                EquipoMaratonProgramacion.validarCampo(apellido1);
                EquipoMaratonProgramacion.validarCampo(nombre2);
                EquipoMaratonProgramacion.validarCampo(apellido2);
                EquipoMaratonProgramacion.validarCampo(nombre3);
                EquipoMaratonProgramacion.validarCampo(apellido3);
                equipo.añadir(integrante1);
                equipo.añadir(integrante2);
                equipo.añadir(integrante3);
                mensajeLabel.setForeground(Color.GREEN);
                mensajeLabel.setText("Equipo registrado con éxito.");

        } else if (e.getSource() == borrarButton) {
            nombreEquipoField.setText("");
            universidadField.setText("");
            lenguajeField.setText("");
            nombreIntegrante1Field.setText("");
            apellidoIntegrante1Field.setText("");
            nombreIntegrante2Field.setText("");
            apellidoIntegrante2Field.setText("");
            nombreIntegrante3Field.setText("");
            apellidoIntegrante3Field.setText("");
            mensajeLabel.setText("");
        }

        } catch (Exception ex) {
            ex.printStackTrace();
            mensajeLabel.setForeground(Color.RED);
            mensajeLabel.setText("Error: " + ex.getMessage());
            
        }
        

      
    }

}

