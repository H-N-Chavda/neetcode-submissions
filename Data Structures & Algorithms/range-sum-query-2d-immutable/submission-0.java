class NumMatrix {

    int[][] sums;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sums = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int left = 0, top = 0, top_left = 0;
                if(i > 0)
                    top = sums[i-1][j];
                if(j > 0)
                    left = sums[i][j-1];
                if(i > 0 && j > 0)
                    top_left = sums[i-1][j-1];

                sums[i][j] = matrix[i][j] + left + top - top_left;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = sums[row2][col2];
        if(row1 > 0)
            ans -= sums[row1-1][col2];
        if(col1 > 0)
            ans -= sums[row2][col1-1];
        if(row1 > 0 && col1 > 0)
            ans += sums[row1-1][col1-1];

        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */