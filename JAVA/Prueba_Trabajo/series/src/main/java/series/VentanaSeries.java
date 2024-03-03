package series;

import javax.swing.JFrame;

public class VentanaSeries extends JFrame{ // 2. Creamos ventana
    public VentanaSeries(){
        this.setContentPane(new PanelSeries()); // TODO: falta parametro lógico
        this.setTitle("Series");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack(); 
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaSeries();
    }
}
