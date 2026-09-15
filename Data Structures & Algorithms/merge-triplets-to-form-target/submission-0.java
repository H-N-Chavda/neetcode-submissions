class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] poss = new boolean[3];
        for(int[] trip : triplets) {
            if(trip[0] <= target[0] && trip[1] <= target[1] && trip[2] <= target[2]) {
                if(trip[0] == target[0])
                    poss[0] = true;
                if(trip[1] == target[1])
                    poss[1] = true;
                if(trip[2] == target[2])
                    poss[2] = true;
            }
        }

        return poss[0] && poss[1] && poss[2];
    }
}
