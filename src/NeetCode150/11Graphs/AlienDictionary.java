//// 2023/08/29 // 9:52 //

// 269. Alien Dictionary // Hard

// There is a new alien language that uses the English alphabet.
// However, the order among the letters in unknown to you.

// You are given a list of strings words from the alien language's dictionary,
// where strings in words are sorted lexicographically
// by the rules of this new language.

// Return a string of the unique letters in the new alien language
// sorted in lexicographically increasing order by the new language's rules.
// If there is no solution, return "". If there are multiple solutions, return any of them.

// A string s is lexicographically smaller than a string t
// if at the first letter where they differ,
// the letter s comes before the letter t in the alien language.
// If the first min(s.length, t.length) letters are the same,
// then s is smaller if and only if s.length < t.length

// Example 1:
// Input: words = ["wrt","wrf","er","ett,"rftt]
// Output: "wertf"


import java.util.*;

class AlienDictionary {

    // Explanation:
    // * The problem is to find the order of the letters in the alien language based on the given words.
    // * To do this, we can use a topological sort algorithm, which is a way of ordering a directed acyclic graph
    // (DAG) such that for every edge from node u to node v, u comes before v in the ordering.
    // * A DAG is a graph that has no cycles, meaning that there is no path form a node to itself.
    // * We can construct a DAG from the given words by comparing adjacent words and finding the first
    // different letter in each pair. This letter represents an edge from the smaller letter to the larger letter in the
    // alien language.
    // * For example, if we have words = ["wrt","wrf","er","ett","rftt"], we can compare "wrt" and "wrf" and find that "t"
    // comes before "f" in the alien language. Similarly, we can compare "wrf" and "er" and find that "w" comes
    // before "e", and so on.
    // * The DAG we get from this example is:
    // w -> e || v v r -> t -> f
    // * Once we have the DAG, we can apply a topological sort algorithm to get the order of the letters.
    // There are two common ways to do this: Kahn's algorithm and DFS-based algorithm.
    // * Kahn's algorithm works by finding nodes with no incoming edges (sources) and adding them to the
    // order. Then, it removes these nodes and their outgoing edges from the graph and repeats until there are
    // no more nodes left.
    // * DFS-based algorithm works by doing a depth-first search (DFS) on the graph and adding nodes to the
    // order in reverse post-order, meaning that a node is added after all its descendants are visited.
    // * Both algorithms can handle multiple sources and multiple possible orders. If there is no valid order,
    // meaning that the graph has a cycle, both algorithms will detect it and return an empty string.

    // Here is one possible solution in Java using Kahn's algorithm:
    public String alienOrder(String[] words) {
        // Initialize a map to store the adjacency list of the graph
        Map<Character, Set<Character>> graph = new HashMap<>();
        // Initialize a map to store the in-degree of each node
        Map<Character, Integer> indegree = new HashMap<>();
        // Initialize a string builder to store the order of letters
        StringBuilder order = new StringBuilder();

        // Populate the graph and indegree maps with all letters in words
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // Compare adjacent words and find edges
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Check if word2 is a prefix of word1, which is invalid
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // Find the first different letter in each pair
            for (int j = 0; j < Math.min(word1.length(), word2. length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    // Add an edge from c1 to c2 if not already present
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        // Increment the in-degree of c2
                        indegree.put(c2, indegree.get(c2) + 1);
                    }
                    // Break after finding the first different letter
                    break;
                }
            }
        }

        // Initialize a queue to store the sources
        Queue<Character> queue = new LinkedList<>();
        // Add all nodes with zero in-degree to the queue
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        // Perform Kahn's algorithm
        while (!queue.isEmpty()) {
            // Poll a source from the queue and append it to the order
            char c = queue.poll();
            order.append(c);
            // Remove c and its edges from the graph
            for (char neighbor : graph.get(c)) {
                // Decrement the in-degree of the neighbor
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                // If the neighbor becomes a source, add it to the queue
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Check if the order contains all the letters
        if (order.length() == indegree.size()) {
            // Return the order as a string
            return order.toString();
        } else {
            // The graph has a cycle, return an empty string
            return "";
        }
    }

    // Big O:
    // * The time complexity of this solution is O(V + E), where V is the number of unique letters and E is the
    // number of edges in the graph. This is because we need to iterate over all the words and letters to
    // construct the graph and indegree maps, which takes O(V + E) time. Then, we need to perform
    // Kahn's algorithm, which also takes O(V + E) time, since we visit each node and edge once.
    // * The space complexity of this solution is also O(V + E), since we need to store the graph and indegree
    // maps, which take O(V + E) space. We also need to store the order and the queue, which take O(V) space.
    // Therefore, the total space complexity is O(V + E + V) = O(V + E).

    // Let's test the solution:
    public static void main(String[] args) {
        // Create an instance of the Solution class
        AlienDictionary solution = new AlienDictionary();
        // Define some test cases
        String[] words1 = {"wrt","wrf","er","ett","rftt"};
        String[] words2 = {"abc","ab"};
        String[] words3 = {"z","z"};
        String[] words4 = {"za","zb","ca","cb"};
        // Call the alienOrder method on each test case and print the result
        System.out.println(solution.alienOrder(words1)); // Expected output: "wertf"
        System.out.println(solution.alienOrder(words2)); // Expected output: ""
        System.out.println(solution.alienOrder(words3)); // Expected output: "z"
        System.out.println(solution.alienOrder(words4)); // Expected output: "zab" or "zac"
    }

}



