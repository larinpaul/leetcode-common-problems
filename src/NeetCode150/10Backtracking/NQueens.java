//// 2023/07/25 // 22:50 //

//// 51. N-Queens // Hard //

// The n-queens puzzle is the problem of placing n queens of an n x n chessboard
// such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return
// the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement,
// where 'Q' and '.' both indicate a queen and an empty space, respectively.

// Example 1:
// Images
// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

// Example 2:
// Input: n = 1
// Output: [["Q"]]

// Constraints:
// * 1 <= n <= 9

import java.util.ArrayList;
import java.util.List;

class NQueens {

    // The N-Queens problem is a classic constraint satisfaction problem that can be solved using backtracking.
    // The idea is to place queens one by one in different columns, starting from the leftmost
    // column. When placing a queen in a column, we check for clashes with already placed queens.
    // In the current columns, if we find a row where there is no clash, we mark this cell and move
    // to the next column. IF none of the rows work, we return false. If placement of the queen
    // in all columns is successful, we have found a solution.

    // In order to track where the queens are being placed, we can use an integer array of size n,
    // where the index represents the row and the value at that index represents the column.

    // Code
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        solveNQueens(n, 0, new int[n], results);
        return results;
    }

    private void solveNQueens(int n, int row, int[] queens, List<List<String>> results) {
        if (n == row) {
            addSolution(queens, results);
            return;
        }

        for (int col = 0; col < n; col++) {
            queens[row] = col;
            if (isValid(queens, row)) {
                solveNQueens(n, row + 1, queens, results);
            }
        }
    }

    private boolean isValid(int[] queens, int row) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == queens[row] || Math.abs(queens[i] - queens[row]) == row - i) {
                return false;
            }
        }
        return true;
    }

    private void addSolution(int[] queens, List<List<String>> results) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {
                if (queens[i] == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        results.add(list);
    }

    // Big O

    // Time Complexity

    // The time complexity of this solution is O(N!) because in the worst case,
    // we have to explore all possible permutations of row and column placements for the queens.

    // The N-Queens problem has a huge search space, so it's not feasible to solve it using brute force
    // for larger values of N. But this backtracking approach prunes a significant portion
    // of the search space, making it feasible for smaller values of N.

    // Space Complexity

    // The space complexity is O(N) because in the worst case, if we have a valid configuration,
    // we will end up storing one configuration of all N queens in the queens array.
    // The space for the recursive call stack is also O(N), so the total space complexity is O(N).

}
