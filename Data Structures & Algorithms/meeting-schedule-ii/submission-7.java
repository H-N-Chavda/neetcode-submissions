/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(Interval curr : intervals) {
            map.put(curr.start, map.getOrDefault(curr.start, 0) + 1);
            map.put(curr.end, map.getOrDefault(curr.end, 0) - 1);
        }

        int curr = 0;
        int maxi = 0;
        for(int key : map.keySet()) {
            curr += map.get(key);
            maxi = Math.max(maxi, curr);
        }

        return maxi;
    }
}
