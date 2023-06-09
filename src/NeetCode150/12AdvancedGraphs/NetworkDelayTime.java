//// 2023/06/09 // 14:02 //

//// 743. Network Delay Time // Medium //

// You are given a network of n nodes, labeled from 1 to n.
// You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi),
// where ui is the source node, vi is the target node, and wi is the time it takes
// for a signal to travel from source to target.

// We will send a signal from a given node k. Return the minimum time it takes for
// all the n nodes to receive the signal. If it is impossible for all the n nodes
// to receive the signal, return -1.

// Example 1:
// Picture
// Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
// Output: 2

// Example 2:
// Input: times = [[1,2,1]], n = 2, k = 1
// Output: 1

// Example 3:
// Input: times = [[1,2,1]], n = 2, k = 2
// Output: -1

// Constraints:
// * 1 <= k <= n <= 100
// * 1 <= times.length <= 6000
// * times[i].length == 3
// * 1 <= ui, vi <= n
// * ui != vi
// * 0 <= wi <= 100
// * All the pairs (ui, vi) are unique. (i.e., no multiple edges.)

import java.util.*;

class NetworkDelayTime {

    // This is a problem of finding the shortest paths from a single source node to all other nodes
    // in a weighted directed graph. A possible algorithm to solve this problem is Dijkstra's algorithm,
    // which maintains a priority queue of node, ordered by their distance from the
    // source node. The algorithm repeatedly extracts node with the smallest distance from
    // the queue, updates the distance of its neighbors, and adds them to the queue if they are
    // not visited. The algorithm terminates when all nodes are visited or the queue is empty.

    public int networkDeplayTime(int[][] times, int n, int k) {
        // Build a graph as an adjacency list
        List<int[]>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            graph[u].add(new int[]{v, w});
        }

        // Initialize an array to store the distance of each node from the source
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Initialize a priority queue of nodes, ordered by their distance from the source
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});

        // Initialize a set to store the visited nodes
        Set<Integer> visited = new HashSet<>();

        // Loop until the queue is empty or all nodes are visited
        while (!pq.isEmpty() && visited.size() < n) {
            // Extract the node with the smallest distance from the queue
            int[] node = pq.poll();
            int u = node[0], d = node[1];

            // Skip is the node is already visited
            if (visited.contains(u)) continue;

            // Mark the node as visited
            visited.add(u);

            // Update the distance of its neighbors and add them to the queue if not visited
            for (int[] edge : graph[u]) {
                int v = edge[0], w = edge[1];
                if (!visited.contains(v) && dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        // Find the maximum distance among all nodes
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }

        // Return -1 if any node is unreachable, otherwise return the maximum distance
        return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
    }

    // The time complexity of this algorithm is O(e log v),
    // where e is the number of edges and v is the number of nodes.
    // This is because each edge is processed at most once, and each node is extracted from the queue at most once.
    // The space complexity is O(v + e), which is the size of the graph and the queue.

}
