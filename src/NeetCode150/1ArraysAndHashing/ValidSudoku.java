//// 2023/05/15 // 10:49 //

//// 36. Valid Sudoku // Medium //

// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
// validates according to the following rules:
// * Each row must contain the digits 1-9 without repetition.
// * Each column must contain the digits 1-9 without repetition.
// * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

// Note:
// * a Sudoku board (partially filled) could be valid but is not necessarily solvable.
// * Only the filled cells need to be validated according to the mentioned rules.

// Example 1:
//Input: board =
//        [["5","3",".",".","7",".",".",".","."]
//        ,["6",".",".","1","9","5",".",".","."]
//        ,[".","9","8",".",".",".",".","6","."]
//        ,["8",".",".",".","6",".",".",".","3"]
//        ,["4",".",".","8",".","3",".",".","1"]
//        ,["7",".",".",".","2",".",".",".","6"]
//        ,[".","6",".",".",".",".","2","8","."]
//        ,[".",".",".","4","1","9",".",".","5"]
//        ,[".",".",".",".","8",".",".","7","9"]]
//        Output: true

// Example 2:
//Input: board =
//        [["8","3",".",".","7",".",".",".","."]
//        ,["6",".",".","1","9","5",".",".","."]
//        ,[".","9","8",".",".",".",".","6","."]
//        ,["8",".",".",".","6",".",".",".","3"]
//        ,["4",".",".","8",".","3",".",".","1"]
//        ,["7",".",".",".","2",".",".",".","6"]
//        ,[".","6",".",".",".",".","2","8","."]
//        ,[".",".",".","4","1","9",".",".","5"]
//        ,[".",".",".",".","8",".",".","7","9"]]
//        Output: false
// Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
// Since there are two 8's in the top left 3x3 sub-box, it is invalid.

// Constraints:
// * board.length == 9
// * board[i].length == 9
// * board[i][j] is a digit 1-9 or '.'.

import java.util.HashSet;
import java.util.Set;

class ValidSudoku {

    // Solution: To check if a Sudoku board is valid, we need to ensure that each row, column, and
    // sub-box contains no duplicate digits. We can use a set data structure to store the seen
    // digits for each row, column, and sub-box. We can iterate through the board and check if the
    // current cell is a digit. If it is, we can compute the index of the sub-box that it belongs to
    // using the formula (row / 3) * 3 + (col / 3). Then we can check if the digit is already in the
    // corresponding set of the row, column, or sub-box. If it is, we return false as the board is
    // invalid. Otherwise, we add the digit to the set and continue. If we finish iterating through the
    // board without finding any duplicates, we return true as the board is valid.

    public boolean isValidSudoku(char[][] board) {
        // Create sets to store seen digits for each row, column, and sub-box
        Set<Character>[] rows = new Set[9];
        Set<Character>[] cols = new Set[9];
        Set<Character>[] boxes = new Set[9];
        // Initialize the sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        // Iterate through the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Get the current cell value
                char c = board[i][j];
                // Check if it is a digit
                if (c != '.') {
                    // Compute the index of the sub-box that it belongs to
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    // Check if the digit is already in the corresponding set for the row, column, or sub-box
                    if (rows[i].contains(c) || cols[j].contains(c) || boxes[boxIndex].contains(c)) {
                        // Returns false as the board is invalid
                        return false;
                    }
                    // Add the digit to the set
                    rows[i].add(c);
                    cols[j].add(c);
                    boxes[boxIndex].add(c);
                }
            }
        }
        // Return true as the board is valid
        return true;
    }

    // We use an array of sets to store the seen digits for each row, column, and sub-box.
    // We use a nested loop to iterate through the board and check each cell value.
    // We use a conditional statement to skip the empty cells and only process the digits.
    // We use a mathematical expression to compute the index of the sub-box that the digit belong to.
    // We use another conditional statement to check if the digit is already in any of the sets
    // for the row, column, or sub-box. If it is, we return false immediately.
    // Otherwise, we add the digit to each of the sets and continue.
    // After finishing the loop, we return true.

    // Big O:
    // The time complexity of this algorithm is O(1), since we only iterate through a fixed
    // number of cells (81) and perform constant time operations on each cell.
    // The space complexity of this algorithm is also O(1), since we only use a fixed amount
    // of extra space (27 sets with at most 9 elements each)

}
