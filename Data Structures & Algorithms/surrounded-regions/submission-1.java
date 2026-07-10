class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Mark all boundary-connected O's as safe
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);

            if (board[i][n - 1] == 'O')
                dfs(board, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j);

            if (board[m - 1][j] == 'O')
                dfs(board, m - 1, j);
        }

        // Flip surrounded O's to X and restore safe O's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '#';

        for (int[] d : dir) {
            dfs(board, i + d[0], j + d[1]);
        }
    }
}