//// 2023/08/29 // 12:39 //

//// Walls and Gates - Multi-Source BFS - Leetcode 286

// You are given an m x n grid rooms initialized with these three possible values.
// * -1 A wall or an obstacle
// * 0 A gate
// * INF Infinity means an empty root. We use the value 2^31 - 1 = 2147483647 to represent INF
// as you may assume that the distance to a gate is less than 2147483647.

// Fill each empty root with the distance to its nearest gate.
// If it is impossible to reach a gate, it should be fileld with INF.

// Example 1:
// Images
// Input: rooms = [[2147483647, -1, 0, 2147483647], [2147483647,2147483647,2147483647,-1],[0,-1,2147483647,2147483647]]
// Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]


import java.util.LinkedList;
import java.util.Queue;

class WallsAndGates {

    // The idea is to fill each empty room in a grid with the distance to its nearest gate,
    // while avoiding walls and obstacles. There are two common approaches to solve this problem:
    // depth-first search (DFS) and breath-first search (BFS).

    // DFS Approach
    // The DFS approach is to start from each gate and explore its adjacent rooms in four directions. If the
    // adjacent rooms is empty, we update its distance with the current distance plus one, and then recursively
    // explore its neighbors. We use a boolean matrix to mark the visited rooms, so that we do not revisit
    // them. We also check if the current distance is smaller than the existing distance in the room, so that we
    // do not overwrite a shorter distance

    static private class DFSSolution {
        // Define four directions as arrays of offsets
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        public void wallsAndGates(int[][] rooms) {
            // Validate the input grid
            if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

            // Get the dimensions of the grid
            int m = rooms.length;
            int n = rooms[0].length;

            // Initialize a visited matrix
            boolean[][] visited = new boolean[m][n];

            // Loop through each cell in the grid
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // If the cell is a gate, start DFS from it
                    if (rooms[i][j] == 0) {
                        fill(rooms, i, j, 0, visited);
                        // Reset the visited matrix for the next gate
                        visited = new boolean[m][n];
                    }
                }
            }
        }

        // Helper method to fill the empty rooms with distances
        public void fill(int[][] rooms, int i, int j, int start, boolean[][] visited) {
            // Get the dimensions of the grid
            int m = rooms.length;
            int n = rooms[0].length;

            // Check if the current position is valid and not visited
            if (i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] <= 0 || visited[i][j]) return;

            // Update the distance of the current room with the minimum value
            rooms[i][j] = Math.min(rooms[i][j], start + 1);

            // Mark the current room as visited
            visited[i][j] = true;

            // Explore the four adjacent rooms recursively
            fill(rooms, i - 1, j, start + 1, visited);
            fill(rooms, i + 1, j, start + 1, visited);
            fill(rooms, i, j - 1, start + 1, visited);
            fill(rooms, i, j + 1, start + 1, visited);

            // Unmark the current room as visited
            visited[i][j] = false;
        }

        // The time complexity of this approach is O(mn) where m and n are the number of rows and columns in
        // the grid. This is because we may need to visit every cell in the worst case when all cells are gates.

        // The space complexity is also O(mn) because of the recursive call stack and the visited matrix.


        // BFS Approach

        // The BFS approach is similar to the DFS approach, but instead of using recursion, we use a queue to
        // store the positions of the gates. We then dequeue each position and explore its adjacent rooms in four
        // directions. If the adjacent room is empty, we update its distance with the current distance plus one, and
        // then enqueue it for further exploration. We do not need a visited matrix in this approach, because we
        // only enqueue empty rooms and update their distances once.

        // The BFS approach can be implemented as follows:

        static private class BFSSolution {
            // Define four directions as arrays of offsets
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};

            public void wallsAndGates(int[][] rooms) {
                // Validate the input grid
                if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

                // Get the dimensions of the grid
                int m = rooms.length;
                int n = rooms[0].length;

                // Initialize a queue to store the positions of the gates
                Queue<int[]> queue = new LinkedList<>();

                // Loop through each cell in the grid
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        // If the cell is a gate, enqueue it
                        if (rooms[i][j] == 0) {
                            queue.offer(new int[]{i, j});
                        }
                    }
                }

                // While the queue is not empty, dequeue each position and explore its neighbors
                while (!queue.isEmpty()) {
                    // Dequeue the current position
                    int[] curr = queue.poll();
                    int x = curr[0];
                    int y = curr[1];

                    // Loop through the four directions
                    for (int i = 0; i < 4; i++) {
                        // Get the adjacent position
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        // Check if the adjacent position is valid and empty
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && rooms[nx][ny] == Integer.MAX_VALUE) {
                            // Update the distance of the adjacent room with the current distance plus one
                            rooms[nx][ny] = rooms[x][y] + 1;
                            // Enqueue the adjacent position for further exploration
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        // The time complexity of this approach is also O(mn) where m and n are the number of rows and columns
        // in the grid. This is because we may need to visit every cell in the worst case when all cells are gates.
        // The space complexity is O(mn) because of the queue size.


        // Test Case
        // To test the algorithm, we can write a main method that creates a sample grid and prints the output
        // after calling the wallsAndGates method. For example:

        static private class Test {
            public static void main(String[] args) {
                // Create a sample grid
                int[][] rooms = {
                        {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                        {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
                };

                // Print the input grid
                System.out.println("Input:");
                printGrid(rooms);

                // Create a DFS solution object
                DFSSolution dfs = new DFSSolution();

                // Call the wallsAndGates method on the grid using DFS
                dfs.wallsAndGates(rooms);

                // Print the output grid using DFS
                System.out.println("Output using DFS:");
                printGrid(rooms);

                // Reset the grid to its original state
                rooms = new int[][]{
                        {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                        {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                        {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
                };

                // Create a BFS solution object
                BFSSolution bfs = new BFSSolution();

                // Call the wallsAndGates method on the grid using BFS
                bfs.wallsAndGates(rooms);

                // Print the output grid using BFS
                System.out.println("Output using BFS:");
                printGrid(rooms);
            }

            // Helper method to print a grid
            public static void printGrid(int[][] grid) {
                for (int[] row : grid) {
                    for (int val : row) {
                        System.out.print(val + " ");
                    }
                    System.out.println();
                }
            }
        }

    }

    // For the Walls and Gates problem, the BFS (breath-first search) algorithm
    // is generally more optimal than DFS (depth-first search). This is because
    // BFS guarantees that the distances to each room are calculated in the
    // most optimal way, finding the shortest path from each fate to each empty room.

}
