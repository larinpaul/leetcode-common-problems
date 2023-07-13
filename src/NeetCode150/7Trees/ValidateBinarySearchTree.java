//// 2023/07/13 // 16:30 //

//// 98. Validate Binary Search Tree // Medium //

// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:
// * The left subtree of a node contains only nodes with keys less than the node's key.
// * The right subtree of a node contains only nodes with keys greater than the node's key.
// * Both the left and right subtrees must also be binary search tree.

// Example 1:
// Image
// Input: root = [2,1,3]
// Output: true

// Example 2:
// Image
// Input: root = [5,1,4,null,null, 3, 6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.

// Constrains:
// * The number of nodes in the tree is in the range [1, 10^4].
// * -2^31 <= Node.val < 2^31 - 1

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
class ValidateBinarySearchTree {

    // Explanation
    // The problem is to determine if the given binary tree is a valid binary search tree (BST).
    // A valid BST has the following properties:
    // 1. The left subtree of a node contains only nodes with keys less than the node's key.
    // 2. The right subtree of a node contains only nodes with keys greater than the node's key.
    // 3. Both the left adn right subtrees must also be binary search trees.

    // To solve this problem, we will use a depth-first search (DFS) approach,
    // traversing the tree from the root to the leaves. At each node, we will check itf its value
    // is within the allowed range. We will pass the allowed range (minimum and maximum)
    // to the recursive function as we move down to the left and right subtrees.

    // Solution:
    // 1. Create a helper function isValidBSTHelper that takes a TreeNode,
    // a minimum value, and a maximum value as input.
    // 2. If the current node is null, return true.
    // 3. Check if the current node's value is within the allowed range (minimum and maximum).
    // 4. Recursively call the helper function for the left and right subtrees,
    // updating the allowed range for each subtree.
    // 5. If all recursive calls return true, the tree is a valid BST.

    // Code:
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

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return isValidBSTHelper(node.left, min, node.val) &&
                isValidBSTHelper(node.right, node.val, max);
    }

    // Big O:
    // Time Complexity:
    // The time complexity of this algorithm is O(n), where n is the number of nodes in the tree.
    // This is because we are visiting each node exactly once in out DFS traversal.
    // Space Complexity:
    // The space complexity of this algorithm is O(h), where h is the height of the tree.
    // This represents the maximum depth of the function call stack due to the recursive DFS traversal.
    // In the worst case, the tree can be completely unbalanced,
    // resulting in a height equal to the number of nodes(O(n)).
    // In the best case, the tree is perfectly balanced, resulting in a height of log(n) (O(log n)).


}
