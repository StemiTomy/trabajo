package JAVA.Prueba_Trabajo.Swing.swing_1.src;
// Java program using label (swing)
// to display the message “GFG WEB Site Click”
import java.io.*;
import javax.swing.*;
import java.util.logging.Logger;



public class App {
    // Obtener un objeto Logger para la clase actual
    private static final Logger logger = Logger.getLogger(App.class.getName());
    public static void main(String[] args) throws Exception {
        logger.info("App iniciada!");

        /*
        // Creating instance of JFrame
        // ventana invisible, el parametro es el título
        JFrame frame = new JFrame("Titulo de la app.");

        // Creating instance of JButton
        // componente de la ventana
        JLabel label = new JLabel("LABEL");
        JButton button = new JButton("Button");

        frame.setSize(200,200);
        frame.setDefaultCloseOperation(3);
        frame.setResizable(true);

        frame.add(label);
        frame.add(button);

        frame.setVisible(true);
        */

        // Crear la ventana de la aplicacion
        JFrame ventana =
        new JFrame("Titulo de la ventana");

        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(
        JFrame.EXIT_ON_CLOSE);

        // Crear los componentes
        JLabel etiqueta1 = new JLabel("Texto etiqueta");
        JTextField campoDeTexto = new JTextField(20);
        JButton boton = new JButton("Botón");

        // Crear un contenedor
        JPanel panelDeContenido = new JPanel();

        // Asociar los componentes al contenedor para
        // que los muestre en su interior
        panelDeContenido.add(etiqueta1);
        panelDeContenido.add(campoDeTexto);
        panelDeContenido.add(boton);

        // Asociar el contenedor a la ventana para
        // que le muestre en su interior
        ventana.setContentPane(panelDeContenido);
        
        //Hacer visible la ventana
        ventana.setVisible(true); 
    }
}
