package ajedrez.vista;

import ajedrez.modelo.Tablero;
import ajedrez.modelo.Pieza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableroGUI {
    private JFrame ventana;
    private JButton[][] botones;
    private Tablero tablero;
    private int origenX = -1, origenY = -1;

    public TableroGUI() {
        tablero = new Tablero();
        ventana = new JFrame("Ajedrez");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 600);
        ventana.setLayout(new GridLayout(8, 8));
        botones = new JButton[8][8];

        inicializarBotones();
        ventana.setVisible(true);
    }

    private void inicializarBotones() {
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                JButton boton = new JButton();
                boton.setFont(new Font("Arial", Font.BOLD, 20));
                boton.setBackground((fila + col) % 2 == 0 ? Color.WHITE : Color.GRAY);
                int finalFila = fila;
                int finalCol = col;

                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        manejarClick(finalFila, finalCol);
                    }
                });

                botones[fila][col] = boton;
                ventana.add(boton);
            }
        }
        actualizarTablero();
    }

    private void manejarClick(int fila, int col) {
        if (origenX == -1 && tablero.getPieza(fila, col) != null) {
            origenX = fila;
            origenY = col;
        } else {
            tablero.moverPieza(origenX, origenY, fila, col);
            origenX = -1;
            origenY = -1;
            actualizarTablero();
        }
    }

    private void actualizarTablero() {
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                Pieza pieza = tablero.getPieza(fila, col);
                if (pieza != null) {
                    botones[fila][col].setText(pieza instanceof Peon ? "P" : "?");
                } else {
                    botones[fila][col].setText("");
                }
            }
        }
    }
}