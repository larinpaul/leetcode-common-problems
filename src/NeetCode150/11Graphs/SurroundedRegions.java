//// 2023/07/26 // 11:54 //

//// 130. Surrounded Regions // Medium //

// Given an m x n matrix board containing 'X' and 'O', capture all regions that
// are 4-directionally surrounded by 'X'.

// A region is captured by flipping all 'O's into 'X's in that surrounded regions.

// Example 1:
// Pictures
// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
// Explanation: Notice that an 'O' should not be flipped if:
// - It is on the border, or
// - It is adjacent to an 'O' that should not be flipped.
// The bottom 'O' is on the border, so it is not flipped.
// The other three 'O' form a surrounded region, so they are flipped.

// Example 2:
// Input: board = [["X"]]
// Output: [["X"]]

// Constraints:
// * m == board.length
// * n == board[i].length
// * 1 <= m, n <= 200
// * board[i][j] is 'X' or 'O'.

class SurroundedRegions {

    // This problem can be solved using a classic depth-first search (DFS) approach.

    // However, instead of searching from each 'O' to see if it is surrounded,
    // we can start from the border 'O's and mark all the 'O's that are connected to them.
    // All the unmarked 'O's in the board are surrounded by 'O's.

    // Here are the steps:
    // 1. Traverse the border of the board. If there is an 'O', perform DFS from there
    // and mark all the 'O's that are connected to the border 'O'.
    // 2. Traverse the entire board. Change all the marked 'O's back to 'O'
    // and the remaining 'O's to 'X'

    // Code:
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#'; // mark the 'O's that are not surrounded
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        // Traverse the border of the board
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m-1][j] == 'O') {
                dfs(board, m-1, j);
            }
        }
        // Traverse the entire board
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    // Big O Analysis

    // The time complexity for this approach is O(m*n), where m and n are the dimensions of the board.
    // This is because in the worst case scenario, we might need to visit all the cells in the board.

    // The space complexity is also O(mn) in the worst case, due to the recursion stack
    // during the DFS traversal. In the worst case, the depth of the recursion could be mn.
    // However, in practice, the space complexity would be significantly less than O(mn)
    // as the depth of the recursion would be much less than mn for most cases.

}
