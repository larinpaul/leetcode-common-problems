//// 2023/07/14 // 12:19 //

//// 230. Kth Smallest Element in a BST // Medium //

// Given the root of a binary search tree, and an integer k, return the kth smallest value
// (1-indexed) of all the values of the nodes in the tree.

// Example 1:
// Image
// Input: root = [3,1,4,bull,2], k = 1
// Output: 1

// Example 2:
// Image
// Input: root = [5,3,6,2,4,null,null,1], k = 3
// Output: 3

// Constraints:
// * The number of nodes in the tree is n.
// * 1 <= k <= n <= 10^4
// * 0 <= Node.val <= 10^4

// Follow up: If the BST is modified often (i.e., we can do insert and delete operations)
// and you need to find the kth smallest frequently, how would you optimize?

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
class KthSmallestElementInABST {

    // Explanation:
    // The problem requires us to find the kth smallest element in a Binary Search Tree (BST).

    // A key property of BST is that the elements to the left of a node are
    // smaller than the node itself, and the elements to the right are larger.
    // This property of BST allows us to perform an in-order traversal (left -> root -> right)
    // to get the elements in ascending order.

    // For this problem, we can perform an in-order traversal and keep count of the nodes visited.
    // When the count is equal to k, we have found the kth smallest element.

    // Java Code:
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        count++;
        if (count == k) result = root.val;
        traverse(root.right, k);
    }

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

    // In this code, we define a private helper function traverse()
    // to perform an in-order traversal. We also define two instance variables count and result
    // to keep track of the number of nodes visited and the kth smalelst element respectively.

    // The function kthSmallest() first calls traverse() to start the traversal,
    // and then returns the result.

    // In traverse(), we first traverse the left subtree, then visit the root
    // (i.e., increment the count and update the result if necessary),
    // and finally traverse the right subtree.

    // Big O:

    // Time Complexity:
    // The time complexity of this solution is O(n), where n is the number of nodes in the tree.
    // This is because in the worst case, we need to visit all nodes of the tree.

    // Space Complexity
    // The space complexity is O(h), where h is the height of the tree.
    // This space is required for the call stack of the recursion,
    // which can go as deep as the height of the tree.

    // Optimization for Frequent Operations
    // To optimize for frequent insert, delete and kth smallest operations,
    // we can augment the BST to keep track of the size of the subtree rooted at each node.
    // This way, for each node, we can figure out how many nodes are smaller than it,
    // and hence determine whether the kth smallest is in its left subtree, right subtree,
    // or it is the node itself. This can potentially bring the time complexity
    // of the kth smallest operation down to O(log n),
    // but at the cost of complicating the insert and delete operations.

}
