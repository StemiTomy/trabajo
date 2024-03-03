package series;

import java.util.ArrayList;

public class CapituloDTO {
    private int id;
    private String titulo;
    private int duracionMins;
    private String sinopsis;
    private ArrayList<Personaje> personajes;

    public CapituloDTO () {
        
    }

    public CapituloDTO(int id, String titulo, int duracionMins, String sinopsis, ArrayList<Personaje> personajes) {
        this.id = id;
        this.titulo = titulo;
        this.duracionMins = duracionMins;
        this.sinopsis = sinopsis;
        this.personajes = personajes;
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

    @Override
    public String toString() {
        return "Capitulo [id=" + id + ", titulo=" + titulo + ", duracionMins=" + duracionMins + ", sinopsis=" + sinopsis
                + ", personajes=" + personajes + "]";
    }

}
