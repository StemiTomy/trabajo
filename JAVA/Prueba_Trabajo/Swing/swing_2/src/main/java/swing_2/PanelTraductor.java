package swing_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelTraductor extends JPanel { // 3. Damos eventos y acciones al panel
    /*
     * cuál ha sido el componente que generó el evento.
     * Para ello se utiliza el método public Object getSource()
     * declarado en laclase java.util.EventObject, clase padre de todos los eventos.
     */
    private Traductor traductor;

    private JLabel etiqueta;
    private JTextField campo;
    private JButton boton;
    private JButton botonCambioIdioma;
    private JLabel etiquetaIdioma;

    public PanelTraductor(Traductor traductor) { // 3. Damos eventos y acciones al panel
        this.traductor = traductor;

        etiqueta = new JLabel("Pulsa el boton para traducir");
        campo = new JTextField(20);
        boton = new JButton("Traducir");

        botonCambioIdioma = new JButton("Invierte sentido traducción");
        etiquetaIdioma = new JLabel();

        this.muestraSentidoTraduccion();

        // Campo de texto asociado al gestor de eventos del boton
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                traduce();
            }
        });
        campo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                traduce();
            }
        });
        botonCambioIdioma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                invierteSentidoTraduccion();
            }
        });

        GestorEventosRollOver gestor = new GestorEventosRollOver();

        etiqueta.addMouseListener(gestor);
        campo.addMouseListener(gestor);
        boton.addMouseListener(gestor);
        botonCambioIdioma.addMouseListener(gestor);
        etiquetaIdioma.addMouseListener(gestor);

        this.add(campo);
        this.add(boton);
        this.add(etiqueta);
        this.add(botonCambioIdioma);
        this.add(etiquetaIdioma);
    }

    protected void invierteSentidoTraduccion() {
        traductor.invierteIdioma();
        this.muestraSentidoTraduccion();
    }

    protected void traduce() {
        etiqueta.setText(traductor.traducePalabra(campo.getText()));
    }

    private void muestraSentidoTraduccion() {
        etiquetaIdioma.setText(Traductor.getCadenaIdioma(traductor.getIdiomaOrigen()) + " - "
                + Traductor.getCadenaIdioma(traductor.getIdiomaDestino()));
    }

}
