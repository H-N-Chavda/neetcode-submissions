class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->a[0]-b[0]);

        PriorityQueue<long[]> avail = new PriorityQueue<>(
            (a,b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        for(int i = 0; i < n; i++) {
            avail.offer(new long[]{0, i});
        }
        int[] count = new int[n];

        for(int[] meet : meetings) {
            int start = meet[0], end = meet[1];
            while(!avail.isEmpty() && avail.peek()[0] < start) {
                long[] earliest = avail.poll();
                avail.offer(new long[]{start, earliest[1]});
            }

            long[] room = avail.poll();
            long endTime = room[0] + (meet[1] - meet[0]);
            avail.offer(new long[]{endTime, room[1]});
            count[(int) room[1]]++;
        }

        int maxi = 0;
        for(int i = 1; i < n; i++) {
            if(count[i] > count[maxi])
                maxi = i;
        }

        return maxi;
    }
}