class Solution {
    int[][] dirt = {{-1,0},{0,-1},{1,0},{0,1}};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<m;i++){
            dfs(0,i,board);
            dfs(n-1,i,board);
        }
         for(int i=0;i<n;i++){
            dfs(i,0,board);
            dfs(i,m-1,board);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
        
    }
    public void dfs(int i, int j, char[][] grid) {

        // boundary + stop conditions
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return;

        if (grid[i][j] != 'O') return;

        grid[i][j] = 'T';

        for (int[] dir : dirt) {
            dfs(i + dir[0], j + dir[1], grid);
        }
    }
}
