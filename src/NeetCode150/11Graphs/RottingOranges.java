//// 2023/07/27 // 12:14 //

//// 994. Rotting Oranges // Medium //

// You are given an m x n grid where each cell can have one of three values:
// * 0 representing an empty cell,
// * 1 representing a fresh orange, or
// * 2 representing a rotten orange.

// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange
// becomes rotten.

// Return the minimum number of minutes that must elapse until no clee has a fresh
// orange. If this is impossible, return -1.

// Example 1:
// Image
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4

// Example 2:
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2,
// column 0) is never rotten, because rotting only happens 4-directionally.

// Example 3:
// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0,
// the answer is just 0.

// Constraints:
// * m == grid.length
// * n == grid[i].length
// * 1 <= m, n <= 10
// * grid[i][j] is 0, 1, or 2.

import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {

    // This problem can be solved using a breath-first search (BFS) algorithm.
    // We start the algorithm by locating all the rotten oranges (value 2)
    // and adding them into a queue. Then, for each minute, we deque
    // the elements (rotten oranges) and enqueue their adjacent
    // fresh oranges, making them rotten.

    // Here is how the algorithm works in detail:
    // 1. Traverse the whole grid, add the position of all rotten oranges
    // to the queue, and count the number of fresh oranges.
    // 2. Start the BFS process by dequeuing each rotten orange at a
    // time and rotting their adjacent fresh oranges. If a fresh orange
    // gets rotten, decrement the fresh orange count and enqueue
    // the new rotten orange's position.
    // 3. After each BFS level (minute), increment the time by 1.
    // 4. Repeat this process until the queue is empty.
    // 5. If there are still fresh oranges left in the grid (freshCount > 0),
    // it means that these oranges can't be rotten, so return -1.
    // 6. If there are no fresh oranges left, return the time.

    // Code:
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        int minutes = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // Step 2, 3, 4
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int[] direction : directions) {
                    int x = point[0] + direction[0];
                    int y = point[1] + direction[1];

                    if (
                            x < 0
                                    || y < 0
                                    || x >= grid.length
                                    || y >= grid[0].length
                                    || grid[x][y] == 0
                                    || grid[x][y] == 2
                    ) {
                        continue;
                    }

                    queue.offer(new int[]{x, y});
                    grid[x][y] = 2;
                    freshCount--;
                }
            }
            minutes++;
        }

        // Step 5, 6
        return freshCount > 0 ? -1 : minutes;

    }

    // Big O:

    // The time complexity of this solution is O(mn),
    // where m and n are the dimensions of the grid,
    // because in the worst-case scenario, we
    // need to traverse each cell in the grid.

    // The space complexity is also O(mn)
    // in case all the cells in the grid are rotten oranges and are added to the queue.

}
