package ajedrez.modelo;

public class Rey extends Pieza {

    public Rey(Color color) {
        super(color);
    }

    @Override
    public boolean movimientoValido(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal, Tablero tablero) {
        int fila = Math.abs(filaFinal - filaInicial);
        int columna = Math.abs(columnaFinal - columnaInicial);

        // Movimiento de una casilla en cualquier dirección
        return (fila <= 1 && columna <= 1);
    }

    @Override
    public String toString() {
        return color == Color.BLANCO ? "♔" : "♚";
    }
}
