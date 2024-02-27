package swing_2;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseListener; 

public class GestorEventosRollOver implements MouseListener{
    private Color colorAnterior;

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
        // TODO Auto-generated method stub
        Component comp = e.getComponent();
        colorAnterior = comp.getForeground();
        comp.setForeground(java.awt.Color.BLUE);
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        Component comp = e.getComponent();
        comp.setForeground(colorAnterior);
    }
}
