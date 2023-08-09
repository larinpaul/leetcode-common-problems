//// 2023/08/09 // 9:54 //

//// 846. Hand of Straights // Medium //

// Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of
// size groupSize, and consists of groupSize consecutive cards.

// Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize,
// return true if she can rearrange the cards, or false otherwise.

// Example 1:
// Input: hard = [1,2,3,6,2,3,4,7,8], groupSize = 3
// Output: true
// Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

// Example 2:
// Input: hand = [1,2,3,4,5], groupSize = 4
// Output: false
// Explanation: Alice's hand can not be rearranged into groups of 4.

// Constraints:
// * 1 <= hand.length <= 10^4
// * 0 <= hand[i] <= 10^9
// * 1 <= groupSize <= hand.length


import java.util.TreeMap;

class HandOfStraights {

    // The problem asks us to determine if we can rearrange an array of cards into groups of
    // consecutive cards of a given size. For example, if the array is [1,2,3,6,2,3,4,7,8] and the
    // group size is 3, we can form three groups: [1,2,3],[2,3,4], and [6,7,8]. However, if the group
    // size is 4, we cannot form any groups.

    // One possible solution is to use a tree map to store the frequency of each card value in the
    // array. A tree map is a data structure that keeps the keys in sorted order. Then, we iterate
    // over the keys of the three map and try to form groups starting from the smallest card
    // value. For each key, we check if there are enough cards to form a group of the given size.
    // If there are not enough cards, we return false. Otherwise, we reduce the frequency of the
    // current key and the next groupSize - 1 keys by one. We repeat this process until we either
    // for all the groups or encounter an invalid case.

    public boolean isNStraightHand(int[] hand, int groupSize) {
        // create a tree map to store the frequency of each card value
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        // iterate over the keys of the tree map
        for (int card : map.keySet()) {
            // get the frequency of the current card value
            int count = map.get(card);
            // if the frequency is positive, try to form a group
            if (count > 0) {
                // check if there are enough cards to form a group of size groupSize
                for (int i = 1; i < groupSize; i++) {
                    // get the next card value
                    int next = card + i;
                    // get the frequency of the next card value
                    int nextCount = map.getOrDefault(next, 0);
                    // if the frequency is less than the current count, return false
                    if (nextCount < count) {
                        return false;
                    }
                    // reduce the frequency of the next card value by count
                    map.put(next, nextCount - count);
                }
            }
        }

        // if we reach here, we have formed all the groups successfully
        return true;
    }

    // Big O:

    // The time complexity of this solution is O(n log n), where n is the length of the hand array.
    // This is because we need to sort the array using a tree map and iterate over it once.

    // The space complexity is O(n), as we need to store the frequency of each card value
    // in a tree map.

}
