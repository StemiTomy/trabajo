package swing_2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelTraductor extends JPanel implements ActionListener{
    private Traductor traductor;
    private JLabel etiqueta;
    private JTextField campo;
    private JButton boton;
    public PanelTraductor(Traductor traductor) {
        this.traductor = traductor;
        boton = new JButton("Traducir");
        etiqueta = new JLabel("Pulsa el boton para traducir");
        campo = new JTextField(20);
        boton.addActionListener(this);
        this.add(campo);
        this.add(boton);
        this.add(etiqueta);
    }
    
    public void actionPerformed(ActionEvent e) {
        etiqueta.setText(traductor.traducePalabra(campo.getText()));
    }
}
