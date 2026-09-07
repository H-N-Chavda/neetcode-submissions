class Trie {
    Trie[] next = new Trie[26];
    boolean ends = false;
    Trie() {}
}

class Solution {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    Trie trie = new Trie();
    int m, n;

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        makeTrie(words);

        Set<String> res = new HashSet<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res.addAll(dfs(board, i, j, new boolean[m][n], trie, ""));
            }
        }
        return new ArrayList<>(res);
    }

    private Set<String> dfs(char[][] board, int r, int c, boolean[][] vis, Trie temp, String curr) {
        if(temp.next[board[r][c] - 'a'] == null)
            return new HashSet<>();
        
        Set<String> res = new HashSet<>();
        temp = temp.next[board[r][c] - 'a'];
        curr = curr + board[r][c];
        if(temp.ends == true)
            res.add(curr);

        vis[r][c] = true;
        for(int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc]) {
                res.addAll(dfs(board, nr, nc, vis, temp, curr));
            }
        }
        vis[r][c]  = false;
        return res;
    }

    private void makeTrie(String[] dict) {
        for(String word : dict) {
            Trie temp = trie;

            for(char ch : word.toCharArray()) {
                if(temp.next[ch-'a'] == null)
                    temp.next[ch-'a'] = new Trie();
                temp = temp.next[ch-'a'];
            }
            temp.ends = true;
        }
    }
}
