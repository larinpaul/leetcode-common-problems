//// 2023/05/26 // 9:46 //

//// 74. Search a 2D Matrix // Medium //

// You are given an m x n integer matrix matrix with the following two properties:
// * Each row is sorted in non-decreasing order.
// * The first integer of each row is greater than the last integer of the previous row.

// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

// Example 1:
// Image
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]],  target = 3
// Output: true

// Example 2:
// Image
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false

// Constraints:
// * m == matrix.length
// * n == matrix[].length
// * 1 <= m, n <= 100
// * -10^4 <= matrix[i][j], target <= 10^4

class SearchA2DMatrix {

    // Explanation: The matrix has two properties that can be used to search for the target efficiently.
    // First, each row is sorted in non-decreasing order, which means we can use a binary search
    // to find the target in each row. Second, the first element of each row is greater than the last element
    // of the previous row, which means we can use a binary search to find the row that contains the target.
    // Therefore, we can use two binary searches:
    // one to find the row and one to find the target in that row.

    // Solution: We define two functions: one to find the row that contains the target
    // and one to find the target in a given row.
    // Both functions use binary search algorithm, which works by comparing the middle element
    // of a sorted array with the target and narrowing down the search range based on the
    // comparison result. The function to find the row returns the index of the row that contains
    // the target or - 1 if no such row exists.
    // The function to find the target in a row returns true if the target is found
    // or false otherwise. The main function calls these two functions and returns their results.

    // Code:
    public boolean searchMatrix(int[][] matrix, int target) {
        // find the row that contains the target
        int row = findRow(matrix, target);
        // if no such row exists, return false
        if (row == -1) return false;
        // otherwise, find the target in that row
        return findTarget(matrix[row], target);
    }

    // helper function to find the row that contains the target using binary search
    private int findRow(int[][] matrix, int target) {
        // initialize low and high pointers
        int low = 0;
        int high = matrix.length - 1;
        // loop until low pointer is greater than high pointer
        while (low <= high) {
            // calculate mid pointer
            int mid = low + (high - low) / 2;
            // get the first and last elements of the mid row
            int first = matrix[mid][0];
            int last = matrix[mid][matrix[mid].length - 1];
            // if target is within the range of the mid row, return mid
            if (target >= first && target <= last) return mid;
            // if target is smaller than the first element of the mid row,
            // move high pointer to mid - 1
            else if (target < first) high = mid - 1;
            // if target is greater than the last element of the mid row,
            // move low pointer to mid + 1
            else low = mid + 1;
        }
        // if no such row is found, return -1
        return -1;
    }

    // helper function to find the target in a given row using binary search
    private boolean findTarget(int[] row, int target) {
        // initialize low and high pointers
        int low = 0;
        int high = row.length - 1;
        // loop until low pointer is greater than high pointer
        while (low <= high) {
            // calculate mid pointer
            int mid = low + (high - low) / 2;
            // get the element at the mid index
            int element = row[mid];
            // if element is equal to target, return true
            if (element == target) return true;
            // if element is smaller than target, move low pointer to mid + 1
            else if (element < target) low = mid + 1;
            // if element is greater than target, move high pointer to mid - 1
            else high = mid - 1;
        }
        // if no such element is found, return false
        return false;
    }

    // Big O:
    // The time complexity of this solution is O(log(m * n)), where m is the number of rows
    // and n is the number of columns in the matrix. This is because we perform two binary searches,
    // each talking O(log k) time, where k is the size of the array we are searching.
    // The first binary search takes O(log m) time as we are searching among m rows.
    // The second binary search takes O(log n) time as we are searching among n elements in a row.
    // Therefore, the total time complexity is O(log m + log n) = O(log(m * n)).
    // The space complexity of this solution is O(1),
    // as wqe do not use any extra space apart from some variables.

}
