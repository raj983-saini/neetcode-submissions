
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
           for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 1: Reverse each row
        for (int[] arr : matrix) {
            int low = 0;
            int high = n - 1;

            while (low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;

                low++;
                high--;
            }
        }

        // Step 2: Transpose the matrix
     
    }
}
