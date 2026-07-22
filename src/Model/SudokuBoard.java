/** * Represents the Sudoku board. 
 * 
 * Responsibilities: 
 * - Store the 9x9 Sudoku grid.
 * - Provide methods to read and update cell values. 
 * - Display the board for testing purposes. 
 * 
 * @author Ganta Vikram Jairam Reddy 
 */
package Model;

public class SudokuBoard {
    
    private int[][] board;

    /** 
     * Creates an empty Sudoku board. All cells are initialized with 0. 
     */
    public SudokuBoard() {
        board = new int[9][9];
    }

    /** 
     * Creates a Sudoku board using an existing puzzle. 
     * 
     * @param board 9x9 integer array representing Sudoku puzzle 
     */
    public SudokuBoard(int[][] board) {
        this.board = board;
    }

    /** 
     * Sets all cells back to 0. 
     */
    public void resetBoard() {
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                board[row][col] = 0;
            }
        }
    }

    /** 
     * Prints the Sudoku board in a readable format. 
     * Used for testing before implementing GUI. 
     */
    public void printBoard() {
        for(int row = 0; row < 9; row++) {

            if(row % 3 == 0) {
                System.out.println("-------------------------");
            }

            for(int col = 0; col < 9; col++) {
                if(col % 3 == 0) {
                    System.out.print("| ");
                }
                System.out.print(board[row][col] + " ");
            }

            System.out.println("|");
        }

        System.out.println("-------------------------");
    }

    /** * Checks whether a cell is empty. 
     * 
     * @param row row index 
     * @param col column index 
     * @return true if cell contains 0 
     */
    public boolean isEmpty(int row, int col) {
        return board[row][col] == 0;
    }

    /** 
     * Sets a cell value to 0. 
     * 
     * @param row row index 
     * @param col column index 
     */
    public void clearCell(int row, int col) {
        board[row][col] = 0;
    }

    /** 
     * Retrieves the value stored in a specific cell. 
     * 
     * @param row row index 
     * @param col column index 
     * @return value stored in the cell 
     */
    public int getCellValue(int row, int col) {
        return board[row][col];
    }

    /** 
     * Returns the complete Sudoku grid. 
     * 
     * @return 9x9 Sudoku board 
     */
    public int[][] getBoard() {
        return board;
    }

    /** 
     * Updates the value of a specific cell. 
     * 
     * @param row row index 
     * @param col column index 
     * @param value number to place in the cell 
     */
    public void setCellValue(int row, int col, int value) {
        if(value < 0 || value > 9) {
            throw new IllegalArgumentException("Value must be between 0 and 9");
        }
        board[row][col] = value;
    }
}
