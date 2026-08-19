class Solution {
    public int maxArea(int[] heights) {
        int maxi = 0;
        int l = 0; int r = heights.length - 1;

        while(l < r) {
            int area = Math.min(heights[l], heights[r]) * (r-l);
            maxi = Math.max(maxi, area);

            if(heights[l] < heights[r])
                l++;
            else 
                r--;
        }

        return maxi;
    }
}
