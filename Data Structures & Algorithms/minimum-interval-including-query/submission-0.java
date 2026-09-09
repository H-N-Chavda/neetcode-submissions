class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, 
        (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[][] queriesIdx = new int[queries.length][2];
        for(int j = 0; j < queries.length; j++) {
            queriesIdx[j][0] = queries[j];
            queriesIdx[j][1] = j;
        }
        Arrays.sort(queriesIdx, (a,b) -> a[0] - b[0]);

        int[] res = new int[queries.length];
        int i = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for(int[] curr : queriesIdx) {
            int query = curr[0];
            while(i < intervals.length && query >= intervals[i][0]) {
                int size = intervals[i][1] - intervals[i][0] + 1;
                pq.offer(new int[]{intervals[i][1], size});
                i++;
            }

            while(!pq.isEmpty() && pq.peek()[0] < query) {
                pq.poll();
            }
            res[curr[1]] = pq.isEmpty() ? -1 : pq.peek()[1];
        }

        return res;
    }
}
