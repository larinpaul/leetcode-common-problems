//// 2023/05/03 // 23:09 //

//// 100. Same Tree // Easy //

// Given the roots of two binary trees p and q, write a function to check if the y are
// the same or not.

// Two binary trees are considered the same if they are structurally identical, and the
// nodes have the same value.

// Example 1:
// PICTURE
// Input: p = [1,2,3], q = [1,2,3]
// Output: true

// Example 2:
// PICTURE
// Input: p = [1,2], q = [1,null,2]
// Output: false

// Example 3:
// PICTURE
// Input: p = [1,2,1], q = [1,1,2]
// Output: false

// Constraints:
// * The number of nodes in both trees is in the range [0, 100].
// * -10^4 <= Node.val <= 10^4

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
class SameTree {

    // The solution is to use a recursive approach to compare the values and structures of the two trees.
    // The base case is when both nodes are null, which means they are the same.
    // If one node is null and the other is not, or if they have different values,
    // then they are not the same. Otherwise, we recursively check
    // if the left and right subtrees of the two nodes are the same.

    // The time complexity of this solution is O(n), where n is the number of nodes in the tree.
    // This is because we visit each node at most once in the recursion.

    // The space complexity of this solution is O(h), where h is the height of the tree.
    // This is because we use a stack space for the recursive calls, and the maximum depth of the recursion is h.

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case: both nodes are null
        if (p == null && q == null) {
            return true;
        }
        // if one node is null and the other is not, or if they have different values, they are not the same
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        // recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
