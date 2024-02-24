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
    
    public Serie(int id, String titulo, int anoInicio, String sinopsis, String[] generos, ArrayList<Temporada> temporadas,
            ArrayList<Personaje> personajes, ArrayList<Actor> actores) {
        this.setId(id);
        this.setTitulo(titulo);
        this.setAnoInicio(anoInicio);
        this.setSinopsis(sinopsis);
        this.setGeneros(generos);
        this.setTemporadas(temporadas);
        this.setPersonajes(personajes);
        this.setActores(actores);
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

    public ArrayList<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(ArrayList<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public void setActores(ArrayList<Actor> actores) {
        this.actores = actores;
    }

    @Override
    public String toString() {
        return "Serie [id=" + id + ", titulo=" + titulo + ", anoInicio=" + anoInicio + ", sinopsis=" + sinopsis
                + ", generos=" + Arrays.toString(generos) + ", temporadas=" + temporadas + ", personajes=" + personajes
                + ", actores=" + actores + "]";
    }

    

}
