package series;

import java.sql.Date;
import java.util.ArrayList;

public class TemporadaDTO {
    private int id;
    private Date fechaProduccion;
    private Date fechaEstrenoMundial;
    private ArrayList<CapituloDTO> capitulos;

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
    
    public ArrayList<CapituloDTO> getCapitulos() {
        return capitulos;
    }
    public void setCapitulos(ArrayList<CapituloDTO> capitulos) {
        this.capitulos = capitulos;
    }

    @Override
    public String toString() {
        return "TemporadaDTO [id=" + id + ", fechaProduccion=" + fechaProduccion + ", fechaEstrenoMundial="
                + fechaEstrenoMundial + ", capitulos=" + capitulos + "]";
    }

}
