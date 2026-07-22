/** 
 * Validates Sudoku moves by checking rows, columns, and 3x3 boxes. 
 * 
 * Responsibilities: 
 * - Check if a number can be placed in a cell. 
 * - Validate row, column, and box constraints. 
 * 
 * @author Ganta Vikram Jairam Reddy 
 */
package Model;

public class SudokuValidator {
    
    private SudokuBoard board;

    /** 
     * Constructor 
     * 
     * @param board Sudoku board to validate
     */
    public SudokuValidator(SudokuBoard board) {
        this.board = board;
    }

    /** 
     * Checks if a move is valid. 
     * 
     * @param row row position 
     * @param col column position 
     * @param number number to place 
     * @return true if move is valid, otherwise false
     */
    public boolean isValidMove(int row, int col, int number) {
        return !isNumberInRow(row, number) && !isNumberInColumn(col, number)
                && !isNumberInBox(row, col, number);
    }

    /** 
     * Checks if number already exists in row. 
     */
    private boolean isNumberInRow(int row, int number) {

        for(int col = 0; col < 9; col++) {
            if(board.getCellValue(row, col) == number) {
                return true;
            }
        }

        return false;
    }

    /** 
     * Checks if number already exists in column. 
     */
    private boolean isNumberInColumn(int col, int number) {

        for(int row = 0; row < 9; row++) {
            if(board.getCellValue(row, col) == number) {
                return true;
            }
        }

        return false;
    }


    /** 
     * Checks if number already exists in 3x3 box. 
     */
    private boolean isNumberInBox(int row, int col, int number) {

        int startRow = row - (row % 3);
        int startCol = col - (col % 3);

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {

                if(board.getCellValue(startRow + i, startCol + j) == number) {
                    return true;
                }
            }
        }

        return false;
    }

    /** 
     * Checks if number is between 1 and 9. 
     */
    public boolean isValidNumber(int number) {
        return number >= 1 && number <= 9;
    }
}
