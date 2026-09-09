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
        intervals.sort((a,b)->Integer.compare(a.start, b.start));
        List<Integer> rooms = new ArrayList<>();
        if(intervals.size() == 0)
            return rooms.size();

        rooms.add(intervals.get(0).end);
        for(int i = 1; i < intervals.size(); i++) {
            int curr = intervals.get(i).start;
            boolean extra = true;
            for(int j = 0; j < rooms.size(); j++) {
                if(rooms.get(j) <= curr) {
                    extra = false;
                    rooms.remove(Integer.valueOf(rooms.get(j)));
                    rooms.add(intervals.get(i).end);
                    break;
                }
            }
            if(extra) {
                rooms.add(intervals.get(i).end);
            }
        }

        return rooms.size();
    }
}
