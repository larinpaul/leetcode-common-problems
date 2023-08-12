//// 2023/08/12 // 11:37 //

//// 329. Longest Increasing Path in a Matrix // Hard //

// Given an m x n integers matrix, return the length of the longest increasing path in
// matrix.

// From each cell, you can either move in four directions: left, right, up, or down.
// You may not move diagonally or move outside of the boundary (i.e., wrap-around is not allowed).

// Example 1:
// Picture
// Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
// Output: 4
// Explanation: The longest increasing path is [1, 2, 6, 9].

// Example 2:
// Picture
// Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
// Output: 4
// Explanation: The longest increasing path is [3, 4, 5, 6]. Moving
// diagonally is not allowed.

// Example 3:
// Input: matrix = [[1]]
// Output: 1

// Constraints:
// * m == matrix.length
// * n == matrix[i].length
// * 1 <= m, n <= 200
// * 0 <= matrix[i][j] <= 2^31 - 1


import java.util.Arrays;
import java.util.Map;

class LongestIncreasingPathInMatrix {

    // Explanation:
    // To find the longest increasing path in a matrix, we can use a depth-first
    // search (DFS) approach. We will start from each cell in the matrix and
    // explore its neighbors (up, down, left, adn right) that have a higher value.
    // We will keep track of the maximum path length encountered during the
    // DFS traversal. We can optimize this approach by suing memoization,
    // where we store the already calculated path lengths for each cell in a
    // separate array. This way, we avoid redundant calculations and improve
    // the efficiency of the solution.

    // Optimal Solution:
    // 1. Define a global variable dirs to represent the possible directions
    // (up, down, left, and right).
    // 2. Define a helper method dfs that makes the matrix, memoization
    // array, and the current cell's coordinates (i, j) as parameters.
    // 3. In the dfs method:
    // * If the memoization array already contains a value for the current
    // cell, return that value.
    // * Otherwise, initialize a variable maxPath to 1 (as the current cell
    // itself forms a path of length 1).
    // * Iterate through each possible direction in dirs:
    // ** Caclulate the coordinates (x, y) of the neighbor cell.
    // ** Check if the conditions are met, recursively call dfs on the
    // neighbor cell and update maxPath by adding 1 to the
    // returned result.
    // * Update the memoization array for the current cell with the value
    // of maxPath.
    // * Return maxPath.
    // 4. Initialize variables m and n to store the number of rows and columns
    // in the matrix, respectively.
    // 5. Initialize a memoization array dp with dimensions m x n, and set all
    // values to 0.
    // 6. Initialize a variable maxLength to 0.
    // 7. Iterate through each cell in the matrix, and for each cell, update
    // maxLength by taking the maximum value between maxLength and
    // the result of calling dfs on the current cell.
    // 8. Return maxLength as the final result.

    // Code:
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int maxLength = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, dfs(matrix, dp, i, j));
            }
        }

        return maxLength;
    }

    private int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int maxPath = 1;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                && matrix[x][y] > matrix[i][j]) {
                    maxPath = Math.max(maxPath, 1 + dfs(matrix, dp, x, y));
            }
        }

        dp[i][j] = maxPath;
        return maxPath;
    }

    // Big O:

    // Time Complexity:
    // The DFS traversal visits each cell exactly once, so the
    // time complexity is O(m * n), where m is the number of rows
    // and n is the number of columns in the matrix.

    // Space Complexity:
    // We use additional space for the memoization array dp,
    // which has dimensions m x n, resulting in a space complexity of O(m * n).

}
