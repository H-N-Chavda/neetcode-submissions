class Solution {
    boolean[][] vis;
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        vis = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(board, i, j, 1, word))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int x, int y, int idx, String word) {
        if(idx == word.length())
            return true;

        vis[x][y] = true;
        for(int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == word.charAt(idx) && !vis[nx][ny]) {
                if(dfs(board, nx, ny, idx + 1, word))
                    return true;
            }
        }

        vis[x][y] = false;
        return false;
    }
}
