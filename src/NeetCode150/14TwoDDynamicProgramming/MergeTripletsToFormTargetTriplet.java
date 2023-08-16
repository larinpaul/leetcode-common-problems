//// 2023/08/16 // 10:59 //

//// 1899. Merge Triplets to Form Target Triplet // Medium //

// A triplet is an array of three integers. You are given a 2D integer array triplets, where
// triplets[i] = [ai, bi, ci] describes the ith triplet. You are also given an integer array
// target = [x, y, z] that describes the triplet you want to obtain.

// To obtain target, you may apply the following operation on triplets any number of times
// (possibly zero):
// * Choose two indices (0-indexed) i and j (i != j) and update triplets[j] to become
// max(ai, aj), max(bi, bj), max(ci, cj).
// ** For example, if triplets[i] = [2, 5, 3] and triplets[j] = [1, 7, 5],
//  triplets [j] will be updated to [max(2, 1), max(5, 7), max(3, 5)] = [2, 7, 5].

// Return true if it is possible to obtain the target triplet [x, y, z] as an element of triplets,
// or false otherwise.

// Example 1:
// Input: triplets = [[2,5,3],[1,8,4],[1,7,5]], target = [2,7,5]
// Output: true
// Explanation: Perform the following operations:
// - Choose the first and last triplets [[2,5,3],[1,8,4],[1,7,5]].
// Update the last triplet to be [max(2,1), max(5,7), max(3,5)] = [2,7,5].
// triplets = [[2,5,3],[1,8,4],[2,7,5]]
// The target triplet [2,7,5] is now an element of triplets.

// Example 2:
// Input: triplets = [[3,4,5],[4,5,6]], target = [3,2,5]
// Output: false
// Explanation: It is impossible to have [3,2,5] as an element because
// there is no 2 in any of the triplets.

// Example 3:
// Input: triplets = [[2,5,3],[2,3,4],[1,2,5],[5,2,3]], target = [5,5,5]
// Output: true
// Explanation: Perform the following operations:
// - Choose the first and third triplets [[2,5,3],[2,3,4],[1,2,5],[5,2,3]].
// Update the third triplet to be [max(2,1), max(5,2), ,ax)3,5)] = [2,5,5].
// triplets = [[2,5,3],[2,3,4],[2,5,5],[5,2,3]].
// - Choose the third and fourth triplets [[2,5,3],[2,3,4],[2,5,5],[5,2,3]].
// Update the fourth triplet to be [max(2,5), max(5,2), max(5,3)] = [5,5,5].
// triplets = [[2,5,3],[2,3,4],[2,5,5],[5,5,5]].
// The target triplet [5,5,5] is not an element of triplets.

// Constraints:
// * 1 <= triplets.length <= 10^5
// * triplets[i].length == target.length == 3
// * 1 <= ai, bi, ci, x, y, z <= 1000


class MergetTripletsToFormTargetTriplet {

    // This problem is about finding out if it is possible to obtain a
    // target triplet from a given array of triplets by applying a certain operation. The
    // operation involves choosing two different triplets and updating one of them by taking
    // the maximum of each element. For example, if you have [2, 5, 3] and [1, 7, 5], you can
    // update the second one to [2, 7, 5] by taking the max of each pair.

    // To solve this problem, you need to think about what conditions must be satisfied for
    // the target triplet to be obtainable. One obvious condition is that each element of the
    // target triplet must be present in at least one of the given triplets. For example, if the
    // target is [3, 2, 5], and none of the given triplets has a 2, then it is impossible to obtain
    // the target.

    // Another condition is that each element of the target triplet must not be smaller than
    // any other element in the same position of any given triplet. For example, if the target
    // is [2, 7, 5], and one of the given triplets is [3, 4 ,5], then it is impossible to obtain the
    // target because you cannot make the first element smaller by taking the max.

    // Therefore, a possible solution is to iterate through all the given triplets and check if
    // they satisfy these two conditions. If they do, we mark them as valid triplets. Then we
    // check if there exists at least one valid triplet for each element of the target triplet. If
    // there does, we return true. Otherwise, we return false.

    // Code in Java:
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        // create an array to store the valid triplets
        boolean[] valid = new boolean[triplets.length];
        // iterate through all the given triplets
        for (int i = 0; i < triplets.length; i++) {
            // check if the current triplet satisfies the two conditions
            if (triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]) {
                // mark as valid
                valid[i] = true;
            }
        }
        // create an array to store the existence of valid triplets for
        // each element of the target triplet
        boolean[] exist = new boolean[3];
        // iterate through all the valid triplets
        for (int i = 0; i < valid.length; i++) {
            if (valid[i]) {
                // check if they have the same element as the target triplet in each position
                if (triplets[i][0] == target[0]) exist[0] = true;
                if (triplets[i][1] == target[1]) exist[1] = true;
                if (triplets[i][2] == target[2]) exist[2] = true;
            }
        }
        // return true if all three elements exist in some valid triplet
        return exist[0] && exist[1] && exist[2];
    }

    // Big O:

    // The time complexity of this solution is O(n),
    // where n is the number of triplets in the input array.

    // The space complexity is O(n),
    // where n is also the number of triplets in the input array.

}
