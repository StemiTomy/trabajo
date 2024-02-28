package vapf;
import javax.swing.JFrame;

public class VentanaTraductor extends JFrame { // 2. Creamos panel
    public VentanaTraductor(Traductor traductor) {
        this.setContentPane(new PanelTraductor(traductor));
        this.setTitle("Traductor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack(); 
        this.setVisible(true);
    }
} 