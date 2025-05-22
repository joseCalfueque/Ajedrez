package ajedrez.vista;

import ajedrez.modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableroGUI extends JPanel {
    private final Tablero tablero;
    private Posicion seleccionada;

    public TableroGUI(Tablero tablero) {
        this.tablero = tablero;
        setPreferredSize(new Dimension(640, 640));
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int fila = e.getY() / 80;
                int columna = e.getX() / 80;
                Posicion clic = new Posicion(fila, columna);

                if (seleccionada == null) {
                    Pieza p = tablero.getPieza(clic);
                    if (p != null) {
                        seleccionada = clic;
                        repaint();
                    }
                } else {
                    tablero.moverPieza(seleccionada, clic);
                    seleccionada = null;
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        boolean blanco = true;

        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                g.setColor(blanco ? new Color(240, 217, 181) : new Color(181, 136, 99));
                g.fillRect(col * 80, fila * 80, 80, 80);

                Pieza p = tablero.getPieza(new Posicion(fila, col));
                if (p != null) {
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("SansSerif", Font.BOLD, 40));
                    g.drawString(p.toString(), col * 80 + 25, fila * 80 + 50);
                }

                if (seleccionada != null && seleccionada.fila() == fila && seleccionada.columna() == col) {
                    g.setColor(Color.YELLOW);
                    g.drawRect(col * 80, fila * 80, 80, 80);
                    g.drawRect(col * 80 + 1, fila * 80 + 1, 78, 78);
                }

                blanco = !blanco;
            }
            blanco = !blanco;
        }
    }
}
