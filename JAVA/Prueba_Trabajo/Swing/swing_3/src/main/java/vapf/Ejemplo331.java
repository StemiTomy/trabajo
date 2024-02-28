package vapf;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ejemplo331 {
    public Ejemplo331() {

        JFrame ventana = new JFrame("Ejemplo 3.3.1");
        ventana.setSize(300, 200);
        ventana.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        JButton boton1 = new JButton("Botón 1");
        JButton boton2 = new JButton("Botón 2");
        JButton boton3 = new JButton("Botón 3");
        JButton boton4 = new JButton("Botón 4");

        JPanel panelDeContenido = new JPanel();
        panelDeContenido.setLayout(new GridBagLayout());

        GridBagConstraints config1 = new GridBagConstraints();
        config1.gridx = 0;
        config1.gridy = 0;
        panelDeContenido.add(boton1, config1);

        GridBagConstraints config2 = new GridBagConstraints();
        config2.gridx = 1;
        config2.gridy = 0;
        panelDeContenido.add(boton2, config2);

        GridBagConstraints config3 = new GridBagConstraints();
        config3.gridx = 0;
        config3.gridy = 1;
        panelDeContenido.add(boton3, config3);

        GridBagConstraints config4 = new GridBagConstraints();
        config4.gridx = 1;
        config4.gridy = 1;
        panelDeContenido.add(boton4, config4);
        ventana.setContentPane(panelDeContenido);
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        new Ejemplo331();
    }
}
