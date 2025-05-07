package ajedrez.modelo;

public abstract class Pieza {
    protected String color;
    protected int fila;
    protected int columna;

    public Pieza(String color, int fila, int columna) {
        this.color = color;
        this.fila = fila;
        this.columna = columna;
    }

    public String getColor() {
        return color;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setPosicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public abstract boolean esMovimientoValido(int filaDestino, int columnaDestino, Pieza[][] tablero);
}
