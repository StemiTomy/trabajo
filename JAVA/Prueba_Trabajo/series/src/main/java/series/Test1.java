package series;

import java.util.ArrayList;
import java.util.Random;

public class Test1 {

    public static String generarNombreAleatorio() {
        Random random = new Random();
        // Longitud aleatoria del nombre (entre 5 y 10 caracteres)
        int longitudNombre = random.nextInt(6) + 5;
        StringBuilder nombre = new StringBuilder();

        // Generar la primera letra en mayúscula
        char primeraLetra = (char) (random.nextInt(26) + 'A');
        nombre.append(primeraLetra);

        // Definir las vocales y las consonantes
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        char[] consonantes = new char[21];
        int index = 0;
        for (char letra = 'b'; letra <= 'z'; letra++) {
            if (letra != 'a' && letra != 'e' && letra != 'i' && letra != 'o' && letra != 'u') {
                consonantes[index] = letra;
                index++;
            }
        }

        // Generar el resto del nombre
        for (int i = 1; i < longitudNombre; i++) {
            if (i % 2 == 0) { // Insertar una vocal
                char vocal = vocales[random.nextInt(vocales.length)];
                nombre.append(vocal);
            } else { // Insertar una consonante
                char consonante = consonantes[random.nextInt(consonantes.length)];
                nombre.append(consonante);
            }
        }

        return nombre.toString();
    }

    public static ArrayList<Serie> cargarDatos() {
        // 0. Crear una lista de todos los géneros disponibles
        Generos[] generosDisponibles = Generos.values();
        Random random = new Random();

        // 1. Crear series
        ArrayList<Serie> series = new ArrayList<>();
        for (int i = 1; i <= 3; i++) { // 3 series
            // Seleccionar dos géneros aleatorios
            Generos genero1 = generosDisponibles[random.nextInt(generosDisponibles.length)];
            Generos genero2 = generosDisponibles[random.nextInt(generosDisponibles.length)];
            Serie serie = new Serie(i, "Serie " + i, 2000 + i, "Sinopsis de la serie " + i, new ArrayList<Temporada>(), new ArrayList<Personaje>(), new ArrayList<Generos>());
            serie.getGeneros().add(genero1);
            serie.getGeneros().add(genero2);
            series.add(serie);
        }
        // 2. Crear temporadas
        for (Serie serie : series) {
            ArrayList<Temporada> temporadas = new ArrayList<Temporada>();
            for (int j = 1; j <= 5; j++) { // 5 temporadas para cada serie
                Temporada temporada = new Temporada(j, null, null, new ArrayList<Capitulo>());
                temporadas.add(temporada);
            }
            serie.setTemporadas(temporadas);
        }
        // 3. Crear capítulos
        for (Serie serie : series) {
            for (Temporada temporada : serie.getTemporadas()) {
                ArrayList<Capitulo> capitulos = new ArrayList<Capitulo>();
                for (int k = 1; k <= 10; k++) { // 10 capítulos para cada temporada
                    Capitulo capitulo = new Capitulo(k, "Capítulo " + k, 30, "Sinopsis del capítulo " + k, new ArrayList<Personaje>());
                    capitulos.add(capitulo);
                }
                temporada.setCapitulos(capitulos);
            }
        }

        // 4. Crear personajes
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();
        for (int l = 1; l <= 5; l++) { // 5 personajes
            Personaje personaje = new Personaje(l, generarNombreAleatorio(), new ArrayList<Actor>());
            personajes.add(personaje);
        }

        // 5. Crear actores
        ArrayList<Actor> actores = new ArrayList<Actor>();
        for (int m = 1; m <= 5; m++) { // 5 actores
            Actor actor = new Actor(m, generarNombreAleatorio(), new ArrayList<Personaje>());
            actores.add(actor);
        }

        // 6. Asignar actores a personajes
        for (Personaje personaje : personajes) {
            for (int n = 1; n <= 2; n++) { // Asignamos 2 actores (aleatorios) a cada personaje
                Actor actor = actores.get((int) (Math.random() * actores.size()));
                personaje.getActores().add(actor);
                actor.getPersonajes().add(personaje);
            }
        }

        // 7. Asignar personajes a capitulos
        for (Serie serie : series) {
            serie.setPersonajes(personajes);
            for (Temporada temporada : serie.getTemporadas()) {
                ArrayList<Capitulo> capitulos = temporada.getCapitulos();
                for (Capitulo capitulo : capitulos) {
                    capitulo.setPersonajes(personajes);
                }
            }
        }

        // Omitido: Imprimir información
        /*
        for (Serie serie : series) {
            System.out.println(serie.toString());
        }
        for (Personaje personaje : personajes) {
            System.out.println(personaje.toString());
        }
        for (Actor actor : actores) {
            System.out.println(actor.toString());
        }
        */
        
        // FIN
        System.out.println("Carga de datos realizada con éxito.\n");
        return series;
    }
}
