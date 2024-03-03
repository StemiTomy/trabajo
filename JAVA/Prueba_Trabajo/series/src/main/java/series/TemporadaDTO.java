package series;

import java.sql.Date;
import java.util.ArrayList;

public class TemporadaDTO {
    private int id;
    private Date fechaProduccion;
    private Date fechaEstrenoMundial;
    //private ArrayList<Capitulo> capitulos;

    public TemporadaDTO(Date fechaProduccion, Date fechaEstrenoMundial) {
        this.fechaProduccion = fechaProduccion;
        this.fechaEstrenoMundial = fechaEstrenoMundial;
    }
    public TemporadaDTO() {

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

    @Override
    public String toString() {
        return "Temporada [id=" + id + ", fechaProduccion=" + fechaProduccion + ", fechaEstrenoMundial="
                + fechaEstrenoMundial + "]";
    }

}
