class NumMatrix {
    int [][]prifix;

    public NumMatrix(int[][] matrix) {
        prifix = new int[matrix.length][matrix[0].length];
        for(int i =0;i<matrix.length;i++){
            prifix[i][0] = matrix[i][0];
            for(int j=1;j<matrix[0].length;j++){
            prifix[i][j] = prifix[i][j-1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res =0;
        for(int row = row1;row<=row2;row++){
            if(col1>0){
                res += prifix[row][col2]-prifix[row][col1-1];
            }else{
                res += prifix[row][col2];
            }
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */