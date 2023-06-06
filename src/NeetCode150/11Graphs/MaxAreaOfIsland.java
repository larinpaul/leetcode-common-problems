//// 2023/06/06 // 22:17 //

//// 695. Max Area of Island // Medium //

// You are given an m x n binary matrix grid. An island is a group of 1's
// (representing land) connected 4-directionally (horizontal or vertical.) You may
// assume all four edges of the grid are surrounded by water.

// The area of an island is the number of cells with a value 1 in the island.
// Return the maximum area of an island in grid. If there is no island, return 0.

// Example 1:
// Picture
// Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
// Output: 6
// Explanation: The answer is no 11, because the island must be connected 4-directionally.

// Example 2:
// Input: grid = [[0,0,0,0,0,0,0,0,0]]
// Output: 0

// Constraints:
// * m == grid.length
// * n == grid[i].length
// * 1 <= m, n <= 50
// * grid[i][j] is either 0 or 1.

class MaxAreaOfIsland {

    // The problem is to find the maximum area of an island in a binary matrix, where an island is a group of
    // 1's connected horizontally or vertically. The area of an island is the number of 1's in it.

    // One possible solution is to use depth-first search (DFS) to traverse the matrix and mark the visited 1's
    // as 0's. For each 1 we encounter, we start a DFS and count the number of 1's we can reach from it.
    // We keep track of the maximum count among all the DFS calls and return it as the answer.

    public int maxAreaOfIsland(int[][] grid) {
        // initialize the maximum area to zero
        int max_area = 0;
        // get the number of rows and columns in the grid
        int m = grid.length;
        int n = grid[0].length;
        // loop through each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if the cell is 1, start a DFS and update the maximum area
                if (grid[i][j] == 1) {
                    max_area = Math.max(max_area, dfs(grid, i, j));
                }
            }
        }
        // return the maximum area
        return max_area;
    }

    // helper function to perform DFS and count the area of an island
    private int dfs(int[][] grid, int i, int j) {
        // get the number of rows and columns in the grid
        int m = grid.length;
        int n = grid[0].length;
        // check if the indices are valid and the cell is 1
        if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
            // mark the cell as visited by setting it to 0
            grid[i][j] = 0;
            // return 1 plus the sum of DFS calls on adjacent cells
            return
                    1
                    + dfs(grid, i - 1, j)
                    + dfs(grid, i + 1, j)
                    + dfs(grid, i, j - 1)
                    + dfs(grid, i, j + 1);
        }
        // otherwise, return zero
        else {
            return 0;
        }
    }


    // The time complexity of this solution is O(m * n), where m and n are the number of rows and columns in
    // the grip. This is because we visit each cell at most once.

    // The space complexity of this solution is O(m * n) as well, because of the recursive call stack.
    // In the worst case, we might have a grid full of 1's and we need to perform a DFS on every cell.

}









