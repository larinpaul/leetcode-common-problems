//// 2023/06/03 // 17:56 //

//// 973. K Closest Points to Origin // Medium //

// Given an array of points where points[i] = [xi, yi] represents a point on the
// X-Y plane and an integer k, return the k closest points to the origin (0, 0).

// The distance between two points on the X-Y plane is the Euclidian distance
// (i.e., sqrt(x1 - x2)^2 + (y1 - y2)^2 ).

// You may return the answer in any order.
// The answer is guaranteed to be unique (except for the order that it is in).

// Example 1:
// Picture
// Input: points = [[1,3],[-2,2]], k = 1
// Output: [[-2,2]]

// Explanation:
// The distance between (1, 3) and the origin is sqrt(10).
// The distance between (-2, 2) and the origin is sqrt(8).
// Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
// We only want the closet k = 1 points from the origin,
// so the answer is just [[-2, 2]].

// Example 2:
// Input: points = [[3,3,],[5,-1],[-2,4]], k = 2
// Output: [[3,3],[-2,4]]
// Explanation: The answer [[-2,4],[3,3]] would also be accepted.

// Constraints:
// * 1 <= k <= points.length <= 10^4
// * -10^4 < xi, yi < 10^4

import java.util.PriorityQueue;

class KClosestPointsToTheOrigin {

    // Solution:
    // The solution is to use a priority queue to keep track of the k closest points to the origin.
    // The priority queue will be sorted by the distance from the origin,
    // with the closest points being at the front of the queue.
    // We can then iterate through the points array and add each point ot the priority queue.
    // Once we have added all of the points to the priority queue,
    // we can simply remove the first k points from the queue
    // and return them as the answer.

    // Explanation:
    // The distance between two points on the X-Y plane can be calculated using the
    // Euclidian distance formula:
    // distance = sqrt((x1 - x2)^2 + (y1 - y2)^2)
    // where x1 and y1 are the coordinates of the first point,
    // and x2 and y2 are the coordinates of the second point.

    // The priority queue is a data structure that can be used to keep track of a set of elements
    // that are sorted by some criteria. In this case, the criteria is the distance from the origin.
    // The priority queue will always keep the element with the smallest distance from the origin
    // at the front of the queue.

    // Code:
    public int[][] kClosest(int[][] points, int k) {
        // Create a priority queue to keep track of the k closest points to the origin.
        // The priority queue will be sorted by the distance from the origin,
        // with the closest points being at the front of the queue.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> dist(a) - dist(b));
        // Iterate through the points array and add each point to the priority queue.
        for (int[] point : points) {
            pq.add(point);
        }

        // Create an array to store the k closest points.
        int[][]res = new int[k][];
        // Iterate through the priority queue and remove the first k points.
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        // Return the array of k closest points.
        return res;
    }

    // Calculate the distance between two points on the X-Y plane.
    private int dist(int[] point) {
        // The distance between two points on the X-Y place can be calculated using the Euclidian distance formula
        // distance = sqrt((x1 - x2)² + (y1 - y2)²)
        return (point[0] * point[0]) + (point[1] * point[1]);
    }

    // Big O:
    // The time complexity of the solution is O(n log k), where n is the number of points in the array.
    // The main reason for this is that we need to sort the points by their distance from the origin,
    // which takes O(n log n) time.
    // We then need to remove the first k points from the priority queue, which takes O(k log k) time.
    // The space complexity of the solution is O(k), since we need to store the k closest points in memory.

}
