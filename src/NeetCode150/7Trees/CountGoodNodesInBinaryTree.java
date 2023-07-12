//// 2023/07/12 // 9:12 //

//// 1448. Count Good Nodes in Binary Tree // Medium //

// Given a binary tree root, a node X in the tree is named good if in the path from root to
// X there are no nodes with a value greater than X.

// Return the number of good nodes in the binary tree.

// Example 1:
// Image
// Input: root = [3,1,4,3,null,1,5]
// Output: 4
// Explanation: Nodes in blue are good.
// Root Node (3) is always a good node.
// Node 4 -> (3,4) is the maximum value in the path starting from the root.
// Node 5 -> (3,4,5) is the maximum value in the path
// Node 3 -> (3,1,3) is the maximum value in the path.

// Example 2:
// Picture
// Input: root = [3,3,null,4,2]
// Output: 3
// Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.

// Example 3:
// Input: root = [1]
// Output: 1
// Explanation: Root is considered as good.

// Constraints:
// * The number of nodes in the binary tree is in the range [1, 10^5].
// * Each node's value is between [-10^4], 10^4].

class CountGoodNodesInBinaryTree {

    // Explanation:
    // In this problem we need to find the number of good nodes in a binary tree.
    // A good node is defined as a node X for which there are no nodes with a value greater than X
    // in the path from the root to X.

    // A possible solution is to perform a depth-first search (DFS) traversal on the tree.
    // While traversing the tree, we will keep track of the maximum value seen so far.
    // If the current node's value is greater than or equal to the maximum value seen so far,
    // we increment the count of good nodes.

    // Solution:
    // 1. Perform a DFS traversal starting from the root of the tree.
    // 2. Keep track of the maximum value seen so far in the path from the root to the current node.
    // 3. If the current node's value is greater than or equal to the maximum value,
    // increment the count of good nodes.
    // 4. Return the count of good nodes.

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxValueSeenSoFar) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        if (node.val >= maxValueSeenSoFar) {
            count = 1;
            maxValueSeenSoFar = node.val;
        }

        count += dfs(node.left, maxValueSeenSoFar);
        count += dfs(node.right, maxValueSeenSoFar);

        return count;
    }

    // Big O:
    // The time complexity of this solution is O(N), where N is the number of nodes in the binary tree.
    // This is because we traverse each node once during the DFS traversal.
    // The space complexity is O(H), where H is the height of the tree.
    // This is because in the worst case, the maximum number of function calls stored on the call stack
    // will be the height of the tree.

}
