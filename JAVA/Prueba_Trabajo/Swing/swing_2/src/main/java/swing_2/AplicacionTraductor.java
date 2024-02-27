package swing_2;

public class AplicacionTraductor {
    public AplicacionTraductor() { // 1. Creamos ventana
        new VentanaTraductor(new Traductor());
    }
    public static void main(String args[]) {
        new AplicacionTraductor();
    }
}
