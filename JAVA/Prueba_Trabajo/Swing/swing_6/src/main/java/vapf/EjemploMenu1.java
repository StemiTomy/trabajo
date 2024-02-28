package vapf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

public class EjemploMenu1 extends JFrame implements
        ActionListener, ItemListener {
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

        itemA.addItemListener(this);
        itemB.addItemListener(this);
        itemC.addItemListener(this);

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

        itemAA.addActionListener(this);
        itemAB.addActionListener(this);
        itemAC.addActionListener(this);

        JMenu menuAA = new JMenu("Nuevo");
        menuAA.add(itemAA);
        menuAA.add(itemAB);
        menuAA.add(itemAC);

        JMenuItem itemB = new JMenuItem("Abrir");
        JMenuItem itemC = new JMenuItem("Cerrar");
        JMenuItem itemAD = new JMenuItem("Salir");

        itemB.addActionListener(this);
        itemC.addActionListener(this);
        itemAD.addActionListener(this);

        JMenu menu = new JMenu("Fichero");
        menu.add(menuAA);
        menu.add(itemB);
        menu.add(itemC);
        menu.addSeparator();
        menu.add(itemAD);

        return menu;
    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem) e.getSource();
        JOptionPane.showMessageDialog(this,
                "Acción " + item.getText());
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            JMenuItem item = (JMenuItem) e.getSource();
            JOptionPane.showMessageDialog(this,
                    "Seleccionado " + item.getText());
        }
    }

}
