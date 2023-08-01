//// 2023/08/01 // 12:31 //

//// 787. Cheapest Flights Within K Stops // Medium //

// There are n cities connected by some number of flights. You are given an array of flights
// where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi
// to city toi with cost pricei.

// You are also given three integers src, dst, and k, return the cheapest price from src to dst
// with at most k stops. If there is no such route, return -1.

// Example 1:
// Image
// Input: n = 4, flights - [[0,1,100],[1,2,200],[2,0,100],[1,3,600],
// [2,3,200]], src = 0. dst = 3, k = 1
// Output: 700
// Explanation:
// The graph is shown above.
// The optimal path with at most 1 stop from city 0 to 3 is marked in red and
// has cost 100 + 600 = 700.
// Note that the path through cities [0,1,2,3] is cheaper but is invalid
// because it uses 2 stops.

// Example 2:
// Image
// Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
// Output: 200
// Explanation:
// The graph is shown above.
// The optimal path with at most 1 stop from city 0 to 2 is marked in red
// and has cost 100 + 100 = 200.

// Example 3:
// Image
// Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
// Output: 500
// Explanation:
// The graph is shown above.
// The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.

// Constraints:
// * 1 <= n <= 100
// * 0 <= flights.length <= (n * (n - 1) / 2)
// * flights[i].length == 3
// * 0 <= fromi, toi < n
// * fromi != toi
// * 1 <= pricei <= 10^4
// * There will not be any multiple flights between two cities.
// * 0 <= src, dst, k < n
// * src != dst

import java.util.*;

class CheapestFlightsWithinKStops {

    // This is a graph problem where we need to find the shortest path form the source city to
    // the destination city with at most k stops. you can use Dijkstra's algorithm or Bellman-Ford algorithm
    // to solve this problem, but they have different time and space complexities.

    // Dijkstra's algorithm uses a priority queue to store the current cost and city, and updates
    // the cost at each neighboring city if it is smaller than the previous one. It has a time
    // complexity of O(E + V log V), where E is the number of edges and V is the number of
    // vertices, and a space complexity of O(V).

    // Bellman-Ford algorithm uses a dynamic programming approach, where is iterates over
    // all the edges k times and updates the cost of each destination city if it is smaller than
    // the previous one. It has a time complexity of O(kE), where E is the number of edges and
    // k is the maximum number of stops, and a space complexity of O(V).

    // Here is a possible code for Dijkstra's algorithm in Java:

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // create a graph to represent the flights and their prices
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new int[]{to, price});
        }

        // create a priority queue to store the current cost and city
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, k + 1}); // add one more stop for convenience

        // loop until the queue is empty or the destination is reached
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int city = curr[1];
            int stops = curr[2];

            // if the destination is reached, return the cost
            if (city == dst) {
                return cost;
            }

            // if there are still stops left, explore the neighboring cities
            if (stops > 0) {
                List<int[]> neighbors = graph.getOrDefault(city, new ArrayList<>());
                for (int[] neighbor : neighbors) {
                    int nextCity = neighbor[0];
                    int nextPrice = neighbor[1];
                    // add the neighboring city and the updaes cost to the queue
                    pq.offer(new int[]{cost + nextPrice, nextCity, stops = 1});
                }
            }
        }

        // if no route is found, return -1
        return -1;

    }

    // The big O notation for this code is O(E + V log V) for time and O(V) for space.

}
