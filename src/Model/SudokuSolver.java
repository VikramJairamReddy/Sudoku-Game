/** 
 * Solves Sudoku puzzles using the backtracking algorithm. 
 * 
 * Responsibilities: 
 * - Find empty cells and try possible numbers. 
 * - Backtrack when a solution is not possible. 
 * 
 * @author Ganta Vikram Jairam Reddy 
 */

package Model;

public class SudokuSolver {
    
    private SudokuBoard board; 
    private SudokuValidator validator; 
    
    /** * Constructor 
     *
     * @param board Sudoku board to solve 
     */ 
    public SudokuSolver(SudokuBoard board) { 

        if(board == null) {
            throw new IllegalArgumentException("Board cannot be null");
        }
        
        this.board = board; 
        this.validator = new SudokuValidator(board); 
    }

    /**
     * Starts the Sudoku solving process.
     *
     * @return true if a solution is found, otherwise false
     */
    public boolean solveSudoku() {
        return solve();
    }

    /**
     * Uses recursive backtracking to solve the puzzle.
     * 
     * 
     * @return true is solution is found, otherwise false.
     */
    public boolean solve() {

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {

                if(board.isEmpty(i, j)) {

                    // Try possible values from 1 to 9
                    for(int k = 1; k <= 9; k++) {
                        // Check if number can be placed at (i, j)
                        if(validator.isValidMove(i, j, k)) {

                            // temporarily places the number
                            board.setCellValue(i, j, k);
                            if(solve()) {
                                return true;
                            }
                            // Backtrack if solution fails
                            board.clearCell(i, j);
                        }
                    }
                    // No valid number found for this cell
                    return false;
                }
            }
        }
        // No empty cells remaining, puzzle is solved
        return true;
    }
}
