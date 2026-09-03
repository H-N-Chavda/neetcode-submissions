class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        Queue<int[]> pacq = new LinkedList<>();
        Queue<int[]> atlq = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            pacq.offer(new int[]{i, 0});
            atlq.offer(new int[]{i, n-1});
        }
        for(int i = 0; i < n; i++) {
            pacq.offer(new int[]{0, i});
            atlq.offer(new int[]{m-1, i});
        }

        bfs(pacq, pac, heights);
        bfs(atlq, atl, heights);

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pac[i][j] && atl[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }

        return res;
    }

    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights) {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0]; int y = curr[1];
            ocean[x][y] = true;

            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx >= 0 && nx < heights.length &&
                ny >= 0 && ny < heights[0].length &&
                !ocean[nx][ny] && heights[nx][ny] >= heights[x][y]) {
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
