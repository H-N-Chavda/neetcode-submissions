class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        boolean[][] dist = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                dist[i][j] = GCD(nums[i], nums[j]) > 1;
                dist[j][i] = dist[i][j];
            }
        }

        for(int k = 0; k < n; k++) { 
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(dist[i][k] && dist[k][j])
                        dist[i][j] = true;
                }
            }
        }

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(!dist[i][j])
                    return false;

        return true;
    }

    private int GCD(int a, int b) {
        if(b == 0)
            return a;
        return GCD(b, a%b);
    }
}