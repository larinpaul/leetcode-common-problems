//// 2023/08/15 // 11:59 //

//// 684. Redundant Connection // Medium //

// In this problem, a tree is an undirected graph that is connected and has no cycles.

// You are given a graph that started as a tree with n nodes labels from 1 to n, with one additional
// edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge
// that already existed. The graph is represented as an array edges of length n
// where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and b1 in the graph.

// Return an edge that can be removed so that the resulting graph is a tree of n nodes.
// If there are multiple answers, return the answer that occurs last in the input.

// Example 1:
// Image
// Input: edges = [[1,2],[1,3],[2,3]]
// Output: [2,3]

// Example 2:
// Image
// Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
// Output: [1,4]

// Constraints:
// * n == edges.length
// * 3 <= n <= 1000
// * edges[i].length == 2
// * 1 <= ai < bi <= edges.length
// 8 ai != bi
// * There are no repeated edges.
// * The given graph is connected.

class RedundantConnection {

    // This problem asks us to find an edge that can be removed from a graph that started
    // as a tree, but has one extra edge added. A tree is a graph that is connected and has
    // no cycles, meaning that there is exactly one path between any two nodes. If we add
    // an extra edge to a tree, we will create a cycle in the graph, and we want to remove
    // that edge.

    // One possible solution is to use a union-find data structure, also known as a disjoint-
    // set data structure. This data structure keeps track of the connected components of
    // a graph, and allows us to quickly check if two nodes are in the same component or
    // not. We can use this data structure to detect the cycle in the graph, and return the
    // last edge that forms the cycle.

    // The union-find data structure consists of two arrays: parent and rank. The parent
    // array stores the parent of each node in the graph, and the rank array stores the size
    // of each component. Initially, each node is its own parent and has rank 1. We can
    // define two operations on this data structure: find and union.

    // The find operation takes a node as input, and returns the root of its component. The
    // root is the node that has itself as its parent. To find the root of a node, we follow its
    // parent pointer until we reach the root. We also use path compression to optimize
    // this operation, which means that we always attach the smaller component to the
    // larger one, and update the rank accordingly.

    // Using these operations, we can iterate over the edges in the input array, and perform
    // union on their endpoints. If we find that two endpoints are already in the same
    // component, it means that they form a cycle in the graph, and we can return that
    // edge as the answer. Otherwise, we continue until we finish all the edges.

    public int[] findRedundantConnection(int[][] edges) {
        // Initialize the union-find data structure
        int n = edges.length; // The number of nodes in the graph
        int[] parent = new int[n + 1]; // The parent array
        int[] rank = new int[n + 1]; // The rank array
        for (int i = 1; i <= n; i++) {
            parent[i] = i; // Each node is its own parent initially
            rank[i] = 1; // Each node has rank 1 initially
        }

        // Iterate over the edges
        for (int[] edge : edges) {
            int u = edge[0]; // The first endpoint of the edge
            int v = edge[1]; // The second endpoint of the edge

            // Find the roots of u and v
            int ru = find(u, parent);
            int rv = find(v, parent);

            // If u and v are in the same component, they form a cycle
            if (ru == rv) {
                return edge; // Return this edge as the answer
            }

            // Otherwise, merge their components
            union(ru, rv, parent, rank);
        }

        // If no cycle is found, return en empty array
        return new int[0];
    }

    // The find operation with path compression
    private int find(int x, int[] parent) {
        if (x != parent[x]) { // If x is not its own parent
            parent[x] = find(parent[x], parent); // Recursively find its root and update its parent
        }
        return parent[x]; // Return its root
    }

    // The union operation with rank optimization
    private void union(int x, int y, int[] parent, int[] rank) {
        if (rank[x] < rank[y]) { // If X's component is smaller than y's component
            parent[x] = y; // Make y's root the parent of x's root
            rank[y] += rank[x]; // Update y's rank by adding x's rank
        } else { // Otherwise
            parent[y] = x; // Make x's root the parent of y's root
            rank[x] += rank[y]; // Update x's rank by adding y's rank
        }
    }

    // Big O:

    // The time complexity of this solution is O(n * alpha(n)), where n is the number of
    // nodes in the graph, and alpha(n) is the inverse Ackerman function, which grows
    // very slowly and can be considered as a constant for practical purposes.

    // The space complexity is O(n), as we need to store the parent and rank array.

}
