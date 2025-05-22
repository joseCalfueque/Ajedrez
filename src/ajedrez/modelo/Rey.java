package ajedrez.modelo;

public class Rey extends Pieza {
    public Rey(Color color, Posicion posicion) {
        super(color, posicion);
    }

    @Override
    public boolean movimientoValido(Posicion nuevaPosicion, Tablero tablero) {
        int dx = Math.abs(nuevaPosicion.columna() - this.getPosicion().columna());
        int dy = Math.abs(nuevaPosicion.fila() - this.getPosicion().fila());

        return (dx <= 1 && dy <= 1) &&
                (!tablero.hayPiezaAliada(nuevaPosicion, this.getColor()));
    }

    @Override
    public String toString() {
        return getColor() == Color.BLANCO ? "♔" : "♚";
    }
}
