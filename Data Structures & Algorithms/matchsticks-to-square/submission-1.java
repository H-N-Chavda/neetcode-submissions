class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int match : matchsticks)
            sum += match;
        if(sum % 4 != 0) 
           return false;
        int target = sum / 4;

        Arrays.sort(matchsticks);
        int[] sides = new int[4];

        return dfs(matchsticks, sides, matchsticks.length - 1, target);
    }

    private boolean dfs(int[] match, int[] sides, int idx, int target) {
        if(idx < 0) 
            return sides[0] == target && sides[1] == target && sides[2] == target;

        for(int i = 0; i < 4; i++) {
            if(match[idx] + sides[i] > target)
                continue;

            boolean dup = false;
            for(int j = 0; j < i; j++)
                if(sides[i] == sides[j]) {dup = true; break;}

            if(dup) continue;

            sides[i] += match[idx];
            if(dfs(match, sides, idx - 1, target))
                return true;
            sides[i] -= match[idx];

            if(sides[i] == 0)
                break;
        }

        return false;
    }
}