package ajedrez.modelo;

public class Posicion {
    private int fila;
    private int columna;

    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int fila() {
        return fila;
    }

    public int columna() {
        return columna;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Posicion)) return false;
        Posicion otra = (Posicion) obj;
        return this.fila == otra.fila && this.columna == otra.columna;
    }

    @Override
    public String toString() {
        return "(" + fila + "," + columna + ")";
    }

    public int getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }
}
