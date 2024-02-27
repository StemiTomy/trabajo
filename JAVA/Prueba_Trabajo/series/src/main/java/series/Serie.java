package series;

import java.util.ArrayList;
import java.util.List;

public class Serie {
    private int id;
    private String titulo;
    private int anoInicio;
    private String sinopsis;
    private ArrayList<Temporada> temporadas;
    private ArrayList<Personaje> personajes;
    private List<Generos> generos;

    public Serie(int id, String titulo, int anoInicio, String sinopsis, ArrayList<Temporada> temporadas, ArrayList<Personaje> personajes, List<Generos> generos) {
        this.id = id;
        this.titulo = titulo;
        this.anoInicio = anoInicio;
        this.sinopsis = sinopsis;
        this.temporadas = temporadas;
        this.personajes = personajes;
        this.generos = generos;
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
    
    public List<Generos> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Generos> generos) {
        this.generos = generos;
    }

    @Override
    public String toString() {
        return "Serie [id=" + id + ", titulo=" + titulo + ", anoInicio=" + anoInicio + ", sinopsis=" + sinopsis
                + ", temporadas=" + temporadas + ", personajes=" + personajes + ", generos=" + generos + "]";
    }

}
