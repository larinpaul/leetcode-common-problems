//// 2023/06/17 //  //

//// 73. Set Matrix Zeroes // Medium //

// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to
// 0's.

// You must do it in place.

// Example 1:
// Picture
// Input: matrix = [[1,1,1,],[1,0,1],[1,1,1]
// Output: [[1,0,1],[0,0,0],[1,0,1]]

// Example 2:
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,4]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

// Constraints:
// * m == matrix.length
// * n == matrix[0].length
// 1 <= m, n <= 200
// * -2^31 <= matrix[i][j] <= 2^32 - 1

// Follow up:
// * A straightforward solution using O(mn) space is probably a bad idea.
// * A simple improvement uses O(m + n) space, but still not the best solution.
// * Could you devise a constant space solution?

class SetMatrixZeroes {

    // Solution:
    // TO set the entire row and column to 0's for each element that is 0, we need to
    // keep track of which rows and columns have 0's. One way to do this is to use the first tow
    // and the first column as markers. If matrix[i][j] is 0, we set matrix[i][0] and matrix[0][j] to 0.
    // This way, we can scan the first row and column later and know which rows and columns to set to 0.
    // However, we also need to be careful not to overwrite the original values of the first
    // row and column. We can use two boolean variables to store whether the first row and
    // column have 0's originally, and update them accordingly. Then, we can start from the
    // second row and column, and set the elements to 0 if their corresponding marker is 0.
    // Finally, we can use the boolean variables to set the first row and column to 0 if needed.

    // Explanation:
    // The main idea is to use constant space to store the information of which rows
    // and columns have 0's. By using the first row and column as markers, we can avoid using
    // extra space. However, we also need to handle the edge case of the first row and column
    // separately, since they might be overwritten by the markers. The algorithm works as follows:

    // 1. Initialize two boolean variables, firstRowZero and firstColZero, to false.
    // 2. Loop through the matrix, and for each element that is 0, do the following:
    // * Set matrix[i][0] and matrix[0][j] to 0.
    // * If i == 0, set firstRowZero to true.
    // * If j == 0, set firstColZero to true.
    // 3. Loop through the matrix from the second row and column, and for each element that
    // has a 0 in its corresponding marker, set it to 0.
    // 4. If firstRowZero is true, loop through the first row and set all elements to 0.
    // 5. If firstColZero is true, loop through the first column and set all elements to 0.

    // Code:
    public void setZeroes(int[][] matrix) {
        // Check if the matrix is empty or invalid
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        // Initialize two boolean variables to store if the first row and column have 0's
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Loop through the matrix and mark the rows and columns that have 0's
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // If the element is 0, set its corresponding marker to 0
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    // Update the boolean variables if it is in the first row or column

                    if (i == 0) {
                        firstRowZero = true;
                    }
                    if (j == 0) {
                        firstColZero = true;
                    }
                }
            }
        }

        // Loop through teh matrix from the second row and column and set the elements to 0
        // if their marker is 0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                // If either of the markers is 0, set the element to 0
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set the first row and column to 0 if needed
        if (firstRowZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    // Big O:
    // The time complexity of this algorithm is O(mn), where m is the number of rows and n
    // is the number of columns in the matrix. This is because we need to loop through each
    // element in the matrix twice. The space complexity of this algorithm is O(1), since we only
    // use constant extra space for the boolean variables and the markers.

}
