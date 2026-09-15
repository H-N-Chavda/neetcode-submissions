class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> dire = new LinkedList<>();
        Queue<Integer> radi = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(senate.charAt(i) == 'R')
                radi.offer(i);
            else 
                dire.offer(i);
        }
        
        while(!dire.isEmpty() && !radi.isEmpty()) {
            int r_idx = radi.poll();
            int d_idx = dire.poll();
            if(r_idx < d_idx)
                radi.offer(r_idx + n);
            else 
                dire.offer(d_idx + n);
        }

        return dire.isEmpty() ? "Radiant" : "Dire";
    }
}