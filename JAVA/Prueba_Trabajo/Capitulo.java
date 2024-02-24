package JAVA.Prueba_Trabajo;

import java.util.ArrayList;

public class Capitulo {
    private int id;
    private String titulo;
    private int duracionMins;
    private String sinopsis;
    private ArrayList<Personaje> personajes;
    private ArrayList<Actor> actores;

    public Capitulo(int id, String titulo, int duracionMins, String sinopsis, ArrayList<Personaje> personajes, ArrayList<Actor> actores) {
        this.setId(id);
        this.setTitulo(titulo);
        this.setDuracionMins(duracionMins);
        this.setSinopsis(sinopsis);
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

    public int getDuracionMins() {
        return duracionMins;
    }

    public void setDuracionMins(int duracionMins) {
        this.duracionMins = duracionMins;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
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
        return "Capitulo [id=" + id + ", titulo=" + titulo + ", duracionMins=" + duracionMins + ", sinopsis=" + sinopsis
                + ", personajes=" + personajes + ", actores=" + actores + "]";
    }

}
