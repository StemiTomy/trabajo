package swing_2;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.w3c.dom.events.MouseEvent;

public class PanelTraductor extends JPanel implements ActionListener, MouseListener { // 3. Damos eventos y acciones al panel
    /*
    cuál ha sido el componente que generó el evento.
    Para ello se utiliza el método public Object getSource()
    declarado en laclase java.util.EventObject, clase padre de todos los eventos.
    */
    private Traductor traductor;
    private JLabel etiqueta;
    private JTextField campo;
    private JButton boton;
    private JButton botonCambioIdioma;
    private JLabel etiquetaIdioma;
    private Color colorAnterior;

    public PanelTraductor(Traductor traductor) { // 3. Damos eventos y acciones al panel
        this.traductor = traductor;

        etiqueta = new JLabel("Pulsa el boton para traducir");
        campo = new JTextField(20);
        boton = new JButton("Traducir");
        boton.addActionListener(this);

        botonCambioIdioma = new JButton("Invierte sentido traducción");
        etiquetaIdioma = new JLabel();

        this.muestraSentidoTraduccion(); 

        //Campo de texto asociado al gestor de eventos del boton
        boton.addActionListener(this);
        campo.addActionListener(this);
        botonCambioIdioma.addActionListener(this);

        etiqueta.addMouseListener(this);
        campo.addMouseListener(this);
        boton.addMouseListener(this);
        botonCambioIdioma.addMouseListener(this);
        etiquetaIdioma.addMouseListener(this); 

        this.add(campo);
        this.add(boton);
        this.add(etiqueta);
        this.add(botonCambioIdioma);
        this.add(etiquetaIdioma);
    }
    
    public void actionPerformed(ActionEvent e) { // 4. Maneja el evento
        if (e.getSource() == botonCambioIdioma) { // cogemos la información del evento
            traductor.invierteIdioma();
            this.muestraSentidoTraduccion();
        } else {
            etiqueta.setText(traductor.traducePalabra(
            campo.getText()));
        } 
        etiqueta.setText(traductor.traducePalabra(campo.getText()));
    }

    private void muestraSentidoTraduccion() {
        etiquetaIdioma.setText(Traductor.getCadenaIdioma(traductor.getIdiomaOrigen())+ " - " + Traductor.getCadenaIdioma(traductor.getIdiomaDestino()));
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        Component component = e.getComponent();
        component.setForeground(colorAnterior);
        //throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        Component component = e.getComponent();
        colorAnterior = component.getForeground();
        component.setForeground(java.awt.Color.BLUE);
        //throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

}
