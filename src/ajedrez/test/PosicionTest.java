package ajedrez.test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ajedrez.modelo.Posicion;

public class PosicionTest {

    @Test
    public void testConstructorYGetters() {
        Posicion pos = new Posicion(3, 5);
        assertEquals(3, pos.getFila());
        assertEquals(5, pos.getColumna());
    }

    @Test
    public void testSetters() {
        Posicion pos = new Posicion(0, 0);
        pos.setFila(6);
        pos.setColumna(2);
        assertEquals(6, pos.getFila());
        assertEquals(2, pos.getColumna());
    }

    @Test
    public void testEquals() {
        Posicion p1 = new Posicion(2, 3);
        Posicion p2 = new Posicion(2, 3);
        Posicion p3 = new Posicion(3, 2);
        assertEquals(p1, p2); // Deberian ser iguales
        assertNotEquals(p1, p3); // Deberian ser diferentes
    }

    @Test
    public void testHashCode() {
        Posicion p1 = new Posicion(4, 4);
        Posicion p2 = new Posicion(4, 4);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

}
