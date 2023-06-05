//// 2023/05/06 // 19;13 //

//// 133. Clone Graph // Medium //

// Given a reference of a node in a connected undirected graph.

// Return a deep copy (clone) of the graph.

// Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

//  class Node {
//      public int val;
//      public List<Node> neighbors;
//  }

// Test case format:
// For simplicity, each node's value is the same as the node's index (1-indexed).
// For example, the first node with val == 1, the second node with val == 2, and so on.
// The graph is represented in the test case using an adjacency list.

// An adjacency list is a collection of unordered lists used to represent a finite graphs.
// Each list describes the set of neighbors of a node in the graphs.

// The given node will always be the first node with val == 1.
// You must return the copy of the given node as a reference to the cloned graph.

// Example 1:
// Picture
// Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
// Output: [[2,4],[1,3],[2,4],[1,3]]
// Explanation: There are 4 nodes in the graph.
// 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 1).
// 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
// 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
// 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

// Example 2:
// Picture
// Input: adjust = [[]]
// Output: [[]]
// Explanation: Note that the input contains one empty list.
// The graph consists of only one node with val = 1 and it does not have any neighbors.

// Example 3:
// Input: adjList = []
// Output: []
// Explanation: This an empty graph, it does not have any nodes.

// Constraints:
// * THe number of nodes in the graph is in the range [0,100].
// * 1 <= Node.val <= 100
// * Node.val is unique for each node
// * There are no repeated edges and no self-loops in the graph.
// * The Graph is connected and all nodes can be visited starting from the given node.


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class CloneGraph {

    // The problem is to clone a graph given a reference node. A graph is a collection of nodes
    // and edges, where each node has a value and a list of neighbors. A clone of a graph is a
    // copy of the graph with the new nodes that have the same values and neighbors as the original nodes.

    // One possible solution is to use a depth-first search (DFS) algorithm to traverse the graph
    // and create new nodes along the way. We can use a hash map to store the mapping
    // between the original nodes and the cloned nodes, so that we can avoid creating duplicate nodes
    // and maintain the correct neighbor relationships.
    // The algorithm works as follows:
    // * If the given node is null, return null.
    // * If the node is already in the hash map, return the corresponding cloned node.
    // * Otherwise, create a new node with the same value as the node, and add it to the hash map.
    // * For each neighbor of the node, recursively call the cloneGraph function and add the
    // result to the new node's neighbor list.
    // * Return the new node.

    // Code:

    // Definition for a Node.
    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // A hash map to store the mapping between original nodes and cloned nodes
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        // If the given node is null, return null
        if (node == null) {
            return null;
        }

        // If the node is already in the hash map, return the corresponding cloned node
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Otherwise, create a new node with the same value as the node, adn add it to the hash map
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        // For each neighbor of the node, recursively call the cloneGraph function
        // and add teh result to the new node's neighbor list
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        // Return the new node
        return cloneNode;
    }

    // The time complexity of this solution is O(n), where n is the number of nodes in the graph.
    // This is because we visit each node exactly once and process its neighbors in constant time.

    // The space complexity of this solution is O(n), where n is the number of nodes in the graph.
    // This is because we use a hash map to store N nodes, adn we also use O(n) space
    // for the recursive call stack.

}




























