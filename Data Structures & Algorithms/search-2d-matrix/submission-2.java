class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = (matrix.length*matrix[0].length)-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int row = mid/matrix[0].length; int col = mid%matrix[0].length;           
            if(target > matrix[row][col]){
                low = mid+1;
            }
            else if(target < matrix[row][col]){
                high = mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
