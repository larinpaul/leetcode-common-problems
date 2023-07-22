//// 2023/07/22 // 10:12 //

//// 79. Word Search // Medium //

// Given an m x n grid of characters board and a string word, return true if word
// exists in the grid.

// The worst can be constructed form letters of sequentially adjacent cells, where adjacent
// cells are horizontally or vertically neighboring. The same letter cell may not be used
// more than once.

// Example 1:
// Picture
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true

// Example 2:
// Image
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true

// Example 3:
// Image
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false

// Constraints:
// * m == board.length
// * n = board[i].length
// * 1 <= m, n <= 6
// * 1 <= word.length <= 15
// * board and word consist of only lowercase and uppercase English letters.

// Follow up: Could you use search pruning to make your solution faster with a larger
// board?

class WordSearch {

    // Explanation
    // This problem is a classic application of the Depth First Search (DFS)
    // algorithm. In this case, we traverse the 2D grid in a way that each
    // step goes to a neighboring cell and we try to match the characters
    // along the way with the input word. DFS is suitable for this problem
    // because it explores as far as possible along each branch before
    // going back.

    // To solve this problem we iterate over each cell in the board. For
    // each cell, we initiate a Depth First Search if the character in the cell
    // matches the first character of the word. During the DFS, we mark
    // the cell as visited and then explore the neighboring cells (left, right,
    // up, and down). If the next character in the word matches with the
    // current neighboring cell, we continue the DFS with the next
    // character. If we reach the end of the word during the DFS, that
    // means we have found the word in the board, and we return true. If
    // the DFS ends without finding the word, we backtrack by marking
    // the cell as unvisited and continue with the next cell.

    // Remember that we cannot use the same cell more than once. So
    // we should keep track of the cells we have visited.

    // Code:
    private char[][] board;
    private int ROWS;
    private int COLS;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;

        for (int row = 0; row < this.ROWS; ++row) {
            for (int col = 0; col < this.COLS; ++col) {
                if (this.backtrack(row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean backtrack(int row, int col, String word, int index) {
        /* Step 1). Check the bottom case. */
        if (index >= word.length()) {
            return true;
        }

        /* Step 2). Check the boundaries. */
        if (
                row < 0
                        || row == this.ROWS
                        || col < 0 || col == this.COLS
                        || this.board[row][col] != word.charAt(index)
        ) {
            return false;
        }

        /* Step 3). For the current cell, mark it as visited. */
        this.board[row][col] = '#';

        /* Step 4). Explore the neighbors in DFS */
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; ++d) {
            if (this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1)) {
                return true;
            }
        }

        /* Step 5). For the current cell, revert the mark back. */
        this.board[row][col] = word.charAt(index);
        return false;
    }

    // Big O
    // Time and Space Complexity

    // The time complexity of the above solution is O(N * 4^L),
    // where N is the total number of cells in the input board, and L is the length
    // of the word to be matched. For the worst-case, the algorithm loops
    // over all the cells of the board (N) and for each cell, it could
    // potentially perform a DFS of the length of thw word 4^L.

    // The space complexity is O(L), where L is the length of the word to
    // be matched. This is because the maximum amount of space is
    // consumed by the recursion stack in the worst-case scenario when
    // the length of the word matches the number of cells in the grid.
    // The main consumption of the memory lies in the recursion call stack.

    // For the follow-up question, to make the solution faster with a
    // larger board, we could potentially use some kind of pruning
    // strategies, like if we know that the current board doesn't contain
    // enough characters needed for the word, we can stop and return
    // false early.

}
