class Solution {
    public int counter = 0;
    public int totalNQueens(int n) {
        char[][] curr = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(curr[i], '0');
        }

        dfs(n, 0, curr);
        return counter;
    }

    private void dfs(int n, int idx, char[][] curr) {
        if(idx == n) {
            counter++;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(curr[idx][i] != '.') {
                // Place the queen
                curr[idx][i] = 'Q';
                // Remove all attackable pos
                List<int[]> changes = new ArrayList<>();
                changes.add(new int[]{idx, i});
                int count = 1;
                for(int j = idx + 1; j < n; j++) {
                    if(curr[j][i] == '0') {
                        curr[j][i] = '.';
                        changes.add(new int[]{j, i});
                    }
                    if(i + count < n && curr[j][i + count] == '0') {
                       curr[j][i + count] = '.';
                       changes.add(new int[]{j, i + count});
                    }
                    if(i - count >= 0 && curr[j][i - count] == '0') {
                        curr[j][i - count] = '.';
                        changes.add(new int[]{j, i - count});
                    }
                    count++;
                }

                // Recursive call
                dfs(n, idx + 1, curr);

                // Revert back those changes
                for(int[] change : changes) 
                    curr[change[0]][change[1]] = '0';
            } 
        }
    }
}
