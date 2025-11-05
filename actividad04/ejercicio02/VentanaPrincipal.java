package actividad04.ejercicio02;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {


    private Container contenedor;
    private JButton mostrarButton;
    private JButton limpiarButton;
    private JLabel nombreLabel;
    private JLabel apellidoLabel;
    private JLabel edadLabel;
    private JTextField nombreTextField;
    private JTextField apellidoTextField;
    private JTextField edadTextField;
    private JTextArea resultadoTextArea;
    private JLabel mensajeLabel;

    public VentanaPrincipal() {
        inicio();
        setTitle("Registro de Vendedor");
        setSize(400, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(10, 10, 100, 20);
        contenedor.add(nombreLabel);
        nombreTextField = new JTextField();
        nombreTextField.setBounds(120, 10, 200, 20);
        contenedor.add(nombreTextField);
        apellidoLabel = new JLabel("Apellido:");
        apellidoLabel.setBounds(10, 40, 100, 20);
        contenedor.add(apellidoLabel);
        apellidoTextField = new JTextField();
        apellidoTextField.setBounds(120, 40, 200, 20);
        contenedor.add(apellidoTextField);
        edadLabel = new JLabel("Edad:");
        edadLabel.setBounds(10, 70, 100, 20);
        contenedor.add(edadLabel);
        edadTextField = new JTextField();
        edadTextField.setBounds(120, 70, 200, 20);
        contenedor.add(edadTextField);
        mostrarButton = new JButton("Mostrar Datos");
        mostrarButton.setBounds(10, 100, 150, 30);
        contenedor.add(mostrarButton);
        resultadoTextArea = new JTextArea();
        resultadoTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoTextArea);
        scrollPane.setBounds(10, 140, 350, 200);
        contenedor.add(scrollPane);

        mensajeLabel = new JLabel();
        mensajeLabel.setBounds(10, 350, 350, 20);
        contenedor.add(mensajeLabel);

        limpiarButton = new JButton("Limpiar");
        limpiarButton.setBounds(200, 100, 150, 30);
        contenedor.add(limpiarButton);

        mostrarButton.addActionListener(this);
        limpiarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            
            if (e.getSource() == mostrarButton) {
            String nombre = nombreTextField.getText();
            String apellido = apellidoTextField.getText();
            int edad = Integer.parseInt(edadTextField.getText());

            Vendedor vendedor = new Vendedor(nombre, apellido);
            vendedor.verificarEdad(edad);


            resultadoTextArea.setText(vendedor.mostrarDatos());
            mensajeLabel.setForeground(Color.GREEN);
            mensajeLabel.setText("Datos mostrados correctamente.");

        } else if (e.getSource() == limpiarButton) {
            nombreTextField.setText("");
                apellidoTextField.setText("");
                edadTextField.setText("");
                resultadoTextArea.setText("");
                mensajeLabel.setText("");
            }


        } catch (NumberFormatException ex) {
            mensajeLabel.setForeground(Color.RED);
            mensajeLabel.setText("Error: La edad debe ser un número.");
            resultadoTextArea.setText("");
            
        } catch (Exception ex) {
            mensajeLabel.setForeground(Color.RED);
            mensajeLabel.setText("Error: " + ex.getMessage());
            resultadoTextArea.setText("");
            
        }
    }

        
}