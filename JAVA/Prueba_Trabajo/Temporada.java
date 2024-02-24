package JAVA.Prueba_Trabajo;
import java.sql.Date; // suponemos que usaremos JDBC
import java.util.ArrayList;

public class Temporada {
    private int id;
    private Date fechaProduccion;
    private Date fechaEstrenoMundial;
    private ArrayList<Capitulo> capitulos;
    private ArrayList<Personaje> personajes;
    private ArrayList<Actor> actores;
    
    public Temporada(int id, Date fechaProduccion, Date fechaEstrenoMundial, ArrayList<Capitulo> capitulos,
            ArrayList<Personaje> personajes, ArrayList<Actor> actores) {
        this.setId(id);
        this.setFechaProduccion(fechaProduccion);
        this.setFechaEstrenoMundial(fechaEstrenoMundial);
        this.setCapitulos(capitulos);
        this.setPersonajes(personajes);
        this.setActores(actores);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(Date fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }

    public Date getFechaEstrenoMundial() {
        return fechaEstrenoMundial;
    }

    public void setFechaEstrenoMundial(Date fechaEstrenoMundial) {
        this.fechaEstrenoMundial = fechaEstrenoMundial;
    }

    public ArrayList<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(ArrayList<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public void setActores(ArrayList<Actor> actores) {
        this.actores = actores;
    }

    @Override
    public String toString() {
        return "Temporada [id=" + id + ", fechaProduccion=" + fechaProduccion + ", fechaEstrenoMundial="
                + fechaEstrenoMundial + ", capitulos=" + capitulos + ", personajes=" + personajes + ", actores="
                + actores + "]";
    }

}
