package vapf;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class EjemploMenu1 extends JFrame {
    public static void main(String[] args) {
        new EjemploMenu1();
    }

    public EjemploMenu1() {
        JMenu menuA = creaMenuFichero();
        JMenu menuB = creaMenuModoEdicion();

        JMenuBar barraMenus = new JMenuBar();
        barraMenus.add(menuA);
        barraMenus.add(menuB);

        this.setJMenuBar(barraMenus);
        this.setSize(200, 200);
        this.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private JMenu creaMenuModoEdicion() {

        JRadioButtonMenuItem itemA = new JRadioButtonMenuItem("Modo Binario");
        JRadioButtonMenuItem itemB = new JRadioButtonMenuItem("Modo Hexadecimal");
        JRadioButtonMenuItem itemC = new JRadioButtonMenuItem("Modo Decimal");

        itemA.setSelected(true);

        ButtonGroup bg = new ButtonGroup();
        bg.add(itemA);
        bg.add(itemB);
        bg.add(itemC);

        JMenu menu = new JMenu("Modo Edición");
        menu.add(itemA);
        menu.add(itemB);
        menu.add(itemC);

        return menu;
    }

    private JMenu creaMenuFichero() {

        JMenuItem itemAA = new JMenuItem("Proyecto");
        JMenuItem itemAB = new JMenuItem("Clase");
        JMenuItem itemAC = new JMenuItem("Paquete");

        JMenu menuAA = new JMenu("Nuevo");
        menuAA.add(itemAA);
        menuAA.add(itemAB);
        menuAA.add(itemAC);

        JMenuItem itemB = new JMenuItem("Abrir");
        JMenuItem itemC = new JMenuItem("Cerrar");

        JMenuItem itemAD = new JMenuItem("Salir");

        JMenu menu = new JMenu("Fichero");
        menu.add(menuAA);
        menu.add(itemB);
        menu.add(itemC);
        menu.addSeparator();
        menu.add(itemAD);

        return menu;
    }

}
