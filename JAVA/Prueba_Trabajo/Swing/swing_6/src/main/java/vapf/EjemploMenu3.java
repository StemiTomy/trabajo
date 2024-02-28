package vapf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class EjemploMenu3 extends JFrame {
    public static void main(String[] args) {
        new EjemploMenu3();
    }

    public EjemploMenu3() {

        // JPopupMenu como menú contextual de un componente
        JPopupMenu jPopupMenu1 = createJPopupMenuA();
        JButton botonMenuContextual = new JButton("Boton 1");
        botonMenuContextual.setComponentPopupMenu(jPopupMenu1);

        // JPopupMenu mostrado explícitamente al
        // pulsar el botón
        final JButton botonMostradorMenu = new JButton(
                "Boton 2");
        final JPopupMenu jPopupMenu2 = createJPopupMenuA();
        botonMostradorMenu.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        jPopupMenu2.show(
                                botonMostradorMenu,
                                0, botonMostradorMenu.getHeight());
                    }
                });
        JPanel contentPane = new JPanel();
        contentPane.add(botonMenuContextual);
        contentPane.add(botonMostradorMenu);
        this.setContentPane(contentPane);
        this.setSize(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private JPopupMenu createJPopupMenuA() {
        JMenuItem itemA = new JMenuItem("Opcion A");
        JMenuItem itemB = new JMenuItem("Opcion B");
        JMenuItem itemC = new JMenuItem("Opcion C");

        JPopupMenu jPopupMenu = new JPopupMenu();

        jPopupMenu.add(itemA);
        jPopupMenu.add(itemB);
        jPopupMenu.add(itemC);

        return jPopupMenu;
    }

    private JPopupMenu createJPopupMenuB() {
        JMenuItem itemA = new JMenuItem("Opcion 1");
        JMenuItem itemB = new JMenuItem("Opcion 2");
        JMenuItem itemC = new JMenuItem("Opcion 3");

        JPopupMenu jPopupMenu = new JPopupMenu();

        jPopupMenu.add(itemA);
        jPopupMenu.add(itemB);
        jPopupMenu.add(itemC);

        return jPopupMenu;
    }
}
