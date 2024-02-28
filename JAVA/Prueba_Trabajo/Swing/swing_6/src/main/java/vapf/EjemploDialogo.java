package vapf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EjemploDialogo {
    public static void main(String[] args) {
        new EjemploDialogo();
    }

    public EjemploDialogo() {
        JFrame ventana = new JFrame("Ventana (JFrame)");
        ventana.setSize(200, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JDialog dialogo = createJDialog(ventana);
        JButton boton = new JButton("Boton Ventana");
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialogo.setVisible(true);
            }
        });
        JPanel panelContenido = new JPanel();
        panelContenido.add(boton);

        ventana.setContentPane(panelContenido);
        ventana.setVisible(true);
    }

    public JDialog createJDialog(JFrame ventana) {
        final JDialog dialogo = new JDialog(ventana, "Dialogo (JDialog)");
        dialogo.setModal(true);
        dialogo.setSize(200, 200);
        dialogo.setLocation(50, 50);
        JButton boton = new JButton("Boton Dialogo");
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialogo.setVisible(false);
            }
        });
        JPanel panelContenido = new JPanel();
        panelContenido.add(boton);

        dialogo.setContentPane(panelContenido);
        return dialogo;
    }
}
