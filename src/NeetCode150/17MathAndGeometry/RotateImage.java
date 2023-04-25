//// 2023/04/25 // 22:02 //

//// 48. Rotate Image // Medium //

// You are given an x*x 2D matrix representing an image,
// rotate the image by 90 degrees (clockwise).

// You have to rotate the image in-place, which means you have to modify
// the input 2D matrix directly.
// DO NOT allocate another 2D matrix and do the rotation.

// Example 1:

// 123    741
// 456 => 852
// 789    963

// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1][8,5,2][9,6,3]]

// Example 2:

// 5  1  8  11     15 13  2  5
// 2  4  8  10 --\ 14  3  4  1
// 13 3  6  7  --/ 12  6  8  9
// 15 14 12 16     16  7 10 11

// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output:"[[15,13,2,5][14,3,4,1],[12,6,8,9],[16,7,10,11]]

// Constraints:
// n == matrix.length == matrix[i].length
// 1 <= n <= 20
// -1000 <= matrix[i][j] <= 1000

class RotateImage {
    public void rotate(int[][] matrix) {
        // The idea is to transpose the matrix first, then reverse each row
        // Transposing means swapping the elements at (i, j) and (j, i) for all i and j
        // Reversing each row means swapping the elements at (i, j) and (i, n - 1 - j) for all i and j
        // This way, the matrix is rotated by 90 degrees clockwise in place

        int n = matrix.length; // The size of the matrix

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                // Swap matrix[i][j] and matrix[i][n - 1 - j]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
    // To explain this solution in detail, let's take an example:
    // Input: matrix = [[1,2,3][4,5,6],[7,8,9]]
    // Output: [[7,4,1],[8,5,2],[9,6,3]]

    // The first step is to transpose the matrix. This means swapping the elements at (i,j) and (j,i)
    // for all i and j. For example, we swap matrix0 and matrix[1][0], which are 2 and 4 respectively.
    // We do this for all pairs of indices where i < j. After this step, the matrix becomes:

    // [[1,4,7],[2,5,8],[3,6,9]]

    // This is the final output.

    // To calculate the time complexity of this solution, we need to count how many operations we
    // perform on the matrix. In the first step, we loop through half of the elements in the matrix, so
    // we do O(n^2 / 2) swaps. In the second step, we loop through half of each row in the matrix,
    // so we do O(n * n / 2) swaps. Therefore, the total time complexity is O(N^2), where n is the
    // size of the matrix.










