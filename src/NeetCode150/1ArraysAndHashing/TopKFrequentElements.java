//// 2023/05/13 // 19:32 //

//// 347. Top K Frequent Elements // Medium //

// Given an integer array nums and an integer k, result the k most frequent
// elements. You may return the answer in any order.

// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

// Example 2:
// Input: nums = [1], k = 1
// Output: [1]

// Constraints:
// * 1 <= nums.length <= 10^5
// * -10^4 <= nums[i] <= 10^4
// * k is in the range [1, the number of unique elements in the array].
// * It is guaranteed that the answer is unique.

// Follow up: Your algorithm's time complexity must be better than O(n log n),
// where n is the array's size.

import java.util.*;

class TopKFrequentElements {

    // Explanation: The problem is to find the k most frequent elements in an array of integers.
    // One way to solve this problem is to use a hash map and a max heap. A hash map can store
    // the frequency of each element in the array in O(n) time, where n is the length of the array.
    // A max heap can store the elements and their frequencies in a way that the element with the
    // highest frequency is always at the top. By removing the top element of the heap k times,
    // we can get the k most frequent elements in O(k log d) time, where d is the number of
    // distinct elements in the array. The total time complexity of this approach is O(n + k log d),
    // which is better than O(n log n).

    public int[] topKFrequentHashMapMaxHeap(int[] nums, int k) {
        // Create a hash map to store the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Create a max heap to store the elements and their frequencies
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int key : map.keySet()) {
            heap.offer(new int[]{key, map.get(key)});
        }

        // Create an array to store the result
        int[] result = new int[k];

        // Remove the top element of the heap k times and add it to the result
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll()[0];
        }

        // Return the result
        return result;
    }

    // To make the solution quicker, we need to reduce the time complexity of the algorithm.
    // One possible way to do that is to use a quickselect algorithm instead of a max heap.
    // A quickselect algorithm can find the kth smallest element in an unsorted array in O(n)
    // averatge time and O(n2) worst-case time. By using a hash map to store the frequency of
    // each element and a quickselect algorithm to find the kth smallest frequency, we can get
    // the k most frequent elements in O(n) average time and O(n2) worst-case time. This is
    // faster than O(n + k log d) when k is large or d is small.

    public int[] topKFrequent(int[] nums, int k) {
        // create a hash map to store the frequency of each element
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // create an array to store the elements and their frequencies
        int[][] arr = new int[map.size()][2];
        int index = 0;
        for (int key : map.keySet()) {
            arr[index][0] = key;
            arr[index][1] = map.get(key);
            index++;
        }
        // use quickselect to find the kth smallest frequency in the array
        int kthFreq = quickselect(arr, 0, arr.length - 1, arr.length - k);
        // create a list to store the result
        List<Integer> list = new ArrayList<>();
        // add the elements that have frequency greater than or equal to the kth frequency to the list
        for (int[] pair : arr) {
            if (pair[1] >= kthFreq) {
                list.add(pair[0]);
            }
        }
        // convert the list to an array and return it
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    // helper method to perform quickselect on a 2D array
    private int quickselect(int[][] arr, int left, int right, int k) {
        // choose a random pivot element
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        int pivotFreq = arr[pivotIndex][1];
        // swap the pivot element with the rightmost element
        swap(arr, pivotIndex, right);
        // partition the array such that elements smaller than the pivot are on the left and larger on the right
        int partitionIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i][1] < pivotFreq) {
                swap(arr, i, partitionIndex);
                partitionIndex++;
            }
        }
        // swap the pivot element back to its correct position
        swap(arr, partitionIndex, right);
        // if the partition index is equal to k, we have found the kth smallest element
        if (partitionIndex == k) {
            return arr[partitionIndex][1];
        }
        // otherwise, recursively call quickselect on the left or right subarray depending on the value of k
        else if (partitionIndex < k) {
            return quickselect(arr, partitionIndex + 1, right, k);
        } else {
            return quickselect(arr, left, partitionIndex - 1, k);
        }
    }

    // helper method to swap two elements in a 2D array
    private void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




}












