package JAVA.Prueba_Trabajo;

import java.util.Arrays;

public class Actor {
    private int id;
    private String nombreActor;
    private Personaje[] personajes;

    public Actor(int id, String nombreActor, Personaje[] personajes) {
        this.id = id;
        this.nombreActor = nombreActor;
        this.personajes = personajes;
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

    public Personaje[] getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Personaje[] personajes) {
        this.personajes = personajes;
    }

    @Override
    public String toString() {
        return "Actor [id=" + id + ", nombreActor=" + nombreActor + ", personajes=" + Arrays.toString(personajes) + "]";
    }

}
