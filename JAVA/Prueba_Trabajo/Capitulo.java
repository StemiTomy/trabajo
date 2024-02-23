package JAVA.Prueba_Trabajo;

import java.util.Arrays;

public class Capitulo {
    private int id;
    private String titulo;
    private int duracionMins;
    private String sinopsis;
    private Personaje[] personajes;
    private Actor[] actores;

    public Capitulo(int id, String titulo, int duracionMins, String sinopsis, Personaje[] personajes, Actor[] actores) {
        this.id = id;
        this.titulo = titulo;
        this.duracionMins = duracionMins;
        this.sinopsis = sinopsis;
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
        return "Capitulo [id=" + id + ", titulo=" + titulo + ", duracionMins=" + duracionMins + ", sinopsis=" + sinopsis
                + ", personajes=" + Arrays.toString(personajes) + ", actores=" + Arrays.toString(actores) + "]";
    }

}
