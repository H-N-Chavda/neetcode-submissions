class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = 0;
        for(int num : nums) {
            l = Math.max(l, num);
            r += num;
        }

        int res = -1;
        while(l <= r) {
            int mid = l + (r-l)/2;

            if(count(nums, mid) <= k) {
                res = mid;
                r = mid - 1;
            } else 
                l = mid + 1;
        }

        return res;
    }

    private int count(int[] nums, int mid) {
        int sum = 0;
        int ans = 0;
        for(int num : nums) {
            if(sum + num > mid) {
                sum = num;
                ans++;
            } else 
                sum += num;
        }
        
        return sum > 0 ? ans + 1 : ans;
    }
}