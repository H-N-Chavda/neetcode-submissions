class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        dfs(matrix, 0, 0, 0, 1);
        return res;
    }

    private void dfs(int[][] matrix, int x, int y, int idx, int dir) {
        res.add(matrix[x][y]);
        int rows = matrix.length, cols = matrix[0].length;
        if (dir == 1) { // 1 stands for left to right
            if (y + idx < cols - 1)
                dfs(matrix, x, y + 1, idx, dir);
            else if (x + idx < rows - 1)
                dfs(matrix, x + 1, y, idx, 2);
        } else if (dir == 2) { // 2 stands for top to bottom 
            if (x + idx < rows - 1)
                dfs(matrix, x + 1, y, idx, dir);
            else if (y - idx >= 1)
                dfs(matrix, x, y - 1, idx, -1);
        } else if (dir == -1) { // -1 stands for right to left
            if (y - idx >= 1)
                dfs(matrix, x, y - 1, idx, dir);
            else if (x - idx >= 2)
                dfs(matrix, x - 1, y, idx, -2);
        } else if (dir == -2) { // -2 stands sfor bottom to top
            if (x - idx >= 2)
                dfs(matrix, x - 1, y, idx, dir);
            else if (y + idx + 1 < cols - 1)
                dfs(matrix, x, y + 1, idx + 1, 1);
        }
    }
}
