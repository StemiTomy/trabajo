package JAVA.Prueba_Trabajo;

import java.util.Arrays;

public class Personaje {
    private int id;
    private String nombrePersonaje;
    private Actor[] actores;

    public Personaje(int id, String nombrePersonaje, Actor[] actores) {
        this.id = id;
        this.nombrePersonaje = nombrePersonaje;
        this.actores = actores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public Actor[] getActores() {
        return actores;
    }

    public void setActores(Actor[] actores) {
        this.actores = actores;
    }

    @Override
    public String toString() {
        return "Personaje [id=" + id + ", nombrePersonaje=" + nombrePersonaje + ", actores=" + Arrays.toString(actores)
                + "]";
    }

}
