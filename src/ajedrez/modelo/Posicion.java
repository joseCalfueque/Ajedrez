package ajedrez.modelo;

/**es como la posición en el tablero de ajedrez, definida por fila y columna.*/
public class Posicion {
    private int fila;    // los valores de 0 a 7 (para filas 1 a 8)
    private int columna; // los valores de 0 a 7 (para columnas A a H o 1 a 8)

    /**  Constructor para crear una posición con fila y columna específicas.
     * @param fila Fila de la posición (0-7)
     * @param columna Columna de la posición (0-7)*/
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    /**Devuelve la fila actual.
      @return Fila (0-7)*/
    public int getFila() {
        return fila;
    }

    /**Devuelve la columna actual.
     @return Columna (0-7)*/
    public int getColumna() {
        return columna;
    }

    /**Cambia la fila de la posición.
     @param fila Nueva fila*/
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**Cambia la columna de la posición.
     * @param columna Nueva columna*/
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**Compara dos posiciones para ver si son iguales.
     * @param obj Objeto a comparar
     * @return true si fila y columna son iguales*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Posicion)) return false;
        Posicion otra = (Posicion) obj;
        return this.fila == otra.fila && this.columna == otra.columna;
    }

    /**Genera un hash code basado en fila y columna.
     * @return Código hash*/
    @Override
    public int hashCode() {
        return 31 * fila + columna;
    }
}
