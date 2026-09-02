class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int m = grid.length; int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0)
                    q.add(new int[]{i, j});
            }
        }

        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();
                
                for(int[] dir : dirs) {
                    int nx = curr[0] + dir[0];
                    int ny = curr[1] + dir[1];
                    if(nx >= 0 && nx < m &&
                    ny >= 0 && ny < n &&
                    grid[nx][ny] != -1 && 
                    grid[nx][ny] == Integer.MAX_VALUE) {
                        
                        grid[nx][ny] = count + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }

            count++;
        }

        return;
    }
}
