//// 2023/04/19 // 20:01

//// 208. Implement Trie (Prefix Tree) // Medium

// A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and
// retrieve keys in a dataset of strings. There are various applications of this data structure, such
// as autocomplete and spellchecker.

// Implement the Trie class:
// * Trie() Initializes the trie object
// * void insert(String word) Inserts the string word into the trie.
// * boolean search(String word) Returns true if the string word is in the trie (i.e., was
// inserted before), and false otherwise.
// * boolean startsWitch(String prefix) Returns true if there is a previously inserted
// string word that has the prefix prefix, and false otherwise.

// Example 1:
// Input: ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
// [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
// Output:
// [null, null, true, false, true, null, true]

// Explanation
// Trie trie = new Trie();
// trie.insert("apple");
// trie.search("apple"); // return True
// trie.search("app"); // return False
// trie.startsWith("app"); // return True
// trie.search("app"); // return True

class TrieNode {
    private static final int ALPHABET_SIZE = 26;
    private boolean isEndOfWord;
    private TrieNode[] children;
    public TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            children[i] = null;
        }
    }
    public boolean isEndOfWord() {
        return isEndOfWord;
    }
    public void setEndOfWord(boolean isEndOfWord) {
        this.isEndOfWord = isEndOfWord;
    }
    public TrieNode[] getChildren() {
        return children;
    }
    public void setChildren(TrieNode[] children) {
        this.children = children;
    }
}

class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.getChildren()[index] == null) {
                current.getChildren()[index] = new TrieNode();
            }
            current = current.getChildren()[index];
        }
        current.setEndOfWord(true);
    }
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.getChildren()[index] == null) {
                return false;
            }
            current = current.getChildren()[index];
        }
        return current.isEndOfWord();
    }
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.getChildren()[index] == null) {
                return false;
            }
            current = current.getChildren()[index];
        }
        return true;
    }
}
//
//    The code consists of two classes: TrieNode and Trie.
//
//        The TrieNode class represents a node in the trie. It has three fields:
//
//        isEndOfWord: a boolean flag that indicates if the node is the end of a word

//        children: an array of child nodes for each possible character in the alphabet

//        ALPHABET_SIZE: a constant that defines the size of the alphabet (26 for lowercase English letters)

//        The TrieNode class also has a constructor that initializes the fields,
//        and getters and setters for accessing and modifying them.
//
//        The Trie class represents the trie itself. It has one field:
//
//        root: the root node of the trie
//        The Trie class also has a constructor that creates an empty root node, and three methods:
//
//        insert: this method takes a word as a parameter and inserts it into the trie.
//        It starts from the root node and loops through each character of the word.
//        For each character, it gets the index of the character in the alphabet and checks
//        if the current node has a child node for that character. If not, it creates a new node
//        and links it to the current node. Then it moves to the next node.
//        After looping through all the characters, it marks the current node as the end of the word.

//        search: this method takes a word as a parameter and returns true
//        if it exists in the trie, or false otherwise.
//        It starts from the root node and loops through each character of the word. For each character,
//        it gets the index of the character in the alphabet and checks
//        if the current node has a child node for that character.
//        If not, it returns false as the word does not exist in the trie.
//        Then it moves to the next node. After looping through all the characters,
//        it returns true if the current node is marked as the end of the word.

//        startsWith: this method takes a prefix as a parameter and returns true
//        if there is any word in the trie
//        that starts with that prefix, or false otherwise.
//        It starts from the root node and loops through each character of the prefix.
//        For each character, it gets the index of the character in the alphabet
//        and checks if the current node has a child node for that character.
//        If not, it returns false as there is no word that starts with that prefix.
//        Then it moves to the next node. After looping through all the characters,
//        it returns true as it has reached the end of the prefix without any null node.
