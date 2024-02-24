package JAVA.Prueba_Trabajo;

import java.util.ArrayList;

public class Actor {
    private int id;
    private String nombreActor;
    private ArrayList<Personaje> personajes;

    public Actor(int id, String nombreActor, ArrayList<Personaje> personajes) {
        this.setId(id);
        this.setNombreActor(nombreActor);
        this.setPersonajes(personajes);
    }

    public Actor(int id, String nombreActor) {
        this.setId(id);
        this.setNombreActor(nombreActor);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreActor() {
        return nombreActor;
    }

    public void setNombreActor(String nombreActor) {
        this.nombreActor = nombreActor;
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    @Override
    public String toString() {
        return "Actor [id=" + id + ", nombreActor=" + nombreActor + ", personajes=" + personajes + "]";
    }

}
