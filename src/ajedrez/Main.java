package ajedrez;

import ajedrez.modelo.Tablero;
import ajedrez.vista.TableroGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tablero tablero = new Tablero();
            JFrame frame = new JFrame("Ajedrez - Proyecto UFRO");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new TableroGUI(tablero));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
