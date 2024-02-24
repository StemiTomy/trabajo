package JAVA.Prueba_Trabajo;

import java.util.ArrayList;

public class Personaje {
    private int id;
    private String nombrePersonaje;
    private ArrayList<Actor> actores;

    public Personaje(int id, String nombrePersonaje, ArrayList<Actor> actores) {
        this.setId(id);
        this.setNombrePersonaje(nombrePersonaje);
        this.setActores(actores);
    }

    public Personaje(int id, String nombrePersonaje) {
        this.setId(id);
        this.setNombrePersonaje(nombrePersonaje);
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

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public void setActores(ArrayList<Actor> actores) {
        this.actores = actores;
    }

    @Override
    public String toString() {
        return "Personaje [id=" + id + ", nombrePersonaje=" + nombrePersonaje + ", actores=" + actores + "]";
    }

}
