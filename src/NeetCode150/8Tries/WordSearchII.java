//// 2023/07/18 // 19:00 //

//// 212. Word Search II // Hard //

// Given an m x n board of characters and a list of string words,
// return all words on the board.

// Each word must be constructed from letters of sequentially adjacent
// cells, where adjacent cells are horizontally or vertically neighboring.
// The same letter cell may not be used more than one in a word.

// Example 1:
// Image
// Input: board = [["o","a","a","n"],
// ["e","t","a","e"],["i","h","k","r"],
// ["i","f","l","v"]], words =
// ["oath","pea","eat","rain"]
// Output: ["eat","oath"]

// Example 2:
// Image
// Input: board = [["a","b"],["c","d"]], words = ["abcb"]
// Output: []

// Constraints:
// * m == board.length
// * n == board[i].length
// * 1 <= m, n <= 12
// * board[i][j] is a lowercase English letter.
// * 1 <= words.length <= 3 * 10^4
// * 1 <= words[i].length <= 10
// * words[i] consists of lowercase English letters.
// * All the strings of words are unique.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordSearchII {

    // Explanation:
    // This problem can be solved using a combination of Trie and Depth-First Search (DFS).
    // A Trie (also known as prefix tree) is a special type of tree used to store associative
    // data structures. Storing our dictionary of words into a Trie, we can efficiently
    // traverse through the board and check the existence of the words.

    // Here is the overall approach:
    // 1. Build a Trie with the given words.
    // 2. Traverse the board. For each character, treat it as a starting point and do the DFS
    // to find any word in the Trie that starts with this character.
    // 3. Use a set to store the found words.

    // Code:

    private class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        // Construct the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }

        // Search for the word starting from each cell
        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, root, result);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, Set<String> result) {
        char ch = board[i][j];
        node = node.children[ch - 'a'];
        if (node.word != null) {
            result.add(node.word);
        }

        board[i][j] = '#'; // Mark the visited cell
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k], nj = j + dy[k];
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                if (board[ni][nj] != '#' && node.children[board[ni][nj] - 'a'] != null) {
                    dfs(board, ni, nj, node, result);
                }
            }
        }
        board[i][j] = ch; // Restore the cells
    }

    // Big O:
    // Time and Space Complexity Analysis

    // The time complexity of the solution is O(M * N * 4^L), where M is the number of rows in the board,
    // N is the number of columns in the board, and L is the maximum length of the words.
    // This is because in the worst-case scenario, we need to traverse from each cell in the board,
    // and for each cell, we can go in 4 directions, and we might do this up to L times.

    // The space complexity of the solution is O(W), where W is the total number of characters in all the words.
    // This is because we store all the words in the Trie.

}
