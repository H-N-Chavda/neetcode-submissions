class Solution {
    public int[][] insert(int[][] intervals, int[] curr) {
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;

        int i = 0;
        while(i < n && intervals[i][1] < curr[0]) {
            res.add(intervals[i]);
            i++;
        }

        int start = curr[0];
        int end = curr[1];
        while(i < n && end >= intervals[i][0]) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res.add(new int[]{start, end});

        while(i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
