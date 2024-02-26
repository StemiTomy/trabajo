package swing_2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaTraductor extends JFrame implements ActionListener {
    private Traductor traductor;
    private JLabel etiqueta;
    private JTextField campo;
    private JButton boton;
    public VentanaTraductor(Traductor traductor) {
        this.traductor = traductor;
        this.setTitle("Traductor de Español a Inglés");
        JPanel panelContenido = new JPanel();
        this.setContentPane(panelContenido);
        boton = new JButton("Traducir");
        etiqueta = new JLabel("Pulsa el boton para traducir");
        campo = new JTextField(20);
        boton.addActionListener(this);
        panelContenido.add(campo);
        panelContenido.add(boton);
        panelContenido.add(etiqueta);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.setVisible(true); 
    }

    public void actionPerformed(ActionEvent e) {
        etiqueta.setText(traductor.traducePalabra(campo.getText()));
    }
}
