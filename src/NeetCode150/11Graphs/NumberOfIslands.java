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

    // We first start by checking if the grid is empty or null, and return zero if that is the case.
    // We then get the dimensions of the grid, which are m rows and n columns
    // We initialize a variable called islands to keep track of the number of islands we find in the grid.
    // We loop through each cell in the grid using a nested for loop.
    // For each cell, we check if it is '1' which means it is part of an island.
    // If so, we do the following steps:
    // * We increment the islands variable by one, since we have found a new island
    // * We mark the cell as visited by changing its value to '0', so that we don't count it again.
    // * We call a helper function called dfs that performs a depth-first search on the
    //   current cell and its neighbors. This function will mark all the cells that belong to
    //   the same island as visited and explore them recursively.
    // After looping through all the cells in the grid, we return the final value of islands as our answer.

    // The time complexity of this solution is O(mn), where m and n are the dimensions of the grid.
    // This is because we visit each cell at most once in our DFS algorithm. The space
    // complexity is O(mn) as well, since we may need to store
    // up to mn recursive calls in the worst case when all cells are '1'.

}
