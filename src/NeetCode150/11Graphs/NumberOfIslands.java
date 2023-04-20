//// 2023/04/20 // 23:45 //

//// 200. Number of Islands // Medium

// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
// return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or
// vertically. You may assume all four edges of the grid are all surrounded by water.

//        Example 1:
//
//        Input: grid = [
//        ["1","1","1","1","0"],
//        ["1","1","0","1","0"],
//        ["1","1","0","0","0"],
//        ["0","0","0","0","0"]
//        ]
//        Output: 1
//        Example 2:
//
//        Input: grid = [
//        ["1","1","0","0","0"],
//        ["1","1","0","0","0"],
//        ["0","0","1","0","0"],
//        ["0","0","0","1","1"]
//        ]
//        Output: 3
//
//
//        Constraints:
//
//        m == grid.length
//        n == grid[i].length
//        1 <= m, n <= 300
//        grid[i][j] is '0' or '1'.

class Solution {

    public int numIslands(char[][] grid) {
        // Check if grid is empty or null
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // Get the dimensions of the grid
        int m = grid.length;
        int n = grid[0].length;
        // Initialize the number of islands to zero
        int islands = 0;
        // Loop through each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the cell is '1', it means it is part of an island
                if (grid[i][j] == '1') {
                    // Increment the number of islands
                    islands++;
                    // Mark the cell as visited by changing it to '0'
                    grid [i][j] = '0';
                    // Call the DFS helper function to explore the neighboring cells
                    dfs(grid, i, j);
                }
            }
        }
        // Return the final number of islands
        return islands;
    }

    // A helper function that performs DFS of a given cell and its neighbors
    private void dfs(char[][] grid, int i, int j) {
        // Get the dimensions of the grid
        int m = grid.length;
        int n = grid[0].length;
        // Define an array of directions to move in the grid
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // Loop through each direction
        for (int[] dir : dirs) {
            // Calculate the new row and column indices
            int x = i + dir[0];
            int y = j + dir[1];
            // Check if the new indices are valid and the cell is '1'
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1') {
                // Mark the cell as visited by changing it to '0'
                grid[x][y] = '0';
                // Call the DFS helper function recursively on the new cell
                dfs(grid, x, y);
            }
        }
    }

}



