package ajedrez.modelo;

public class Peon extends Pieza {

    public Peon(Color color, Posicion posicion) {
        super(color, posicion);
    }

    @Override
    public boolean movimientoValido(Posicion nuevaPosicion, Tablero tablero) {
        int direccion = (this.getColor() == Color.BLANCO) ? -1 : 1;
        int filaActual = this.getPosicion().fila();
        int columnaActual = this.getPosicion().columna();
        int nuevaFila = nuevaPosicion.fila();
        int nuevaColumna = nuevaPosicion.columna();

        // Movimiento simple hacia adelante
        if (columnaActual == nuevaColumna && nuevaFila == filaActual + direccion &&
                tablero.estaVacio(nuevaPosicion)) {
            return true;
        }

        // Primer movimiento doble
        if (columnaActual == nuevaColumna &&
                nuevaFila == filaActual + 2 * direccion &&
                ((this.getColor() == Color.BLANCO && filaActual == 6) || (this.getColor() == Color.NEGRO && filaActual == 1)) &&
                tablero.estaVacio(nuevaPosicion) &&
                tablero.estaVacio(new Posicion(filaActual + direccion, columnaActual))) {
            return true;
        }

        // Captura diagonal
        if (Math.abs(nuevaColumna - columnaActual) == 1 &&
                nuevaFila == filaActual + direccion &&
                tablero.hayPiezaOponente(nuevaPosicion, this.getColor())) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return this.getColor() == Color.BLANCO ? "♙" : "♟";
    }
}
