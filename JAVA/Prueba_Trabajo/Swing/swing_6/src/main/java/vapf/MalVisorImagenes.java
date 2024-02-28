package vapf;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MalVisorImagenes extends JPanel {
    private JLabel etqImagen;
    private JLabel etqURLImagen;
    private JTextField campoURLImagen;
    private JButton botonCarga;

    public MalVisorImagenes() {
    this.etqURLImagen = new JLabel("URL imagen: ");
    this.campoURLImagen = new JTextField(50);
    //this.campoURLImagen.setText("http://www.escet.urjc.es/~smontalvo/interfacesgraficasenjava/imagen3.jpg");
    this.botonCarga = new JButton("Cargar imagen");
    this.botonCarga.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            iniciaCargaImagen();
    }});
    
    this.setLayout(new BorderLayout());
    JPanel panelControles = new JPanel();
    panelControles.setLayout(new BorderLayout(10, 10));
    panelControles.add(this.etqURLImagen,BorderLayout.WEST);
    panelControles.add(this.campoURLImagen,BorderLayout.CENTER);panelControles.add(this.botonCarga,BorderLayout.EAST);
    panelControles.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    this.add(panelControles, BorderLayout.NORTH);

    this.etqImagen = new JLabel(
    "<HTML><div align='center'>"+
    "No hay imagen cargada<BR><BR>"+
    "Seleccione una URL y pulsa cargar</div>");

    this.etqImagen.setHorizontalAlignment(SwingConstants.CENTER);
    JScrollPane sp = new JScrollPane(this.etqImagen);
    this.add(sp, BorderLayout.CENTER);
    }

    protected void iniciaCargaImagen() {
        final URL url;
        try {
            url = new URL(this.campoURLImagen.getText());
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(this,
                    "URL inválida.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.botonCarga.setEnabled(false);
        this.etqImagen.setText("Cargando imagen");
        cargaImagen(url);
    }

    protected void cargaImagen(URL urlImagen) {
        final Icon icono;
        try {
            icono = new ImageIcon(ImageIO.read(urlImagen));
        } catch (IOException e) {
            errorCargaImagen();
            return;
        }
        etqImagen.setText("");
        etqImagen.setIcon(icono);
        botonCarga.setEnabled(true);
    }

    private void errorCargaImagen() {
        JOptionPane.showMessageDialog(MalVisorImagenes.this,
                "Error al cargar la imagen.", "Error",
                JOptionPane.ERROR_MESSAGE);
        botonCarga.setEnabled(true);
    }
}
