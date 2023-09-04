//// 2023/09/04 // 10:33 //

//// 1851. Minimum Interval to Include Each Query // Hard //

// You are given a 2D integer array intervals, where intervals[i] = [lefti, righti] describes the ith
// interval starting at lefti and ending at righti (inclusive). The size of an interval is defined as the number
// of integers it contains, or more formally righti - lefti + 1.

// You are also given an integer array queries. The answer to the jth query is the size of the smallest
// interval i such that lefti <= queries[j] <= righti. If no such interval exists, the answer is -1.

// Return an array containing the answers to the queries.

// Example 1:
// Input: intervals = [[1,4],[2,4],[3,6],[4,4]], queries = [2,3,4,5]
// Output: [3,3,1,4]
// Explanation: The queries are processed as follows:
// - Query - 2: The interval [2,4] is the smallest interval containing 2.
// The ansewr is 4 - 2 + 1 = 3.
// - Query = 3: The interval [2,4] is the smallest interval containing 3.
// The answer is 4 - 2 + 1 = 3.
// - Query = 4: The interval [4,4] is the smallest interval containing 4.
// The answer is 4 - 4 + 1 = 1.
// - Query = 5: The interval [3,6] is the smallest interval containing 5.
// The answer is 6 - 3 + 1 = 4.

// Example 2:
// Input: intervals = [[2,3],[2,5],[1,8],[20,25]], queries = [2,19,5,22]
// Output: [2,-1,4,6]
// Explanation: The queries are processed as follows:
// - Query = 2: The interval [2,3] is the smallest interval containing 2.
// The answer is 3 - 2 + 1 = 2.
// - Query = 19: None of the intervals contain 19. The answer is -1.
// - Query = 5: The interval [2,5] is the smallest interval containing 5.
// The answer is 5 - 2 + 1 = 4.
// Query = 22: The interval [20,25] is the smallest interval containg 22.
// The answer is 25 - 20 + 1 = 6.

// Constraints:
// * 1 <= intervals.length <= 10^5
// * 1 <= queries.length <= 10^5
// * intervals[i].length == 2
// * 1 <= lefti <= righti <= 10^7
// * 1 <= queries[j] <= 10^7


import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class MinimumIntervalToIncludeEachQuery {

    // Explanation:
    // The problem asks for the smallest interval that includes each query value.
    // We need to find the interval [lefti, righti] from the given intervals array
    // such that lefto <= queries[j] <= righti. The size of an interval is defined as
    // righti - lefti + 1.

    // To solve this problem, we can follow the following approach:
    // 1. Sort the intervals array based on the start of each interval in
    // ascending order.
    // 2. Sort the queries array in ascending order.
    // 3. Initialize a priority queue (pq) to store the intervals based on their
    // sizes. We will prioritize intervals with smaller sizes.
    // 4. Iterate through the sorted queries array. For each query value q:
    // * Add all intervals whose start is less than or equal to q to the
    // priority queue.
    // * Remove intervals from the priority queue whose end is less than q.
    // * Compute the size of the smallest interval that includes q and
    // store it in a hashmap with q as the key.
    // 5. Finally, iterate through the original queries array and retrieve the sizes
    // of the smallest intervals from the hashmap.

    // Optimal Solution (of speed, not necessarily of memory, I guess):
    public int[] minInterval(int[][] intervals, int[] queries) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Sort the intervals based on the start in ascending order
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] sortedQueries = queries.clone();
        Arrays.sort(sortedQueries);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (a[1] - a[0]) - (b[1] - b[0])
        );

        int i = 0;

        for (int q : sortedQueries) {
            // Add intervals whose start is less than or equal to q to the priority queue
            while (i < intervals.length && intervals[i][0] <= q) {
                pq.offer(intervals[i++]);
            }

            // Remove intervals from the priority queue whose end is less than q
            while (!pq.isEmpty() && pq.peek()[1] < q) {
                pq.poll();
            }

            // Compute the size of the smallest interval that includes q and store it in the hashmap
            map.put(q, pq.isEmpty() ? -1 : pq.peek()[1] - pq.peek()[0] + 1);
        }

        // Retrieve the sizes of the smallest intervals from the hashmap
        for (i = 0; i < queries.length; i++) {
            queries[i] = map.get(queries[i]);
        }

        return queries;
    }

    // Time Complexity:
    // The time complexity of the solution is O((n + m) log n), where n is the
    // length of the intervals array and m is the length of the queries array. This
    // is because we sort the intervals array, which takes O(n log n) time. Then,
    // we iterate through the queries array, which takes O(m) time. In each
    // iteration, we perform operations on the priority queue, which takes O(log n) time.
    // Therefore, the overall time complexity is O((n + m) log n).

    // Space Complexity:
    // The space complexity is O(n) because we use a priority queue and a
    // hashmap to store the intervals and their sizes.

}
