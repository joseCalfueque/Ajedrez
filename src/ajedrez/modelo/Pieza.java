package ajedrez.modelo;

public abstract class Pieza {
    private Color color;
    private Posicion posicion;

    public Pieza(Color color, Posicion posicion) {
        this.color = color;
        this.posicion = posicion;
    }

    public Color getColor() {
        return color;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion nueva) {
        this.posicion = nueva;
    }

    public abstract boolean movimientoValido(Posicion nuevaPosicion, Tablero tablero);
}
