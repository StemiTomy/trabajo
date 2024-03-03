package series;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class PanelSeries extends JPanel {
    // Obtener las series de la base de datos
    SerieDAO serieDAO = new SerieDAO();
    TemporadaDAO temporadaDAO = new TemporadaDAO();
    ArrayList<SerieDTO> series = serieDAO.getSeries();

    private JButton botonRefrescar = new JButton("Refrescar");
    private JButton botonBorrar = new JButton("Borrar");
    private JTree tree;
    private DefaultTreeModel treeModel;

    public PanelSeries() {
        // Crear el modelo del árbol con un nodo raíz inicial
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Series");
        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);

        // Crear un JScrollPane para agregar barras de desplazamiento al árbol
        JScrollPane scrollPane = new JScrollPane(tree);

        // Configurar el layout del panel
        this.setLayout(new BorderLayout());

        // Agregar el JScrollPane al panel en la región central
        this.add(scrollPane, BorderLayout.CENTER);

        // Agregar los botones en la región sur
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(botonRefrescar);
        panelBotones.add(botonBorrar);
        this.add(panelBotones, BorderLayout.SOUTH);

        // Agregar un ActionListener al botón de refrescar para actualizar las series en el árbol
        botonRefrescar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refrescarSeries();
            }
        });

        // Agregar un TreeSelectionListener al JTree para detectar cambios en la selección del árbol
        
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                // Obtener el camino de selección actual
                TreePath selectedPath = tree.getSelectionPath();

                // Habilitar o deshabilitar el botón de borrar según si hay un nodo seleccionado o no
                if (selectedPath != null && selectedPath.getLastPathComponent() != tree.getModel().getRoot()) {
                    // Obtener el último componente del camino, que es el nodo seleccionado
                    //DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectedPath.getLastPathComponent();
                    botonBorrar.setEnabled(true);
                    //mostrarTemporadas((String) selectedNode.getUserObject()); // TODO: lo coge como nulo y en parte tiene razón
                } else {
                    botonBorrar.setEnabled(false);
                }
            }
        });
        

        // Deshabilitar el botón de borrar inicialmente
        botonBorrar.setEnabled(false);

        // Agregar un ActionListener al botón de borrar para eliminar la serie seleccionada
        botonBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarSerie();
            }
        });

        // Mostrar las series inicialmente
        refrescarSeries();
    }

    // Método para refrescar las series en el árbol
    private void refrescarSeries() {
        // Limpiar el árbol
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
        root.removeAllChildren();
        treeModel.reload();

        // Agregar las series como nodos secundarios al nodo raíz
        for (SerieDTO serie : series) {
            DefaultMutableTreeNode serieNode = new DefaultMutableTreeNode(serie.getTitulo());
            ArrayList<TemporadaDTO> temporadas = serie.getTemporadas();
            for (TemporadaDTO temporada : temporadas) {
                DefaultMutableTreeNode temporadaNode = new DefaultMutableTreeNode("Temporada " + temporada.getId());
                ArrayList<CapituloDTO> capitulos = temporada.getCapitulos();
                for (CapituloDTO capitulo : capitulos) {
                    DefaultMutableTreeNode capituloNode = new DefaultMutableTreeNode("Capítulo " + capitulo.getId());
                    temporadaNode.add(capituloNode);
                }
                serieNode.add(temporadaNode);
            }
            root.add(serieNode);
        }

        // Actualizar el árbol
        treeModel.reload();
    }

    // Método para borrar 1 serie seleccionada en el árbol
    private void eliminarSerie() {
        // Obtener el nodo seleccionado
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            // Obtener el título de la serie seleccionada
            String tituloSerie = (String) selectedNode.getUserObject();

            // Mostrar un cuadro de diálogo de confirmación
            int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres borrar la serie '" + tituloSerie + "'?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {                
                // Eliminar la serie de la base de datos
                for (SerieDTO serie : series) {
                    if (serie.getTitulo().equals(tituloSerie)) {
                        int resultado = serieDAO.delete(serie);
                        if (resultado == 0) {
                            JOptionPane.showMessageDialog(null, "Error al borrar la serie.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        // Eliminar el nodo del arraylist y del árbol
                        series.remove(serie);
                        treeModel.removeNodeFromParent(selectedNode);
                        break;
                    }
                }
            } else {
                botonBorrar.setEnabled(false);
                return; // Salir del método
            }
        }
    }

    private void mostrarTemporadas(String tituloSerie) {
        for (SerieDTO serie : series) {
            if (serie.getTitulo().equals(tituloSerie)) {
                // Obtener las temporadas de la serie
                ArrayList<TemporadaDTO> temporadas = serie.getTemporadas();
                
                // Crear un nuevo árbol para mostrar las temporadas
                JTree temporadasTree = new JTree();
                DefaultMutableTreeNode root = new DefaultMutableTreeNode("Temporadas de " + tituloSerie);
                DefaultTreeModel treeModel = new DefaultTreeModel(root);
                temporadasTree.setModel(treeModel);
                
                // Agregar nodos para cada temporada al árbol
                for (TemporadaDTO temporada : temporadas) {
                    DefaultMutableTreeNode temporadaNode = new DefaultMutableTreeNode("Temporada " + temporada.getId());
                    root.add(temporadaNode);
                }

                // Agregar un TreeSelectionListener al JTree para detectar cambios en la selección del árbol
                /*
                temporadasTree.addTreeSelectionListener(new TreeSelectionListener() {
                    @Override
                    public void valueChanged(TreeSelectionEvent e) {
                        // Obtener el camino de selección actual
                        TreePath selectedPath = temporadasTree.getSelectionPath();

                        // Habilitar o deshabilitar el botón de borrar según si hay un nodo seleccionado o no
                        if (selectedPath != null && selectedPath.getLastPathComponent() != tree.getModel().getRoot()) {
                            // Obtener el último componente del camino, que es el nodo seleccionado
                            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectedPath.getLastPathComponent();
                            System.out.println("El item seleccionado es un: " + selectedNode.getUserObject().getClass());
                            String texto = selectedNode.getUserObject().toString();

                            int indiceEspacio = texto.indexOf(' '); // Encontrar el índice del primer espacio
                            String numeroStr = texto.substring(indiceEspacio + 1); // Obtener la parte después del espacio
                            int temporada_id = Integer.parseInt(numeroStr); // Convertir a int

                            mostrarCapitulos(tituloSerie, temporada_id); // TODO: "Temporada 2"
                        }
                    }
                });
                */
                
                // Mostrar el nuevo árbol de temporadas en un diálogo o en otra parte de la interfaz
                JOptionPane.showMessageDialog(null, new JScrollPane(temporadasTree), "Temporadas de " + tituloSerie, JOptionPane.PLAIN_MESSAGE);
                
                break; // Salir del bucle una vez que se encuentre la serie correspondiente
            }
        }
    }

    private void mostrarCapitulos(String tituloSerie, int idTemporada) {
        for (SerieDTO serie : series) {
            if (serie.getTitulo().equals(tituloSerie)) {
                ArrayList<TemporadaDTO> temporadas = serie.getTemporadas();
                for (TemporadaDTO temporada : temporadas) {
                    if (temporada.getId() == idTemporada) {
                        // Obtener las capitulos de la temporada
                        ArrayList<CapituloDTO> capitulos = temporada.getCapitulos();

                        if (capitulos != null) {
                            // Crear un nuevo árbol para mostrar los capítulos
                            JTree capitulosTree = new JTree();
                            DefaultMutableTreeNode root = new DefaultMutableTreeNode("Capitulos de " + tituloSerie + " de la temporada " + idTemporada);
                            DefaultTreeModel treeModel = new DefaultTreeModel(root);
                            capitulosTree.setModel(treeModel);

                            // Agregar nodos para cada capitulo al árbol
                            for (CapituloDTO capitulo : capitulos) {
                                DefaultMutableTreeNode capituloNode = new DefaultMutableTreeNode("Capítulo " + capitulo.getId());
                                root.add(capituloNode);
                            }
                            
                            // Mostrar el nuevo árbol de temporadas en un diálogo o en otra parte de la interfaz
                            JOptionPane.showMessageDialog(null, new JScrollPane(capitulosTree), "Capitulos de " + tituloSerie, JOptionPane.PLAIN_MESSAGE);
                        }
                        break; // Salir del bucle una vez que se encuentre la temporada correspondiente
                    }
                }

            }
        }
    }
}