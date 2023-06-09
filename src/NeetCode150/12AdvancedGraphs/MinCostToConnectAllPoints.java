//// 2023/06/08 // 21:40 //

//// 1584. Min Cost to Connect All Points // Medium //

// You are given an array points representing integer coordinates of some points
// on a 2D-plane, where points[i] = [xi, yi].

// The cost of connecting two points [xi, yi] and [jx, yj] is the manhattan
// distance between them: |xi - yi| + |yi - yj|, where |val| denotes the
// absolute value of val.

// Return the minimum cost to make all points connected. All points are connected if
// there is exactly one simple path between any two points.

// Example 1:
// Picture
// Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
// Output: 20
// Explanation:
// Picture
// We can connect the points as shown above to get the minimum cost of 20.
// Notice that there is a unique path between every pait of points.

// Example 2:
// Input: points = [[3,12],[-2,5],[-4,1]]
// Output: 18

// Constraints:
// * 1 <= points.length <= 1000
// * -10^6 <= xi, yi < = 10^6
// * All pairs (xi, yi) are distinct.

import java.util.PriorityQueue;

class MinCostToConnectAllPoints {

    // This problem can be solved by finding the minimum spanning tree of a complete graph
    // where the vertices are the points and the edges are the manhattan distances between
    // them. There are two common algorithms for finding the minimum spanning tree:
    // Prim's algorithm and Kruskal's algorithm.
    // Both have a time complexity of O(n^2) where n is the number of points.
    // Here is a possible solution using Prim's algorithm in Java:

    public int minCostConnectPoints(int[][] points) {
        // initialize a boolean array to mark visited points
        boolean[] visited = new boolean[points.length];
        // initialize a priority queue to store the edges with minimum cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        // add the first point to the queue with zero cost
        pq.offer(new int[]{0, 0, 0});
        // initialize a variable to store the total cost
        int cost = 0;
        // loop until the queue is empty or all points are visited
        while (!pq.isEmpty() && visited.length > 0) {
            // poll the edge with minimum cost from the queue
            int[] edge = pq.poll();
            // get the source and destination points of the edge
            int src = edge[0];
            int dst = edge[1];
            // if the destination point is already visited, skip this edge
            if (visited[dst]) continue;
            // mark the destination point as visited
            visited[dst] = true;
            // add the cost of the edge to the total cost
            cost += edge[2];
            // loop through all other points
            for (int i = 0; i < points.length; i++) {
                // if the point is not visited,
                // add it to the queue with the cost of connecting it to the destination point
                if (!visited[i]) {
                    pq.offer(new int[]{dst, i, getDistance(points[dst], points[i])});
                }
            }
        }
        // return the total cost
        return cost;
    }

    // helper method to calculate the manhattan distance between two points
    private int getDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

}
