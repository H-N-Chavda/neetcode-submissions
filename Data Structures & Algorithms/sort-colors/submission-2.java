class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0; int right = n - 1;
        int idx = 0;
        while(idx < n && left < right) {
            if(nums[idx] == 0) {
                int temp = nums[left];
                nums[left] = nums[idx];
                nums[idx] = temp;
                left++;
            } else if(nums[idx] == 2) {
                int temp = nums[right];
                nums[right] = nums[idx];
                nums[idx] = temp;
                right--;
            }
            if(nums[idx] == 1 || idx == left - 1)
                idx++;
            if(idx == right + 1)
                break;
        }
        return ;
    }
}