package ajedrez.modelo;

public class Caballo extends Pieza {
    public Caballo(Color color, Posicion posicion) {
        super(color, posicion);
    }

    @Override
    public boolean movimientoValido(Posicion nuevaPosicion, Tablero tablero) {
        int dx = Math.abs(nuevaPosicion.columna() - this.getPosicion().columna());
        int dy = Math.abs(nuevaPosicion.fila() - this.getPosicion().fila());

        return (dx == 2 && dy == 1 || dx == 1 && dy == 2) &&
                (!tablero.hayPiezaAliada(nuevaPosicion, this.getColor()));
    }

    @Override
    public String toString() {
        return getColor() == Color.BLANCO ? "♘" : "♞";
    }
}
