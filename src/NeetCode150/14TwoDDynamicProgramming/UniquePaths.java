//// 2023/04/22 // 14:17 //

//// 62. Unique Paths // Medium

// There is a robot on an m x n grid. The robot is initially located at the lop-left corner (i.e., grid[0]
// [0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can
// only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can take to
// reach the bottom-right corner.

// The test cases are generated so that the answer will be less than or equal to 2 * 10^9.

// Example 1:
// Picture
// Input: m = 3, n = 7
// Output: 28

// Example 2:
// Input: m = 3, n = 2
// Output: 3
// Explanation: From the top-left corner, there are a total of 3 ways to
// reach the bottom-right corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down

// Constraints:
// * 1 <= m, n <= 100

import java.util.Arrays;

class UniquePaths {
    public int uniquePaths(int m, int n) {
        // We can use dynamic programming to store the number of paths for each cell
        // The base case is that the first row adn column have only one path
        // For any other cell, the number of paths is the sum of the paths from
        // the left adn top cells
        // We can use a 2D array to store the results
        int[][] dp = new int[m][n];

        // Fill the first row and column iwth 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the rest of the cells with the sum of the left and top cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // Return the bottom-right cell as the final answer
        return dp[m - 1][n - 1];
    }
}

// Explanation:
// * The time complexity of this solution is O(m * n) since we need to iterate over all the
// cells in the grid and fill them with the results.
// * The space complexity of this solution is O(m * n), since we need to use a 2D array to
// store the results. We can optimize this by using only two 1D arrays to store the
// previous and current rows, which would reduce the space complexity to O(n).

// One can optimize the solution by reducing the space complexity.
// The space complexity of the current solution is O(m * n). since we use a 2D array
// to store teh results. However, we can observe that we only need to keep track of the
// previous and current rows of the array, since those are the only ones we use to calculate
// the next row. Therefore, we can use two 1D arrays instead of a 2D array, and swap them
// after each iteration. This will reduce the space complexity to O(n),
// where n is the number of columns in the grid.

class SolutionUniquePaths {

    public int uniquePaths(int m, int n) {
        // We can use two 1D arrays to store the previous and current rows of results
        // The base case is that the first row and column have only one path
        // For any other cell, the number of paths is the sum of the paths
        // from the left and top cells
        int[] prev = new int[n];
        int[] curr = new int[n];

        // Fill the first row and column with 1
        Arrays.fill(prev, 1);
        Arrays.fill(curr, 1);

        // Fill the rest of the cells with the sum of the left and top cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                curr[j] = prev[j] + curr[j - 1];
            }
            // Swap the previous and current arrays
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        // Return the last element of the previous array as the final answer
        return prev[n - 1];
    }
}




