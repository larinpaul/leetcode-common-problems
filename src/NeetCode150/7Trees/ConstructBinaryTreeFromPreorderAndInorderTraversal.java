//// 2023/07/15 // 12:43 //

//// 105. Construct Binary Tree from Preorder and Inorder Traversal // Medium //

// Given two integer arrays preorder and inorder where preorder is the preorder traversal
// of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree.

// Example 1:
// Image
// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]

// Example 2:
// Input: preorder = [-1], inorder = [-1]
// Output: [-1]

// Constraints:
// * 1 <= preorder.length <= 3000
// * inorder.length == preorder.length
// * -3000 <= preorder[i], inorder[i] <= 3000
// * preorder and inorder consist of unique values.
// * Each value of inorder also appears in preorder.
// * preorder is guaranteed to be the preorder traversal of the tree.
// * inorder is guaranteed to be the inorder traversal of the tree.

import java.util.HashMap;

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
class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    // Explanation
    // A binary tree can be uniquely constructed given its preorder and inorder traversal results.
    // * Preorder Traversal: In this traversal method, the root node is visited first,
    // then the left subtree, and finally the right subtree.
    // * Inorder Traversal: In this traversal method, the left subtree is visited first,
    // then the root node, and finally the right subtree.

    // From the preorder array, we know that the first element is the root.
    // We can find this root in the inorder array to determine the size of the left and right subtrees.
    // In the inorder array, elements to the left of the root are in the left subtree,
    // and elements to the right are in the right subtree.

    // We can then recursively apply this process to construct the binary tree.

    // Solution
    // To implement this solution in Java, we'll use a helper function buildTreeHelper().
    // We'll also use a HashMap to store the value-index pairs of the inorder array
    // in order to achieve constant time lookups.

    /**
     * Definition for a binary tree node
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

    // Code:
    private int preIndex = 0;
    private int[] preorder;
    private int[] inorder;
    private HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        // Build a hashmap to store value -> index relations
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeHelper(0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int left, int right) {
        // If there are no elements to construct the tree
        if (left > right) return null;

        // Select the preIndex element as the root and increment it
        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Build left and right subtrees
        root.left = buildTreeHelper(left, inorderIndexMap.get(rootValue) - 1);
        root.right = buildTreeHelper(inorderIndexMap.get(rootValue) + 1, right);

        return root;
    }

    // Big O:
    // Time and Space Complexity:

    // The time complexity for this solution is O(n), where n is the number of nodes,
    // because we visit each node exactly once.

    // The space complexity is also O(n). Even though we have recursive calls,
    // they are not all simultaneously placed on the stack, so the maximum depth of the stack
    // is the height of the tree, which is log(n) in the case of a balanced tree.
    // However, since we have to store the elements in a hashmap,
    // this results in a space complexity of O(n).

}
