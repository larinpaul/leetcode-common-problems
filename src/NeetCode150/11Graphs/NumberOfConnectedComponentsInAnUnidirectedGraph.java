//// 2023/08/29 // 12:08 //

//// 323. Number of Connected Components in an Unidirected Graph // Medium //

// You have a graph of n nodes. You are given an integer n and an array edges where
// edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
// Return the number of connected components in the graph.

// Example 1:
// 0 - 1   3
//     |   |
//     2   4
// Input: n = 5, edges = [[0,1],[1,2],[3,4]]
// Output: 2

// Sorry that there is only one example... I hope you will manage to do it :)

// Also, after the big o, please write a psvm test to test how the algorithm work


class NumberOfConnectedComponentsInAnUnidirectedGraph {

    // A connected component in an unidirected graph is a set of nodes that are unreachable from each other by
    // following the edges. The number of connected components in an unidirected graph is the number of
    // such sets.

    // To find the number of connected components in an unidirected graph, we can use either of the following
    // methods:
    // * Depth-first search (DFS): We start from any node and mark it as visited. Then we recursively visit its
    // unvisited neighbors and mark them as visited. This way, we explore all the nodes in one connected
    // component. Then we repeat this process for every unvisited node until we visit all the nodes. The
    // number of times we start a new DFS is the number of connected components.

    // * Union-find: We use an array to store the parent of each node. Initially, each node is its own parent.
    // For each edge, we find the root of both nodes and compare them. If they are different, we union
    // them by making one of them the parent of the other. This way, we merge the nodes that belong to
    // the same connected component. At the end, we count how many distinct roots are there in the array.
    // The number of distinct roots is the number of connected components.

    // Here is an example of an optimal solution in Java using union-find:
    public int countComponents(int n, int[][] edges) {
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
            // If they are different, union them
            if (xRoot != yRoot) {
                parent[yRoot] = xRoot;
            }
        }

        // Count the number of distinct roots
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                count++;
            }
        }

        // Return the number of connected components
        return count;
    }

    // Helper function to find the root of a node
    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    // The time complexity of this solution is O(n + e * alpha(n)),
    // where n is the number of nodes, e is the number of edges, and alpha(n) is the inverse Ackermann function,
    // which is very close to a constant for any practical value of n.

    // The space complexity is O(n), where n is the size of the parent array


    // Here is a test with psvm that you can use to test your solution:
    public static void main(String[] args) {
        // Create an instance of solution
        NumberOfConnectedComponentsInAnUnidirectedGraph solution = new NumberOfConnectedComponentsInAnUnidirectedGraph();

        // Test case 1
        int n1 = 5;
        int[][] edges1 = {{0, 1}, {1, 2}, {3, 4}};
        int expected1 = 2;
        int actual1 = solution.countComponents(n1, edges1);
        System.out.println("Test case 1: " + (actual1 == expected1 ? "Passed" : "Failed"));

        // Test case 2
        int n2 = 5;
        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int expected2 = 1;
        int actual2 = solution.countComponents(n2, edges2);
        System.out.println("Test case 2: " + (actual2 == expected2 ? "Passed" : "Failed"));

    }

}
