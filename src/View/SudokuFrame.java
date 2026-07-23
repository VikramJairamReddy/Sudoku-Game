/**
 * Represents the main graphical interface for the Sudoku game.
 *
 * Responsibilities:
 * - Create Sudoku application window.
 * - Display the 9x9 Sudoku grid.
 * - Provide user interaction components.
 * - Restricts user input for Sudoku cells: Only one digit per cell and only between [1-9]
 *
 * @author Ganta Vikram Jairam Reddy
 */

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class SudokuFrame extends JFrame {

    private JTextField[][] cells;

    JButton solveButton;
    JButton resetButton;
    JButton newGameButton;

    /**
     * Creates Sudoku window.
     */
    public SudokuFrame() {

        setTitle("Sudoku Game");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        cells = new JTextField[9][9];

        createTitle();
        createBoard();
        createButtons();
    }

    /**
     * Creates title for the application.
     */
    private void createTitle() {
        JLabel title = new JLabel("Sudoku Solver", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD,28));
        title.setBorder(BorderFactory.createEmptyBorder(15,0,15,0));

        add(title, BorderLayout.NORTH);
    }

    /**
     * Creates the 9x9 Sudoku grid.
     */
    private void createBoard() {

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(9, 9));

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {

                JTextField cell = new JTextField();

                cell.setHorizontalAlignment(JTextField.CENTER);
                cell.setFont(new Font("Arial",Font.BOLD,22));
                cell.setBorder(BorderFactory.createLineBorder(Color.GRAY));

                // Restricts user input for Sudoku cells.
                // Allows only one digit per cell and numbers from [1-9]
                cell.addKeyListener(new KeyAdapter() {

                    public void keyTyped(KeyEvent e) {
                
                        char c = e.getKeyChar();
                        if(!Character.isDigit(c) || c == '0' || cell.getText().length() >= 1) {
                            e.consume();
                        }
                    }
                });

                cells[row][col] = cell;

                boardPanel.add(cell);
            }
        }

        add(boardPanel, BorderLayout.CENTER);
    }


    /**
     * Creates control buttons.
     */
    private void createButtons() {

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15,0,15,0));

        solveButton = new JButton("Solve");
        buttonAppearance(solveButton, new Color(10, 209, 46));

        resetButton = new JButton("Reset");
        buttonAppearance(resetButton, new Color(10, 156, 145));

        newGameButton = new JButton("New Game");
        buttonAppearance(newGameButton, new Color(24, 71, 130));

        buttonPanel.add(solveButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(newGameButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
    * Sets the appearance of buttons used in the dashboard.
    *
    * @param button button whose appearance will be modified
    * @param color background color of the button
    */
    private void buttonAppearance(JButton button, Color color) {
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(130,35));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
    }

    /**
     * Returns solve button.
     *
     * @return solve button
     */
    public JButton solveButton() {
        return solveButton;
    }

    /**
     * Returns reset button.
     *
     * @return reset button
     */
    public JButton resetButton() {
        return resetButton;
    }

    /**
     * Returns new game button.
     *
     * @return new game button
     */
    public JButton newGameButton() {
        return newGameButton;
    }

    /**
     * Gets user entered value from a Sudoku cell.
     *
     * @param row row index
     * @param col column index
     * @return text entered in the cell
     */
    public String getTextAt(int row, int col) {
        return cells[row][col].getText().trim();
    }
}