package vapf;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EjemploBorderLayout {
    private JButton botonNorte;
    private JButton botonSur;
    private JButton botonEste;
    private JButton botonOeste;
    private JButton botonCentro;

    public EjemploBorderLayout() {
        JFrame ventana = new JFrame("Ejemplo Border Layout");
        ventana.setSize(300, 200);
        ventana
                .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.botonNorte = new JButton("NORTH");
        this.botonSur = new JButton("SOUTH");
        this.botonEste = new JButton("EAST");
        this.botonOeste = new JButton("WEST");
        this.botonCentro = new JButton("CENTER");

        JPanel panelDeContenido = new JPanel();
        panelDeContenido.setLayout(new BorderLayout());
        panelDeContenido.add(
                this.botonNorte, BorderLayout.NORTH);
        panelDeContenido.add(
                this.botonSur, BorderLayout.SOUTH);
        panelDeContenido.add(
                this.botonEste, BorderLayout.EAST);
        panelDeContenido.add(
                this.botonOeste, BorderLayout.WEST);
        panelDeContenido.add(
                this.botonCentro, BorderLayout.CENTER);
        ventana.setContentPane(panelDeContenido);
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploBorderLayout();
    }
}
