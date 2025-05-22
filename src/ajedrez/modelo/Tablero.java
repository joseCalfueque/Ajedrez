package ajedrez.modelo;

public class Tablero {
    private Pieza[][] tablero = new Pieza[8][8];

    public Tablero() {
        inicializar();
    }

    public void inicializar() {
        // Blancas
        tablero[7][0] = new Torre(Color.BLANCO, new Posicion(7, 0));
        tablero[7][1] = new Caballo(Color.BLANCO, new Posicion(7, 1));
        tablero[7][2] = new Alfil(Color.BLANCO, new Posicion(7, 2));
        tablero[7][3] = new Dama(Color.BLANCO, new Posicion(7, 3));
        tablero[7][4] = new Rey(Color.BLANCO, new Posicion(7, 4));
        tablero[7][5] = new Alfil(Color.BLANCO, new Posicion(7, 5));
        tablero[7][6] = new Caballo(Color.BLANCO, new Posicion(7, 6));
        tablero[7][7] = new Torre(Color.BLANCO, new Posicion(7, 7));
        for (int i = 0; i < 8; i++)
            tablero[6][i] = new Peon(Color.BLANCO, new Posicion(6, i));

        // Negras
        tablero[0][0] = new Torre(Color.NEGRO, new Posicion(0, 0));
        tablero[0][1] = new Caballo(Color.NEGRO, new Posicion(0, 1));
        tablero[0][2] = new Alfil(Color.NEGRO, new Posicion(0, 2));
        tablero[0][3] = new Dama(Color.NEGRO, new Posicion(0, 3));
        tablero[0][4] = new Rey(Color.NEGRO, new Posicion(0, 4));
        tablero[0][5] = new Alfil(Color.NEGRO, new Posicion(0, 5));
        tablero[0][6] = new Caballo(Color.NEGRO, new Posicion(0, 6));
        tablero[0][7] = new Torre(Color.NEGRO, new Posicion(0, 7));
        for (int i = 0; i < 8; i++)
            tablero[1][i] = new Peon(Color.NEGRO, new Posicion(1, i));
    }

    public Pieza getPieza(Posicion posicion) {
        return tablero[posicion.fila()][posicion.columna()];
    }

    public boolean estaVacio(Posicion pos) {
        return getPieza(pos) == null;
    }

    public boolean hayPiezaOponente(Posicion pos, Color color) {
        Pieza p = getPieza(pos);
        return p != null && p.getColor() != color;
    }

    public boolean hayPiezaAliada(Posicion pos, Color color) {
        Pieza p = getPieza(pos);
        return p != null && p.getColor() == color;
    }

    public void moverPieza(Posicion origen, Posicion destino) {
        Pieza pieza = getPieza(origen);
        if (pieza != null && pieza.movimientoValido(destino, this)) {
            tablero[destino.fila()][destino.columna()] = pieza;
            pieza.setPosicion(destino);
            tablero[origen.fila()][origen.columna()] = null;
        }
    }
}
