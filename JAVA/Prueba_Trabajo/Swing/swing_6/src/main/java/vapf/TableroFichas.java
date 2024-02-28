package vapf;

import javax.swing.JPanel;

public class TableroFichas extends JPanel {
    public TableroFichas() {
        //Cuerpo del constructor...
        }
        public void addMoveListener(MoveListener l) {
            listenerList.add(MoveListener.class, l);
        }
        public void removeChangeListener(MoveListener l) {
            listenerList.remove(MoveListener.class, l);
        }
        //Método invocado cuando se quiere generar un evento
        protected void fireMovementPerformed(MoveEvent event) {
            Object[] listeners = listenerList.getListenerList();
            for (int i = listeners.length-2; i>=0; i-=2) {
                if (listeners[i]==MoveListener.class) {
                    ((MoveListener)listeners[i+1]).movementPerformed(event);
                }
            }
        } 
}
