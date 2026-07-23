/**
 * Controls the interaction between Sudoku GUI and model.
 *
 * Responsibilities:
 * - Handle user actions from SudokuFrame.
 * - Convert GUI input into Sudoku board data.
 *
 * @author Ganta Vikram Jairam Reddy
 */

package Controller;

import Model.SudokuBoard;
import Model.SudokuSolver;
import View.SudokuFrame;


public class SudokuController {

    private SudokuFrame frame;
    private SudokuBoard board;
    private SudokuSolver solver;

    /**
     * Creates Sudoku controller.
     *
     * @param frame Sudoku graphical interface
     */
    public SudokuController(SudokuFrame frame) {

        this.frame = frame;
        this.board = new SudokuBoard();
        this.solver = new SudokuSolver(board);

        frame.solveButton().addActionListener(e -> solveSudoku());
        frame.resetButton().addActionListener(e -> resetBoard());
        frame.newGameButton().addActionListener(e -> resetBoard());

        frame.setVisible(true);
    }



    /**
     * Solves Sudoku puzzle entered by user.
     */
    private void solveSudoku() {

        frame.disableButtons(true);
        updateBoardFromView();
        boolean solved = solver.solveSudoku();

        if(solved) {
            updateViewFromBoard();
        }
        else {
            frame.showError();
        }
        frame.disableButtons(false);
    }

    /**
     * Updates model board using GUI values.
     */
    private void updateBoardFromView() {

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {

                String value = frame.getTextAt(row, col);
                if(!value.isEmpty()) {

                    board.setCellValue(row, col, Integer.parseInt(value));
                }
                else {
                    board.clearCell(row, col);
                }
            }
        }
    }

    /**
     * Updates GUI cells using solved board.
     */
    private void updateViewFromBoard() {

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                frame.setTextAt(row, col, String.valueOf(board.getCellValue(row, col)));
            }
        }
    }

    /**
     * Clears Sudoku board.
     */
    private void resetBoard() {

        board.resetBoard();

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                frame.setTextAt(row,col,"");
            }
        }
    }
}