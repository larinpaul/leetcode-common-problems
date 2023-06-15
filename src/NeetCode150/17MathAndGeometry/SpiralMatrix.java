//// 2023/06/15 // 19:09 //

//// 54. Spiral Matrix // Medium //

// Given an m x n matrix, return all elements of the matrix in spiral order.

// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]

// Example 2:
// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,13]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]

// Constraints:
// * m == matrix.length
// * n == matrix[i].length
// * 1 <= m, n <= 10
// * -100 <= matrix[i][j] <= 100

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {

    // Solution:
    // The idea is to use four variables to keep track of the boundaries of the sub-matrix
    // that we need to traverse in spiral order. We start from the top-left corner and move right
    // until we reach the right boundary. Then we move down until we reach the bottom boundary.
    // Then we move left until we reach the left boundary. Then we move up until we reach the
    // top boundary. We repeat this process until we have visited all the elements in the matrix.

    public List<Integer> spiralOrder(int[][] matrix) {
        // Initialize an empty list to store the output
        List<Integer> output = new ArrayList<>();

        // Check if the matrix is empty or null
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return output; // Return the empty list
        }

        // Get the number of rows and columns of the matrix
        int m = matrix.length;
        int n = matrix[0].length;

        // Initialize four variables to keep track of the boundaries of the sub-matrix
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        // Loop until the boundaries are valid
        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top boundary
            for (int j = left; j <= right; j++) {
                output.add(matrix[top][j]); // Add the element to the output list
            }
            top++; // Update the top boundary to avoid repeating elements

            // Traverse from top to bottom along the right boundary
            for (int i = top; i <= bottom; i++) {
                output.add(matrix[i][right]); // Add the element to the output list
            }
            right--; // Update the right boundary to avoid repeating elements

            // Check if the bottom boundary is still valid
            if (top <= bottom) {
                // Traverse from right to left along the bottom boundary
                for (int j = right; j >= left; j--) {
                    output.add(matrix[bottom][j]); // Add the element to the output list
                }
                bottom--; // Update the bottom boundary to avoid repeating elements
            }

            // Check if the left boundary is still valid
            if (left <= right) {
                // Traverse from bottom to top along the left boundary
                for (int i = bottom; i >= top; i--) {
                    output.add(matrix[i][left]); // Add the element to the output list
                }
                left++; // Update the left boundary to avoid repeating elements
            }
        }

        return output; // Return the final output list
    }

    // Big O:

    // The time complexity of this solution is O(m,n), where m is the number of rows and n
    // is the number of columns of the matrix. This is because we visit each element in the matrix
    // exactly once. The space complexity of this solution is O(mn), where m and n are as defined
    // above. This is because we store all the elements in the output list. If we don't count the
    // output list as extra space, then the space complexity is O(1), since we only use constant
    // extra variables.

}






