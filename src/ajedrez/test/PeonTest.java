package ajedrez.test;

import ajedrez.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PeonTest {

    @Test
    public void testMovimientoValidoAdelante() {
        Tablero tablero = new Tablero();
        Peon peon = new Peon(Color.BLANCO, new Posicion(6, 0));
        assertTrue(peon.movimientoValido(new Posicion(5, 0), tablero));
    }

    @Test
    public void testMovimientoInvalidoDiagonalSinComer() {
        Tablero tablero = new Tablero();
        Peon peon = new Peon(Color.BLANCO, new Posicion(6, 0));
        assertFalse(peon.movimientoValido(new Posicion(5, 1), tablero));
    }

    @Test
    public void testMovimientoDobleDesdeInicio() {
        Tablero tablero = new Tablero();
        Peon peon = new Peon(Color.BLANCO, new Posicion(6, 0));
        assertTrue(peon.movimientoValido(new Posicion(4, 0), tablero));
    }
}
