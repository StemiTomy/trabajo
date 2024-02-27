package series;

import java.util.ArrayList;

public class Actor {
    private int id;
    private String nombre;
    private ArrayList<Personaje> personajes;

    public Actor(int id, String nombre, ArrayList<Personaje> personajes) {
        this.setId(id);
        this.setNombre(nombre);
        this.setPersonajes(personajes);
    }

    public Actor(int id, String nombre) {
        this.setId(id);
        this.setNombre(nombre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    @Override
    public String toString() {
        return "Actor [id=" + id + ", nombre=" + nombre + ", personajes=" + personajes + "]";
    }

}
