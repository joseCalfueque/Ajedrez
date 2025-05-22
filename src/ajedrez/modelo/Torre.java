package ajedrez.modelo;

public class Torre extends Pieza {
    public Torre(Color color, Posicion posicion) {
        super(color, posicion);
    }

    @Override
    public boolean movimientoValido(Posicion nuevaPosicion, Tablero tablero) {
        int filaActual = this.getPosicion().fila();
        int columnaActual = this.getPosicion().columna();
        int nuevaFila = nuevaPosicion.fila();
        int nuevaColumna = nuevaPosicion.columna();

        if (filaActual != nuevaFila && columnaActual != nuevaColumna) return false;

        int pasoFila = Integer.compare(nuevaFila, filaActual);
        int pasoColumna = Integer.compare(nuevaColumna, columnaActual);

        int f = filaActual + pasoFila, c = columnaActual + pasoColumna;
        while (f != nuevaFila || c != nuevaColumna) {
            if (!tablero.estaVacio(new Posicion(f, c))) return false;
            f += pasoFila;
            c += pasoColumna;
        }

        return tablero.estaVacio(nuevaPosicion) || tablero.hayPiezaOponente(nuevaPosicion, this.getColor());
    }

    @Override
    public String toString() {
        return getColor() == Color.BLANCO ? "♖" : "♜";
    }
}
