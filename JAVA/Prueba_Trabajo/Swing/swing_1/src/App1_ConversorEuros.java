package JAVA.Prueba_Trabajo.Swing.swing_1.src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App1_ConversorEuros implements ActionListener{
    private JLabel etiqueta1;
    private JTextField campoDeTexto;
    private JButton boton;
    private JLabel etiqueta2;

    public App1_ConversorEuros() {
        // Crear la ventana de la aplicacion
        JFrame ventana = new JFrame("Conversor de Euros a pesetas");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los componentes
        etiqueta1 = new JLabel("Importe en Euros"); 
        campoDeTexto = new JTextField(20);
        boton = new JButton("Convertir");
        etiqueta2 = new JLabel("Pulse para obtener el importe en pesetas");

        // Crear un contenedor
        JPanel panelDeContenido = new JPanel();

        // Configurar el contenedor para mostrar los
        // componentes cuando se muestre.
        panelDeContenido.add(etiqueta1);
        panelDeContenido.add(campoDeTexto);
        panelDeContenido.add(boton);
        panelDeContenido.add(etiqueta2);

        // Configurar la ventana para mostrar el panel
        // cuando se muestre
        ventana.setContentPane(panelDeContenido);

        // ASOCIACIÓN DEL CÓDIGO DE MANEJO DE EVENTOS
        boton.addActionListener(this);

        // HACER VISIBLE LA VENTANA
        ventana.setVisible(true); 
    }

    public void actionPerformed(Action e) {
        // CÓDIGO DE MANEJO DE EVENTOS
        try {
        double euros = Double.parseDouble(campoDeTexto.getText());
        double pesetas = euros * 166.386;
        etiqueta2.setText("Equivale a " + pesetas + " pesetas");
        } catch (NumberFormatException e2) {
            etiqueta2.setText("En el campo de texto no hay un número");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Código de manejo de eventos
        try {
            double euros = Double.parseDouble(campoDeTexto.getText());
            double pesetas = euros * 166.386;
            etiqueta2.setText("Equivale a " + pesetas + " pesetas");
        } catch (NumberFormatException ex) {
            etiqueta2.setText("En el campo de texto no hay un número");
        }
    }

    public static void main(String[] args) {
        new App1_ConversorEuros();
    }

}
