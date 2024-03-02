package series;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SerieDTO {
    private int id;
    private String titulo;
    private Date anoInicio;
    private String sinopsis;
    //private ArrayList<Temporada> temporadas;
    //private ArrayList<Personaje> personajes;
    //private List<Generos> generos;

    public SerieDTO(String titulo, Date fechaInicio, String sinopsis) {
        this.titulo = titulo;
        this.anoInicio = fechaInicio;
        this.sinopsis = sinopsis;
    }

    public SerieDTO() {
        //TODO Auto-generated constructor stub
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
    public Date getAnoInicio() {
        return anoInicio;
    }
    public void setAnoInicio(Date anoInicio) {
        this.anoInicio = anoInicio;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public String toString() {
        return "SerieDTO [id=" + id + ", titulo=" + titulo + ", anoInicio=" + anoInicio + ", sinopsis=" + sinopsis
                + "]";
    }

    
}
