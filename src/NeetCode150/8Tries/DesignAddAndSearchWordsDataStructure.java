//// 2023/06/013 // 19:05 //

//// 211. Design Add and Search Words Data Structure // Medium //

// Design a data structure that supports adding new words and finding if a string matches any previously added string.

// Implement the WordDictionary class:
// * WordDictionary() initializes the object.
// * void addWord(word) Adds word to the data structure,
// it can be matched later.
// * bool search(word) Returns true if there is any string in the data structure
// that matches word or false otherwise.
// word may contain dots '.' where dots can be matched with any letter.

// Example:
// Input
// ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
// [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
// Output:
// [null,null,null,null,false,true,true,true]

// Explanation
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("bad");
// wordDictionary.addWord("dad");
// wordDictionary.addWord("mad");
// wordDictionary.search("pad"); // return False
// wordDictionary.search("bad"); // return True
// wordDictionary.search(".ad"); // return True
// wordDictionary.search("b.."); // return True

// Constraints:
// * <= word.length <= 25
// * word in addWord consists of lowercase English letters.
// * There will be at most 2 dots in word for search queries.
// * At most 10^4 calls will be made to addWord and search.

import java.util.Timer;

class DesignAddAndSearchWordsDataStructure {

    // The idea is to design a data structure that can store words and also support searching for words
    // with wildcards (dots). One possible data structure that can achieve this is a trie (also known
    // as a prefix tree), which is a tree-like structure where each node represents a character
    // and each path from the root to a leaf represents a word. A trie can efficiently insert and search
    // for words by following the corresponding character from the root.

    // To implement a trie, we need a TrieNode class that has an array of 26 children nodes
    // (one for each lowercase letter) and a boolean flag to indicate if the node is in the end of a word.
    // We also need a WordDictionary class that has a root TieNode and two methods: addWord and search.

    // The addWord method simply inserts a word into the trie by creating new nodes if needed
    // and setting the end flag to true at the last node.

    // The search method recursively searches for a word in the trie, with two cases:
    // * If the current character is no a dot, we check if the corresponding child
    // node exists and continue the search form there.
    // * If the current character is a dot, we try all possible child nodes
    // and return true if any of them matches the rest of the word.

    // Solution:

    private class TrieNode {
        TrieNode[] children; // array of 26 children nodes
        boolean isEnd; // flag to indicate end of word

        // Constructor
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    // Declare root node
    TrieNode root;

    // Initialize data structure
    public WordDictioanry() {
        root = new TrieNode();
    }

    // Add word to trie
    public void addWord(String word) {
        TrieNode curr = root; // start from root
        for (char c : word.toCharArray()) { // loop through each character
            int index = c - 'a'; // get index of character
            if (curr.children[index] == null) { // if child node does not exist
                curr.children[index] = new TrieNode(); // create new node
            }
            curr = curr.children[index]; // move to child node
        }
        curr.isEnd = true; // mark end of word
    }

    // Search word in trie
    public boolean search(String word) {
        return searchHelper(word, 0, root); // call helper method with word, index and root
    }

    // Helper method to search recursively
    private boolean searchHelper(String word, int index, TrieNode node) {
        if (index == word.length()) { // if reached end of word
            return node.isEnd; // return end flag of node
        }
        char c = word.charAt(index); // get current character
        if (c != '.') { // if not a dot
            int i = c - 'a'; // get index of character
            if (node.children[i] == null) { // if child node does not exist
                return false; // return false
            }
            return searchHelper(word, index + 1, node.children[i]); // continue search from child node
        } else { // if a dot
            for (TrieNode child : node.children) { // loop through all possible child nodes
                if (child != null && searchHelper(word, index + 1, child)) { // if child node exists and matches rest of word
                    return true;
                }
            }
            return false; // return false if no match found
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

// The time complexity of addWord is O(n), where n is the length of the word,
// since we need to traverse each character and create nodes if needed.

// The time complexity of search is O(m * 26*l), where m is the length of the word
// and L is the number of dots in the word, since we need to traverse each character
// and try all possible branches for dots.

// The space complexity of both methods is O(n * k), where n is the number of words
// and k is the average length of words,
// since we need to store all words in the trie nodes.
