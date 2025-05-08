package ajedrez.modelo;

public class Caballo extends Pieza {

    public Caballo(Color color) {
        super(color);
    }

    @Override
    public boolean movimientoValido(int filaInicial, int columnaInicial, int filaFinal, int columnaFinal, Tablero tablero) {
        int fila = Math.abs(filaFinal - filaInicial);
        int columna = Math.abs(columnaFinal - columnaInicial);

        return (fila == 2 && columna == 1) || (fila == 1 && columna == 2);
    }

    @Override
    public String toString() {
        return color == Color.BLANCO ? "♘" : "♞";
    }
}
