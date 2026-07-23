/**
 * Starts the Sudoku application.
 *
 * Responsibilities:
 * - Initialize the Swing user interface.
 * - Launch the Sudoku game window.
 *
 * @author Ganta Vikram Jairam Reddy
 */

import Controller.SudokuController;
import View.SudokuFrame;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new SudokuController(new SudokuFrame());
        });
    }
}