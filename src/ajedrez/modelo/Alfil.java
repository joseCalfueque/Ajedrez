package ajedrez.modelo;

public class Alfil extends Pieza {

    public Alfil(Color color) {
        super(color);
    }

    @Override
    public boolean movimientoValido(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal, Tablero tablero) {
        int fila = Math.abs(filaFinal - filaInicial);
        int columna = Math.abs(columnaFinal - columnaInicial);

        // Movimiento diagonal
        if (fila != columna) {
            return false;
        }

        int pasoFila = (filaFinal > filaInicial) ? 1 : -1;
        int pasoColumna = (columnaFinal > columnaInicial) ? 1 : -1;

        int filaActual = filaInicial + pasoFila;
        int columnaActual = columnaInicial + pasoColumna;

        while (filaActual != filaFinal && columnaActual != columnaFinal) {
            if (tablero.obtenerPieza(filaActual, columnaActual) != null) {
                return false; // Camino bloqueado
            }
            filaActual += pasoFila;
            columnaActual += pasoColumna;
        }

        return true;
    }

    @Override
    public String toString() {
        return color == Color.BLANCO ? "♗" : "♝";
    }
}
