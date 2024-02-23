package JAVA.Prueba_Trabajo;
import java.sql.Date; // suponemos que usaremos JDBC
import java.util.Arrays;

public class Temporada {
    private int id;
    private Date fechaProduccion;
    private Date fechaEstrenoMundial;
    private Capitulo[] capitulos;
    private Personaje[] personajes;
    private Actor[] actores;
    
    public Temporada(int id, Date fechaProduccion, Date fechaEstrenoMundial, Capitulo[] capitulos,
            Personaje[] personajes, Actor[] actores) {
        this.id = id;
        this.fechaProduccion = fechaProduccion;
        this.fechaEstrenoMundial = fechaEstrenoMundial;
        this.capitulos = capitulos;
        this.personajes = personajes;
        this.actores = actores;
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

    public Capitulo[] getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(Capitulo[] capitulos) {
        this.capitulos = capitulos;
    }

    public Personaje[] getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Personaje[] personajes) {
        this.personajes = personajes;
    }

    public Actor[] getActores() {
        return actores;
    }

    public void setActores(Actor[] actores) {
        this.actores = actores;
    }

    @Override
    public String toString() {
        return "Temporada [id=" + id + ", fechaProduccion=" + fechaProduccion + ", fechaEstrenoMundial="
                + fechaEstrenoMundial + ", capitulos=" + Arrays.toString(capitulos) + ", personajes="
                + Arrays.toString(personajes) + ", actores=" + Arrays.toString(actores) + "]";
    }

}
