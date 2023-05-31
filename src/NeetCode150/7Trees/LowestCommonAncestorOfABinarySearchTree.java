//// 2023/05/31 // 23:04 //

//// 235. Lowest Common Ancestor of a Binary Search Tree // Medium //

// Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given
// nodes in the BST.

// According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined
// between two nodes p and q as the lowest node in T that has both p and q as
// descendants (where we allow a node to be a descendant of itself)."

// Example 1:
// Picture
// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
// Output: 6
// Explanation: The LCA of nodes 2 and 8 is 6.

// Example 2:
// Picture
// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
// Output: 2
// Explanation: The LCA of nodes 2 and 4 is 2, since a node can be
// a descendant of itself according to the LCA definition.

// Example 3:
// Input: root = [2,1], p = 2, q = 1
// Output: 2

// Constraints:
// * The number of nodes in the tree is in the range [2, 10^5].
// * -10^9 <= Node.val <= 10^9
// * All Node.val are unique.
// * p != q
// * p and q will exist in the BST.

class LowestCommonAncestorOfABinarySearchTree {

    // You are asked to find the lowest common ancestor (LCA)of two
    // nodes in a binary search tree (BST). The LCA is the lowest node that has both nodes as descendants.
    // A node can be a descendant of itself.

    // One possible solution is to use the property of BST: for any node, all the nodes in its left subtree are
    // smaller than it, and all the nodes in its right subtree are larger than it. Therefore, we can compare the
    // values of the root, p and q to determine which subtree to search.

    // We start from the root and compare its value with p and q. If both p and q are smaller than the root,
    // then we know that the LCA ust be in the left subtree. We recursively search the left subtree with the same
    // logic. If both p and q are larger than the root, then we know that the LCA must be in the right subtree.
    // We recursively search the right subtree with the same logic. If neither of these cases gold, then we know
    // that the root is the LCA. This is because either p or q is equal to the root, or p and q are on different
    // sides of the root.

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // The code for this solution is:
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case: if root is null or equal to p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }
        // compare root value with p and q values
        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        // if both p and q are smaller than root, search left subtree
        if (pVal < rootVal && qVal < rootVal) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // if both p and q are larger than root, search right subtree
        else if (pVal > rootVal && qVal > rootVal) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // otherwise, root is the LCA
        else {
            return root;
        }
    }

    // The time complexity of this solution is O(h), where h is the height of the BST.
    // (It is actually O(log n), where BST is balanced )
    // This is because we only visit one node per level of the tree.
    // The space complexity is O(h), which is the space used by the recursion stack.
    // In the worst case, h can be O(n), where n is the number of nodes in the tree.

}





