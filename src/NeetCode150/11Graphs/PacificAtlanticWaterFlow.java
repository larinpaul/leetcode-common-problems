//// 2023/06/07 // 14:39 //

//// 417. Pacific Atlantic Water Flow // Medium //

// There is an m x n rectangular island that borders both the Pacific Ocean and
// Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and
// the Atlantic Ocean touches the island's right and bottom edges.

// The island is partitioned into a grid of square cells. You are given an m x n itneger
// matrix heights where heights[r][c] represents the height above sea level of
// the cell at coordinate (r, c).

// The island receives a lot of rain, and the rain water can flow to neighboring cells
// directly north, south, east, and west if the neighboring cell's height is less than or
// equal to the current cell's height. Water can flow from any cell adjacent to an
// ocean into the ocean.

// Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes
// that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

// Example 1:
// Picture
//Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//        Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
//        Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
//        [0,4]: [0,4] -> Pacific Ocean
//        [0,4] -> Atlantic Ocean
//        [1,3]: [1,3] -> [0,3] -> Pacific Ocean
//        [1,3] -> [1,4] -> Atlantic Ocean
//        [1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean
//        [1,4] -> Atlantic Ocean
//        [2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean
//        [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
//        [3,0]: [3,0] -> Pacific Ocean
//        [3,0] -> [4,0] -> Atlantic Ocean
//        [3,1]: [3,1] -> [3,0] -> Pacific Ocean
//        [3,1] -> [4,1] -> Atlantic Ocean
//        [4,0]: [4,0] -> Pacific Ocean
//        [4,0] -> Atlantic Ocean
//        Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.

// Example 2:
// Input: heights = [[1]]
// Output: [[0,0]]
// Explanation: The water can flow from the only cell to
// the Pacific and Atlantic oceans.

// Constraints:
// * m == heights.length
// * n == heights[r].length
// * l <= m, n <= 200
// * 0 <= heights[r][c] <= 10^5

import java.util.ArrayList;
import java.util.List;

class PacificAtlanticWaterFlow {

    // Explanation:
    // The idea is to find all the cells that can reach both the Pacific and Atlantic oceans by flowing water.
    // To do this, we can use a depth-first search (DFS) or a breath-first search (BFS) algorithm to traverse the
    // matrix form the edges that are adjacent to the oceans. We can maintain two boolean matrices, one for
    // the Pacific and one for the Atlantic, to mark the cells that can reach each ocean. Then, we can iterate
    // over the original matrix and find the cells that are marked as true in both matrices. These are the cells
    // that can flow water to both oceans.

    // Solution:
    // We can use a DFS algorithm to solve this problem. We can define a helper function that takes the
    // matrix, the row index, the column index, the ocean matrix, and a previous height as parameters. The
    // function will check if the current cell is within the bounds of the matrix, if it is not already visited in the
    // ocean matrix, and if its height is greater than or equal to the previous height. If these conditions are met,
    // it will mark the current cell as true in the ocean matrix and recursively call itself on its four adjacent
    // neighbors with the current height as the previous height.

    // We can also define another function that takes the matrix and an ocean matrix as parameters.
    // The function will iterate over the edges of the matrix that are adjacent to the ocean and call the DFS
    // function on each cell with a negative infinity as the previous height.

    // Finally, we can define a main function that takes the matrix as a parameter and return a list of
    // coordinates that can flow water to both oceans. The function will create two boolean matrices for the
    // Pacific and Atlantic oceans and initialize them with false values. Then, it will call the helper function on
    // both matrices to mark the cells that can reach each ocean. After that, it will iterate over the original
    // matrix and find the cells that are true in both matrices and add their coordinates to a list. The function
    // will return this lsit as the final answer.

    // Code:
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Initialize result list
        List<List<Integer>> result = new ArrayList<>();

        // Get matrix dimensions
        int m = heights.length;
        int n = heights[0].length;

        // Create boolean matrices for Pacific and Atlantic oceans
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Mark cells that can reach Pacific ocean
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific, heights[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific, heights[0][j]);
        }

        // Mark cells that can reach Atlantic ocean
        for (int i = 0; i < m; i++) {
            dfs(heights, i, n - 1, atlantic, heights[i][n - 1]);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, m - 1, j, atlantic, heights[m - 1][j]);
        }

        // Find cells that can reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    // Add coordinates to result list
                    List<Integer> coord = new ArrayList<>();
                    coord.add(i);
                    coord.add(j);
                    result.add(coord);
                }
            }
        }

        // Return result list
        return result;
    }

    // Helper function to perform DFS on a cell
    private void dfs(int[][] heights, int i, int j, boolean[][] ocean, int prev) {
        // Check if cell is within bounds
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length) {
            return;
        }

        // Check if cell is already visited or lower than previous cell
        if (ocean[i][j] || heights[i][j] < prev) {
            return;
        }

        // Mark cell as visited
        ocean[i][j] = true;

        // Call DFS on adjacent cells
        dfs(heights, i + 1, j, ocean, heights[i][j]); // Down
        dfs(heights, i - 1, j, ocean, heights[i][j]); // Up
        dfs(heights, i, j + 1, ocean, heights[i][j]); // Right
        dfs(heights, i, j - 1, ocean, heights[i][j]); // Left
    }

    // Big O:
    // The time complexity of this solution is O(m * n), where m and n are the dimensions of the matrix. This is
    // because we iterate over the matrix twice, once to mark the cells that can reach each ocean and once to
    // find the cells that can reach both oceans.
    // The space complexity of this solution is also O(m * n),
    // because we use two boolean matrices to store the visited cells for each ocean.

}
