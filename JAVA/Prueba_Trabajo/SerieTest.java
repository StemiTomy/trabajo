package JAVA.Prueba_Trabajo;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.Arrays;

public class SerieTest {
    @Test
    public void testGetId() {
        Serie serie = new Serie(1, "Breaking Bad", 2008, "Un profesor de química se convierte en fabricante de metanfetamina.", null, null, null, null);
        assertEquals(1, serie.getId());
    }

    @Test
    public void testSetTitulo() {
        Serie serie = new Serie(1, "Breaking Bad", 2008, "Un profesor de química se convierte en fabricante de metanfetamina.", null, null, null, null);
        serie.setTitulo("Breaking Bad: El Camino");
        assertEquals("Breaking Bad: El Camino", serie.getTitulo());
    }

    @Test
    public void testGetAnoInicio() {
        Serie serie = new Serie(1, "Breaking Bad", 2008, "Un profesor de química se convierte en fabricante de metanfetamina.", null, null, null, null);
        assertEquals(2008, serie.getAnoInicio());
    }

    @Test
    public void testSetSinopsis() {
        Serie serie = new Serie(1, "Breaking Bad", 2008, "Un profesor de química se convierte en fabricante de metanfetamina.", null, null, null, null);
        serie.setSinopsis("Un profesor de química se convierte en fabricante de metanfetamina para asegurar el futuro de su familia.");
        assertEquals("Un profesor de química se convierte en fabricante de metanfetamina para asegurar el futuro de su familia.", serie.getSinopsis());
    }

    @Test
    public void testGetGeneros() {
        String[] generosEsperados = {"acción", "drama"};
        Serie serie = new Serie(1, "Breaking Bad", 2008, "Un profesor de química se convierte en fabricante de metanfetamina.", generosEsperados, null, null, null);
        String[] generosObtenidos = serie.getGeneros();
        // Verificamos si los géneros obtenidos son iguales a los esperados
        assertArrayEquals("Los géneros obtenidos no son los esperados", generosEsperados, generosObtenidos);
    }

    @Test
    public void testGetAll() {
        String[] generosEsperados = {"acción", "drama"};

        Personaje personaje1 = new Personaje(1, "Walter White", null);
        Actor actor1 = new Actor(1, "Bryan Cranston", null);
        Actor[] actores = {actor1};
        personaje1.setActores(actores);
        Personaje[] personajes = {personaje1};
        actor1.setPersonajes(personajes);

        Capitulo capitulo1 = new Capitulo(0, null, 0, null, personajes, actores);
        Capitulo[] capitulos = {capitulo1};

        Date fechaProduccion = new Date(1);
        Date fechaEstrenoMundial = new Date(2);
        Temporada temporada1 = new Temporada(0, fechaProduccion, fechaEstrenoMundial, capitulos, personajes, actores);
        Temporada[] temporadas = {temporada1};

        Serie serie = new Serie(1, "Breaking Bad", 2008, "Un profesor de química se convierte en fabricante de metanfetamina.", generosEsperados, temporadas, personajes, actores);

        // Comprobar la cantidad de personajes
        assertEquals(1, serie.getPersonajes().length);

        // Comprobar el nombre del primer personaje
        assertEquals("Walter White", serie.getPersonajes()[0].getNombrePersonaje());

        // Comprobar la existencia de un actor en un personaje
        assertEquals(1, serie.getPersonajes()[0].getActores().length);
        assertEquals("Bryan Cranston", serie.getPersonajes()[0].getActores()[0].getNombreActor());

        // Comprobar la cantidad de géneros
        assertEquals(2, serie.getGeneros().length);

        // Comprobar la existencia de un género específico
        assertTrue(Arrays.asList(serie.getGeneros()).contains("acción"));

        // Comprobar la existencia de una temporada
        assertEquals(1, serie.getTemporadas().length);

        // Comprobar la fecha de producción de la temporada
        assertEquals(new Date(1), serie.getTemporadas()[0].getFechaProduccion());
    }
}
