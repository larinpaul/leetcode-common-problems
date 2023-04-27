//// 2023/04/27 // 9:58 //

//// 49. Group Anagram // Medium //

// Given an array of string strs, group the anagrams together. You can return the answer in any order.

// An Anagram is a word or phase formed by rearranging the letters of a different word or phase,
// typically using all the original letters exactly once.

// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

// Example 2:
// Input: strs = [""]
// Output: [[""]]

// Example 3:
// Input: strs = ["a"]
// Output: [["a"]]

// Contraints:
// * 1 <= strs.length <= 10^4
// * 0 <= strs[i].length <= 100
// * strs[i] consists of lowercase English letters.

import java.util.*;

class GroupAnagram {

    // One possible solution to group anagrams in Java is to use a HashMap that maps a sorted
    // String to a List of String that are anagrams of it. For example, if the input array is
    // ["eat","tea","tan","ate","nat","bat"], then the HashMap would look like this:
    // {"aet" -> ["eat","tea","ate"], "ant" -> ["tan","nat"], "abt" -> ["bat"}}

    // To create this hashmap, you can iterate over the input array and sort each String using
    // Arrays.sort() method. Then, use the sorted String as a key and add the original String to the
    // corresponding List in the HashMap. If the key does not exist, create a new List and put it in the
    // HashMap.

    // After creating the HashMap, you can return a List of Lists that contains all the values from the
    // HashMap. This will give you the desired output.

    // The time complexity of this solution is O(nklogk), where n is the length of the input array
    // and k is the maximum length of any String in the array. This is because sorting each String takes
    // O(klogk) time and iterating over the array takes O(n) time.

    // The space complexity of this solution is O(nk), where n is the length of the input array
    // and k is the maximum length of any String in the array. This is because we need to store
    // all the String in the HashMap and the output List.

    // Here is a possible code implementation based on this idea:
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a HashMap to store sorted String as keys and Lists of anagrams as values
        Map<String, List<String>> map = new HashMap<>();
        // Iterate over the input array
        for (String str : strs) {
            // Convert each String to a char array and sort it
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // Use the sorted String as a key
            String key = new String(chars);
            // If the key does not exist in the Map, create a new List and put it in the Map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            // Add the original String to the List corresponding to the key
            map.get(key).add(str);
        }
        // Return a List of Lists that contains all the values from the map
        return new ArrayList<>(map.values());
    }

    // There are some possible ways to improve the code, depending on the input and the requirements

    // One way is to use a different way of generating the key for the HashMap, instead of sorting
    // each String. For example, you can use the count of each character as a key,
    // such as "11#1" for "aab". This way, you can avoid sorting each String, which takes O(klogk) time.
    // However, this might increase the space complexity of the HashMap, as the keys might be
    // longer than the Strings. Also, you need to use a delimiter character such as "#" to separate
    // the counts of different characters, otherwise you might get collisions.

    // Another way is to use a trie data structure instead of a HashMap. A trie is a tree-like structure
    // that stores Strings by their common prefixes. For example, if you have the Strings
    // "dog", "dot', "cat", and "car", you can store them in a trie like this:

    // root /
    // d c / \ /
    // o a y r / / / / g t a r

    // To group anagrams using a trie, you can sort each String and insert it into the trie.
    // Then, you can traverse the trie and collect all the String that have the same sorted prefix.
    // For example, if you have the String "eat", "tea', "tan", "ate", and "nat", you can store them
    // in a trie like this:

    // root /
    // a t / \ /
    // e n e n / / / / t t a t

    // Then, you can collect all the String that have the same prefix "aet" as one group,
    // adn all the String that have the same prefix "ant" as another group.

    // The advantage of using a trie is that it can reduce the space complexity of storing the
    // String, as it avoids storing duplicate prefixes. However, it might increase the time
    // complexity of inserting and traversing the trie, as it involves more operations
    // that using a HashMap.

    // Here is a possible code implementation based on this idea:
    // A node class for trie
    static class TrieNode {
        // An array of child nodes
        TrieNode[] children = new TrieNode[26];
        // A list of strings that have the same sorted prefix
        List<String> list = new ArrayList<>();
    }

    // A helper method to insert a string into a trie
    static void insert(TrieNode root, String str) {
        // Get the sorted version of the string
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);
        // Traverse the trie according to the key
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            int index = c - 'a';
            // If there is no child node for this character, create one
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            // Move to the child node
            curr = curr.children[index];
        }
        // Add the original string to the list of this node
        curr.list.add(str);
    }

    // A helper method to traverse a trie and collect all groups of anagrams
    static void traverse(TrieNode root, List<List<String>> result) {
        // If this node has a non-empty list, add it to the result
        if (root.list.size() > 0) {
            result.add(root.list);
        }
        // Recursively traverse all child nodes
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                traverse(root.children[i], result);
            }
        }
    }

    public List<List<String>> groupAnagramsTrie(String[] strs) {
        // Create a root node for trie
        TrieNode root = new TrieNode();
        // Insert all strings into trie
        for (String str : strs) {
            insert(root, str);
        }
        // Create a list to store the result
        List<List<String>> result = new ArrayList<>();
        // Traverse the trie and collect all groups of anagrams
        traverse(root, result);
        // Return the result
        return result;
    }




}












