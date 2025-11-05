package actividad04.ejercicio05;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class VentanaPrincipal extends JFrame implements ActionListener {

    private Container contenedor;
    private JButton botonCargar;
    private JTextArea areaTexto;
    private JScrollPane scrollPane;
    private JButton limpiarButton;
    private JTextArea mensajeArea;

    public VentanaPrincipal() {
        inicio();
        setTitle("Contenido del Archivo de Texto");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        botonCargar = new JButton("Cargar Archivo");
        botonCargar.setBounds(20, 20, 140, 30);
        botonCargar.addActionListener(this);
        contenedor.add(botonCargar);

        limpiarButton = new JButton("Limpiar");
        limpiarButton.setBounds(180, 20, 100, 30);
        limpiarButton.addActionListener(this);
        contenedor.add(limpiarButton);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        contenedor.add(areaTexto);
        scrollPane = new JScrollPane(areaTexto);
        scrollPane.setBounds(20, 70, 450, 280);
        contenedor.add(scrollPane);

    mensajeArea = new JTextArea("");
    mensajeArea.setEditable(false);
    mensajeArea.setLineWrap(true);
    mensajeArea.setWrapStyleWord(true);
    mensajeArea.setOpaque(false); 
    mensajeArea.setBounds(20, 360, 450, 60);
    contenedor.add(mensajeArea);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
        if (e.getSource() == botonCargar) {
            LeerArchivo lector = new LeerArchivo();
            String contenido = lector.verArchivo();
            areaTexto.setText(contenido);
            mensajeArea.setForeground(Color.GREEN);
            mensajeArea.setText("Archivo cargado correctamente.");
        } else if (e.getSource() == limpiarButton) {
            areaTexto.setText("");
            mensajeArea.setText("");
        }
    } catch (Exception ex) {
        mensajeArea.setForeground(Color.RED);

        mensajeArea.setText(ex.getMessage());
        ex.printStackTrace();

    }


}

}

