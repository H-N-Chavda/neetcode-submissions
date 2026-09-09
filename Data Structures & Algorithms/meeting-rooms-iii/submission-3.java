class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);

        int[] rooms = new int[n];
        int[] ends = new int[n];
        
        for(int[] meet : meetings) {
            int mini = Integer.MAX_VALUE;
            int idx = -1;
            for(int i = 0; i < n; i++) {
                if(ends[i] <= meet[0]) {
                    mini = ends[i];
                    idx = i;
                    break;
                } else if(ends[i] < mini) {
                    mini = ends[i];
                    idx = i;
                }
            }
            if(ends[idx] <= meet[0]) {
                ends[idx] = meet[1];
            } else {
                ends[idx] += (meet[1] - meet[0]);
            }
            rooms[idx]++;
        }

        int mini = -1;
        int idx = 0;
        for(int i = 0; i < n; i++) {
            if(rooms[i] > mini) {
                mini = rooms[i];
                idx = i;
            }
            System.out.print(ends[i] + " ");
        }

        return idx;
    }
}