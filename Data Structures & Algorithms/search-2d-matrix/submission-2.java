class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;

        int top = 0;
        int bot = m-1;
        while(top <= bot) {
            int mid = top + (bot-top)/2;
            if(mat[mid][0] > target)
                bot = mid-1;
            else if(mat[mid][0] < target)
                top = mid + 1;
            else 
                return true;
        }
        if(bot < 0) return false;
        
        int l = 0;
        int r = n - 1;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(mat[bot][mid] > target)
                r = mid - 1;
            else if(mat[bot][mid] < target)
                l = mid + 1;
            else 
                return true;
        }

        return false;
    }
}
