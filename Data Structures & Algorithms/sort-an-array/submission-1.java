class Solution {
    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length-1);
        return nums;
    }

    private void divide(int[] nums, int left, int right) {
        if(left < right) {
            int mid = left + (right - left)/2;

            divide(nums, left, mid);
            divide(nums, mid + 1, right);
            conquer(nums, left, mid, right);
        }
    }

    private void conquer(int nums[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i = 0; i < n1; i++) 
            left[i] = nums[i+l];
        for(int i = 0; i < n2; i++) 
            right[i] = nums[i+m+1];

        int i = 0; int j = 0;
        int k = l; 

        while(i < n1 && j < n2) {
            if(left[i] <= right[j]) {
                nums[k++] = left[i++];
            } else {
                nums[k++] = right[j++];
            }
        }

        while(i < n1) {
            nums[k++] = left[i++];
        }
        while(j < n2) {
            nums[k++] = right[j++];
        }
    }
}