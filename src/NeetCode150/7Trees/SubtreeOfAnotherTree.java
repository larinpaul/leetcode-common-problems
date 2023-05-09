//// 2023/05/04 // 9:52 //

//// 572. Subtree of Another Tree // Easy //

// Given the roots of two binary trees root and subRoot, return true if there is a
// subtree of root with the same structure and node values of subRoot and false otherwise.

// A subtree of a binary tree tree is a tree that consists of a node in tree and all of
// this node's descendants. The tree tree could also be considered as a subtree of itself.

// Example 1:
// PICTURE
// Input: root = [3,4,5,1,2], subRoot = [4,1,2]
// Output: true

// Example 2:
// PICTURE
// Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
// Output: false

// Constraints:
// * The number of nodes in the root tree is in range [1, 2000].
// * The number of nodes in the subRoot tree is in the range [1, 1000].
// * -10^4 <= root.val <= 10^4
// * -10^4 <= subRoot.val <= 10^4

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
class SubtreeOfAnotherTree {

    // Definition for a binary tree node.
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

    // The main idea is to use a recursive method isSubtree that takes two tree nodes as parameters and
    // returns true if the second node is a subtree of the first node, false otherwise.

    // The base case of isSubtree is when either node is null. In that case, we return true if both nodes
    // are null (beaning they are both empty trees), false otherwise (meaning one tree is empty but the
    // other is not).

    // The recursive case of isSubtree is to check three conditions:
    // * If the two nodes have the same value and structure, we can use another helper method
    // isSameTree to check that. This method also uses recursion to compare the values
    // and subtrees of two nodes.
    // * If the second node is a subtree of the left child of the first node, we can call isSubtree again
    // with the left child and the second node as parameters.
    // * If the second node is a subtree of the right child of the first node, we can call isSubtree again
    // with the right child and the second node as parameters.

    // If any of these three conditions is true, we return true. Otherwise, we return false.
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base case: if either root or subRoot is null, return true if both are null,
        // false otherwise
        if (root == null || subRoot == null) {
            return root == subRoot;
        }
        // Recursive case: check if root and subRoot have the same value and structure,
        // or if subRoot is a subtree of root's left or right child
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);


    }

    // Helper method to check if two trees have the same value and structure
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: if either p or q is null, return true if both are null,
        // false otherwise
        if (p == null || q == null) {
            return p == q;
        }
        // Recursive case: check if p and q have the same value and their left and right subtrees
        // are also the same
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Big O:
    // * Time complexity: O(m * n), where m and n are the number of nodes in the first and second tree
    // respectively. This is because in the worst case, we have to compare every node in the first tree with
    // every node in the second tree using isSameTree, which takes O(m) time for each comparison.
    // Therefore, the total time complexity is O(m * n).
    // * Space complexity: O(h), where h is the height of the first tree. This is because we need O(h) space to
    // store the recursive call stack for isSubtree. The space complexity of isSameTree is also O(h),
    // but it does not add up to the overall space complexity since it is called within isSubtree.

}
