package vapf;

import java.util.EventObject;

public class MoveEvent extends EventObject {
    private int filaOrigen;
    private int columnaOrigen;
    private int filaDestino;
    private int columnaDestino;

    public MoveEvent(Object fuente, int filaOrigen,
            int columnaOrigen, int filaDestino,
            int columnaDestino) {
        super(fuente);
        this.filaDestino = filaDestino;
        this.filaOrigen = filaOrigen;
        this.columnaDestino = columnaDestino;
        this.columnaOrigen = columnaOrigen;
    }

    public int getFilaOrigen() {
        return filaOrigen;
    }

    public int getFilaDestino() {
        return filaDestino;
    }

    public int getColumnaOrigen() {
        return columnaOrigen;
    }

    public int getColumnaDestino() {
        return columnaDestino;
    }

}
