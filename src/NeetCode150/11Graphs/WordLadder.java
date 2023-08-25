//// 2023/08/25 // 13:45 //

//// 127. Word Ladder // Hard //

// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a
// sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
// * Every adjacent pair of words differ by a single letter.
// * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// * sk == endWord

// Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the
// shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

// Example 1:
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","cog"]
// Explanation: One shortest transformation sequence is
// "hit" -> "hot" -> "dot" -> "dog" -> "cog", which is 5 words long.

// Example 2:
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
// Output: 0
// Explanation: The endWord "cog" is not in wordList,
// therefore there is no valid transformation sequence.

// Constraints:
// * 1 <= beginWord.length <= 10
// * endWord.length == beginWord.length
// * 1 <= wordList.length <= 5000
// * wordList[i].length == beginWord.length
// * beginWord, endWord, and wordList[i] consist of lowercase English letters.
// * beginWord != endWord
// * All the words in wordList are unique.


import javax.print.DocFlavor;
import java.util.*;

class WordLadder {

    // Problem Explanation:

    // Given a beginWord, an endWord, and a wordList, the task is to find the
    // shortest transformation sequence from beginWord to endWord.
    // A transformation sequence is a sequence of words where each adjacent pair
    // of words differs by a single letter. The transformation sequence should be
    // formed using words from the wordList, and beginWord does not need
    // to be in the wordList.

    // The goal is to return the number of words in the shortest transformation
    // sequence from beginWord to endWord. If no such sequence exists, return 0.

    // Optimal Solution:

    // To solve this problem, we can use a breath-first search (BFS) algorithm.
    // The idea is to start from the beginWord and explore all possible
    // transformations by changing each character of the word and checking if
    // the resulting word is present in the wordList. We'll keep track of the
    // level of distance of each word from the beginWord using a distance map.

    // 1. Create a set wordSet from the wordList for efficient lookup.
    // 2. Create a queue queue for BFS and add the beginWord to the queue.
    // 3. Create a map distMap to store the minimum distance of each word
    // from the beginWord. Initialize all distances with infinity except for the
    // beginWord, which has a distance of 1.
    // 4. While the queue is not empty, do the following:
    // * Remove the front word from the queue.
    // * Generate all possible transformations of the word by changing each character.
    // * For each transformed word, check if it is present in the wordSet and not visited.
    // * If the transformed word is valid, add it to the queue, mark it as
    // visited, and set its distance as distMap[currentWord] + 1.
    // * If the transformed word is the endWord, return its distance from the beginWord.
    // 5. If the endWord is not found during the BFS, return 0.

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // endWord is not in wordList
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Map<String, Integer> distMap = new HashMap<>();
        distMap.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String currentWord = queue.poll();

            for (int i = 0; i < currentWord.length(); i++) {
                char[] wordChars = currentWord.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordChars[i] = ch;
                    String transformedWord = new String(wordChars);

                    if (wordSet.contains(transformedWord) && !distMap.containsKey(transformedWord)) {
                        queue.offer(transformedWord);
                        distMap.put(transformedWord, distMap.get(currentWord) + 1);
                        if (transformedWord.equals(endWord)) {
                            return distMap.get(transformedWord);
                        }
                    }
                }
            }
        }

        return 0; // endWord not found
    }

    // Time Complexity:

    // The time complexity of this solution is O(M^2 * N), where M is the length
    // of each word and N is the total number of words in the wordList. In the
    // worst case, we need to generate all possible transformations of a word,
    // which takes O(M^2) time. We perform this operations for N words,
    // resulting in a total time complexity of O(M^2 * N).

    // Space Complexity:

    // The space complexity of this solution is O(M^2 * N), where M is the
    // length of each word and N is the total number of words in the wordList.
    // We use a set wordSet to store the words from the wordList, which
    // requires O(N) space. Additionally, we use a queue and a distance map
    // distMap, which can contain up to N words in the worst case.
    // Therefore, the overall space complexity is O(M^2 * N).

}
