package series;

import java.util.ArrayList;

public class Personaje {
    private int id;
    private String nombre;
    private ArrayList<Actor> actores;

    public Personaje(int id, String nombre, ArrayList<Actor> actores) {
        this.setId(id);
        this.setNombre(nombre);
        this.setActores(actores);
    }

    public Personaje(int id, String nombre) {
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

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public void setActores(ArrayList<Actor> actores) {
        this.actores = actores;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Personaje{id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", actores=[");
        for (int i = 0; i < actores.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(actores.get(i).getNombre());
        }
        sb.append("]}");
        return sb.toString();
    }

}