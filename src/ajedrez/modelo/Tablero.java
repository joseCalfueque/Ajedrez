package ajedrez.modelo;

public class Tablero {

    private Pieza[][] piezas;

    public Tablero() {
        piezas = new Pieza[8][8];
        inicializarPiezas();
    }

    private void inicializarPiezas() {
        for (int i = 0; i < 8; i++) {
            piezas[1][i] = new Peon("negro");
            piezas[6][i] = new Peon("blanco");
        }
    }

    public Pieza getPieza(int fila, int columna) {
        return piezas[fila][columna];
    }

    public void moverPieza(int origenX, int origenY, int destinoX, int destinoY) {
        Pieza pieza = piezas[origenX][origenY];
        if (pieza != null && pieza.movimientoValido(origenX, origenY, destinoX, destinoY)) {
            piezas[destinoX][destinoY] = pieza;
            piezas[origenX][origenY] = null;
        }
    }
}
