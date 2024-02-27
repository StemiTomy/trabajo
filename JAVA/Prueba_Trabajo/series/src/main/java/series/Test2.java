package series;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test2 {
    public static void listarDatos(ArrayList<Serie> series){
        // por cada serie -> por cada temporada -> por cada capítulo -> por cada actor -> qué personaje/s interpreta
        for (Serie serie : series) {
            System.out.println("\n\nEn la serie " + serie.getTitulo() + ":");
            ArrayList<Temporada> temporadas = serie.getTemporadas();
            for (Temporada temporada : temporadas) {
                System.out.print("\n\tEn la temporada " + temporada.getId() + ":");
                ArrayList<Capitulo> capitulos = temporada.getCapitulos();
                for (Capitulo capitulo : capitulos) {
                    System.out.print("\n\n\t\tEn el capítulo " + capitulo.getId());
                    ArrayList<Personaje> personajes = capitulo.getPersonajes();
                        for (Personaje personaje : personajes) {
                            System.out.print("\n\t\t\tEl personaje '" + personaje.getNombre()+"' es interpretado por: ");
                            ArrayList<Actor> actores = personaje.getActores();
                            for (Actor actor : actores) { // fori
                                System.out.print("'" + actor.getNombre()+"' ");
                            }
                        }
                }
            }
        }
    }

    public static void listarPersonajesOrdenAlfabetico(ArrayList<Serie> series){
        // por cada serie, coge los nombres de los personajes, ordena alfabeticamente
        for (Serie serie : series) {
            ArrayList<Personaje> personajes = serie.getPersonajes();

            // Ordenar alfabéticamente los personajes
            Collections.sort(personajes, new Comparator<Personaje>() {
                @Override
                public int compare(Personaje p1, Personaje p2) {
                    return p1.getNombre().compareTo(p2.getNombre());
                }
            });

            // Imprimir los personajes ordenados
            System.out.println("Personajes de la serie " + serie.getTitulo() + " ordenados alfabéticamente:\n");
            for (Personaje personaje : personajes) {
                System.out.println("\t" + personaje.getNombre());
            }
            System.out.println();
        }
    }
}
