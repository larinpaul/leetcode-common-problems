//// 2023/07/17 // 15:35 //

//// 297. Serialize and Deserialize Binary Tree // Hard //

// Serialization is the process of converting a data structure or object
// into a sequence of bits so that it can be stored in a file or memory
// buffer, or transmitted across a network connection link to be
// reconstructed later in the same or another computer environment.

// Design an algorithm to serialize and deserialize a binary tree. There
// is no restriction on how your serialization/deserialization algorithm
// should work. You just need to ensure that a binary tree can be
// serialized to a string and this string can be deserialized to the
// original tree structure.

// Clarification: The input/output format is the same as how LeetCode
// serialized a binary tree. You do not necessarily need to follow this
// format, so please be creative and come up with different
// approaches yourself.

// Example 1:
// Image
// Input: root = [1,2,3,null,null,4,5]
// Output: [1,2,3,null,null,4,5]

// Example 2:
// Input: root = []
// Output: []

// Constraints:
// * The number of nodes in the tree is in the range [0, 10^4].
// * -1000 <= Node.val <= 1000

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SerializeAndDeserializeBinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Your Codec object will be instantiated and called as such:
    // Codec ser = new Codec();
    // Codec deser = new Codec();
    // TreeNode ans = deser.deserialize(ser.serialize(root));

    public class Codec {

        // The idea to solve this problem is to use a pre-order traversal to
        // serialize the binary tree, where we append the current node's value
        // to our string, then serialize the left subtree and finally the right
        // subtree. For null nodes, we append a sentinel value (like 'X').

        // To deserialize, we'll split the string along the command to get an
        // array of values. Then we recursively build the binary tree by taking
        // the first value from the array (which will be the root), then
        // recursively building the left and right subtree.

        // Encode a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "X";
            }
            String leftSerialized = serialize(root.left);
            String rightSerialized = serialize(root.right);
            return root.val + "," + leftSerialized  + "," + rightSerialized;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> nodesLeft = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserializeHelper(nodesLeft);
        }

        private TreeNode deserializeHelper(Queue<String> nodesLeft) {
            String valueForNode = nodesLeft.poll();
            if (valueForNode.equals("X")) {
                return null;
            }
            TreeNode newNode = new TreeNode(Integer.valueOf(valueForNode));
            newNode.left = deserializeHelper(nodesLeft);
            newNode.right = deserializeHelper(nodesLeft);
            return newNode;
        }

    }

    // In the deserialize function, we use a queue to keep track of the
    // remaining nodes to be processed. The queue helps us to process
    // the nodes in the order they appear in the serialized string.

    // For the time complexity of both serialize and deserialize function,
    // it's O(n), where n is the number of nodes in the binary tree. This is
    // because we visit each node exactly once during the serialization
    // and deserialization processes. The space complexity is also O(n)
    // due to the recursion stack during the depth-first search (which is
    // what pre-order traversal is) and due to storing the serialized data.

}
