package JAVA.Prueba_Trabajo;

import java.util.Arrays;
import java.util.ArrayList;

public class Serie {
    private int id;
    private String titulo;
    private int anoInicio;
    private String sinopsis;
    private String[] generos = {"acción", "aventura", "animación", "comedia", "documental", "drama", "horror", "musical", "romance", "ciencia ficción"};
    private ArrayList<Temporada> temporadas;
    private ArrayList<Personaje> personajes;
    private ArrayList<Actor> actores;
    
    public Serie(int id, String titulo, int anoInicio, String sinopsis, String[] generos, Temporada temporada,
            Personaje[] personajes, Actor[] actores) {
        this.id = id;
        this.titulo = titulo;
        this.anoInicio = anoInicio;
        this.sinopsis = sinopsis;
        this.generos = generos;
        temporadas.add(temporada);
        this.personajes = personajes;
        this.actores = actores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoInicio() {
        return anoInicio;
    }

    public void setAnoInicio(int anoInicio) {
        this.anoInicio = anoInicio;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String[] getGeneros() {
        return generos;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public Temporada[] getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Temporada[] temporadas) {
        this.temporadas = temporadas;
    }

    public Personaje[] getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Personaje[] personajes) {
        this.personajes = personajes;
    }

    public Actor[] getActores() {
        return actores;
    }

    public void setActores(Actor[] actores) {
        this.actores = actores;
    }

    @Override
    public String toString() {
        return "Serie [id=" + id + ", titulo=" + titulo + ", anoInicio=" + anoInicio + ", sinopsis=" + sinopsis
                + ", generos=" + Arrays.toString(generos) + ", temporadas=" + Arrays.toString(temporadas)
                + ", personajes=" + Arrays.toString(personajes) + ", actores=" + Arrays.toString(actores) + "]";
    }

}
