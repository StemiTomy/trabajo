package series;

import java.sql.Date;
import java.util.ArrayList;

public class Temporada {
    private int id;
    private Date fechaProduccion;
    private Date fechaEstrenoMundial;
    private ArrayList<Capitulo> capitulos;

    public Temporada(int id, Date fechaProduccion, Date fechaEstrenoMundial, ArrayList<Capitulo> capitulos) {
        this.id = id;
        this.fechaProduccion = fechaProduccion;
        this.fechaEstrenoMundial = fechaEstrenoMundial;
        this.capitulos = capitulos;
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

    @Override
    public String toString() {
        return "Temporada [id=" + id + ", fechaProduccion=" + fechaProduccion + ", fechaEstrenoMundial="
                + fechaEstrenoMundial + ", capitulos=" + capitulos + "]";
    }

}
