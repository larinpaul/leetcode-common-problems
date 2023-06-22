//// 2023/06/22 // 10:23 //

//// 778. Swim in Rising Water // Hard //

// You are given an n x n integer matrix grid where each value grid[i][j] represents the
// elevation at that point (i, j).

// The rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from
// a square to another 4-directionally adjacent square if and only if the elevation of both
// squares individually are at most t. You can swim infinite distances in zero time. Of course,
// you must stay within the boundaries of the grid during your swim.

// Return the least time until you can reach the bottom right square (n - 1, n - 1)
// if you start at the top left square (0,0).

// Example 1:
// Picture
// Input: grid = [[0,2],[1,3]]
// Output: 3
// Explanation:
// At time 0, you are in grid location (0, 0).
// You cannot go anywhere else because 4-directionally adjacent
// neighbors have a higher elevation than t = 0.
// You cannot reach point (1, 1) until time 3.
// When the depth of water is 3, we can swim anywhere inside the grid.

// Example 2:
// Picture
// Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
// Output: 16
// Explanation: The final route is shown
// We need to wait until time 16 so that (0, 0) and (4, 4) are connected.

// Constraints:
// * n == grid.length
// * n == grid[i].length
// * a <= n <= 50
// * 0 <= grid[i][j] < n^2
// * Each value grid[i][j] is unique.

class SwimInRisingWater {

    // Solution:
    // The idea is to use a binary search to find the minimum time t that allows us to
    // swim from the top left to the bottom right of the grid. For each t, we can use a depth-first search (DFS)
    // or a breadth-first-search (BFS) to check if there is a path from (0, 0) to (n - 1, n - 1)
    // that only goes through squares with elevation at most t. If there is such a path, we can
    // try a smaller t, otherwise we try a larger t. The binary search will eventually converge to the
    // optimal t.

    // Explanation:

    // Let's see an example with the following grid:
    // [[0,2],[1,3]]

    // The minimum possible time is 0, but we cannot swim from (0,0) to (1,1) at time 0 because
    // all the adjacent squares have higher elevation than 0. SO we need to increase the time.

    // The maximum possible time is 3, which is the highest elevation in the grid. At time 3, we
    // can swim from (0, 0) to (1, 1) because all the squares have elevation at most 3.
    // So we can try to decrease the time.

    // The optimal time is somewhere between 0 and 3. We can use binary search to find it.
    // We start with the middle value, which is (0 + 3) / 2 = 1.
    // At time 1, we cannot swim from (0, 0) to (1,1)
    // because the square (0, 1) has elevation 2 > 1. So we need to increase the time.

    // We update the lower bound of the binary search to be 2 and repeat the process.
    // The new middle value is (2 + 2) / 2 = 2. At time 2, we still cannot swim from (0, 0) to (1, 1)
    // because the square (1, 0) has elevation 1 > 2. So we need to increase the time again.

    // We update the lower bound of the binary search to be 3 and repeat the process.
    // The new middle value is (3 + 3) / 2 = 3. At time 3, we can swim from (0, 0) to (1, 1)
    // as explained before. So we can try to decrease the time.

    // We update the upper bound of the binary search to be 2 and repeat the process. The new
    // middle value is (3 + 2) / 2 = 2. At time 2, we still cannot swim from (0, 0) to (1, 1)
    // as explained before. So we need to increase the time.

    // We update the lower bound of the binary search to be 3 and repeat the process.
    // The new middle value is (3 + 2) / 2 = 2.
    // This is equal to the upper bound of the binary search,
    // so we have found the optimal time.

    // The optimal time is t = 2 and we return it as the answer.

    // Code: Here is a possible Java code that implements this solution using DFS:
    public int swimInWater(int[][] grid) {
        // get the size of the grid
        int n = grid.length;
        // initialize the lower and upper bounds of binary search
        int low = grid[0][0];
        int high = n * n - 1;
        // loop until low adn high converge
        while (low < high) {
            // get the middle value
            int mid = low + (high - low) / 2;
            // check if there is a path from top left to bottom right at time mid
            if (hasPath(grid, mid)) {
                // try a smaller time
                high = mid;
            } else {
                // try a larger time
                low = mid + 1;
            }
        }
        // return the optimal time
        return low;
    }

    // helper function to check if there is a path from top left to bottom right at time t
    private boolean hasPath(int[][] grid, int t) {
        // get the size of the grid
        int n = grid.length;
        // create a boolean array to mark visited squares
        boolean[][] visited = new boolean[n][n];
        // call dfs from top left square
        return dfs(grid, visited, t, n, n - n, n - n);
    }

    // helper method to perform dfs from a given square
    private boolean dfs(int[][] grid, boolean[][] visited, int t, int n, int i, int j) {
        // check if the square is out of bounds or already visited or has elevation greater than t
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || grid[i][j] > t) {
            // return false;
            return false;
        }
        // mark the square as visited
        visited[i][j] = true;
        // check if the square is the bottom right square
        if (i == n - 1 && j == n - 1) {
            // return true
            return true;
        }
        // try to dfs from the four adjacent squares
        return dfs(grid, visited, t, n, i - 1, j) // up
                || dfs(grid, visited, t, n, i + 1, j) // down
                || dfs(grid, visited, t, n, i, j - 1) // left
                || dfs(grid, visited, t, n, i, j + 1); // right
    }

    // Big O:

    // The time complexity of this solution is O(n^2 * log(n^2)), where n is the size of the
    // grid. This is because we perform binary search on the range [0, n^2 - 1], which takes
    // O(log(n^2)) time. For each value in the range, we perform DFS on the grid, which takes
    // O(n^2) time.

    // The space complexity of this solution is O(n^2), where n is the size of the grid.
    // This is because we use a boolean array to mark visited squares and a call stack to perform DFS.


}
























