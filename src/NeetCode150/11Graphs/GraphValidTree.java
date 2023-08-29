//// 2023/08/29 // 11:22 //

//// 178. Graph Valid Tree // Medium //

// Description

// Given n nodes labeled from 0 to n - 1 and a list of unidirected edges (each edge is
// a pair of nodes), write a function to check whether these edges make up a valid tree.

// (i) You can assume that no duplicate edges will appear in edges. Since all edges are unidirected,
// [0, 1] is the same as [1, 0] and thus will not appear together in edges.

// Example

// Example 1:
// Input: n = 5 edges = [[0,1], [0, 2], [0, 3], [1, 4][
// Output: true.

// Example 2:
// Input: n = 5 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1,4]]
// Output: false.


class GraphValidTree {

    // A graph is a valid tree if it satisfies the following conditions:
    // * It has n - 1 edges, where n is the number of nodes.
    // * If it is connected, meaning that there is a path between any two nodes.
    // * It has no cycles, meaning that there is no way to start at a node
    // and return to it by following the edges.

    // To check whether a given graph is a valid tree, we can use either of the following methods:
    // * Depth-first search (DFS): We start from any node and mark it as visited. Then we recursively visit its
    // unvisited neighbors and mark them as visited. If we encounter a visited node, it means there is a
    // cycle in the graph. If we finish visiting all nodes without finding a cycle, we check if the number of
    // edges is equal to n - 1. If yes, the graph is a valid tree.
    // * Union-find: We use an array to store the parent of each node. Initially, each node is its own parent.
    // For each edge, we find the root of both nodes and compare them. If they are the same, it means
    // there is a cycle in the graph. If they are different, we union them by making one of them the parent of
    // the other. If we finish processing all edges without finding a cycle, we check if there is only one root
    // in the array. If yes, the graph is a valid tree.

    // Here is an example of an optimal solution in Java using union-find:
    public boolean validTree(int n, int[][] edges) {
        // Check if the number of edges is correct
        if (edges.length != n - 1) {
            return false;
        }

        // Initialize the parent array
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Loop through the edges
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            // Find the root of x and y
            int xRoot = find(parent, x);
            int yRoot = find(parent, y);
            // If they are the same, there is a cycle
            if (xRoot == yRoot) {
                return false;
            }
            // Union them by making xRoot the parent of yRoot
            parent[yRoot] = xRoot;
        }

        // Return true if no cycle is found
        return true;
    }

    // Helper function to find the root of a node
    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    // The time complexity of this solution is O(n + e), where n is the number of nodes
    // and e is the number of edges.

    // The space complexity is O(n), where n is the size of the parent array.

    // Let's test the algorithm:
    public static void main(String[] args) {
        // Create an instance of solution
        GraphValidTree solution = new GraphValidTree();

        // Test cases
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};

        // Expected outputs
        boolean expected1 = true;
        boolean expected2 = false;

        // Test solution
        System.out.println("Testing solution...");
        boolean actual1 = solution.validTree(5, edges1);
        boolean actual2 = solution.validTree(5, edges2);
        System.out.println("Test case 1: " + (actual1 == expected1 ? "Passed" : "Failed"));
        System.out.println("Test case 2: " + (actual2 == expected2 ? "Passes" : "Failed"));

    }

}
