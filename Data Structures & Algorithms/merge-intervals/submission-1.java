class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] curr : intervals) {
            if(curr[0] > end) {
                res.add(new int[]{start, end});
                start = curr[0];
                end = curr[1];
            } else {
                start = Math.min(start, curr[0]);
                end = Math.max(end, curr[1]);
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}
