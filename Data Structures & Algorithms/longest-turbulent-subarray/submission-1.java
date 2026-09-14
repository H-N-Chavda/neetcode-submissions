class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) return 1;

        int maxi = 1;
        int curr = 1;
        int prevComp = 0; // -1 for <, 1 for >, 0 for =

        for (int i = 1; i < arr.length; i++) {
            int currComp = Integer.compare(arr[i], arr[i - 1]);

            if (currComp == 0) {
                curr = 1;
            } else if (currComp == -prevComp) {
                curr++;
            } else {
                curr = 2;
            }

            prevComp = currComp;
            maxi = Math.max(maxi, curr);
        }

        return maxi;
    }
}