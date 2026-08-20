class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int mid = l + (r-l)/2;
            System.out.println(l + " " + r);
            if(nums[mid] == target)
                return mid;
                
            if(nums[l] < target && target < nums[mid])
                r = mid - 1;
            else if(nums[l] <= nums[mid] && nums[mid] < target)
                l = mid + 1;
            else if(nums[mid] < target && target < nums[l])
                l = mid + 1;
            else if(target < nums[mid] && nums[mid] < nums[l])
                r = mid - 1;
            else if(target < nums[l] && nums[l] <= nums[mid])
                l = mid + 1;
            else 
                r = mid - 1;

        }

        return nums[l] == target ? l : -1;
    }
}
