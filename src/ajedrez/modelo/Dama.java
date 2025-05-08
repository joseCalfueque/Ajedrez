package ajedrez.modelo;

public class Dama extends Pieza {

    public Dama(Color color) {
        super(color);
    }

    @Override
    public boolean movimientoValido(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal, Tablero tablero) {
        int fila = Math.abs(filaFinal - filaInicial);
        int columna = Math.abs(columnaFinal - columnaInicial);

        // Movimiento en línea recta (como la torre)
        if (filaInicial == filaFinal || columnaInicial == columnaFinal) {
            int pasoFila = Integer.compare(filaFinal, filaInicial);
            int pasoColumna = Integer.compare(columnaFinal, columnaInicial);

            int filaActual = filaInicial + pasoFila;
            int columnaActual = columnaInicial + pasoColumna;

            while (filaActual != filaFinal || columnaActual != columnaFinal) {
                if (tablero.obtenerPieza(filaActual, columnaActual) != null) {
                    return false;
                }
                filaActual += pasoFila;
                columnaActual += pasoColumna;
            }
            return true;
        }

        // Movimiento en diagonal (como el alfil)
        if (fila == columna) {
            int pasoFila = (filaFinal > filaInicial) ? 1 : -1;
            int pasoColumna = (columnaFinal > columnaInicial) ? 1 : -1;

            int filaActual = filaInicial + pasoFila;
            int columnaActual = columnaInicial + pasoColumna;

            while (filaActual != filaFinal && columnaActual != columnaFinal) {
                if (tablero.obtenerPieza(filaActual, columnaActual) != null) {
                    return false;
                }
                filaActual += pasoFila;
                columnaActual += pasoColumna;
            }
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return color == Color.BLANCO ? "♕" : "♛";
    }
}
