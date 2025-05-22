package ajedrez.modelo;

public class Dama extends Pieza {
    public Dama(Color color, Posicion posicion) {
        super(color, posicion);
    }

    @Override
    public boolean movimientoValido(Posicion nuevaPosicion, Tablero tablero) {
        Torre torre = new Torre(this.getColor(), this.getPosicion());
        Alfil alfil = new Alfil(this.getColor(), this.getPosicion());

        return torre.movimientoValido(nuevaPosicion, tablero) ||
                alfil.movimientoValido(nuevaPosicion, tablero);
    }

    @Override
    public String toString() {
        return getColor() == Color.BLANCO ? "♕" : "♛";
    }
}
