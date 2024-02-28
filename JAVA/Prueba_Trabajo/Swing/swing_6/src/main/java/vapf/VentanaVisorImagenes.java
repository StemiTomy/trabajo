package vapf;

import javax.swing.JFrame;

public class VentanaVisorImagenes extends JFrame {
    public VentanaVisorImagenes() {
        this.setTitle("Visor de imagenes");
        this.setContentPane(new MalVisorImagenes());

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}