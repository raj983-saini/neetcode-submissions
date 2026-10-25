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
    public boolean canAttendMeetings(List<Interval> intervals) {

        if(intervals.isEmpty()){
            return true;
        }
        intervals.sort((a, b) -> Integer.compare(a.end, b.end));
        Interval first = intervals.get(0);
        int previous = first.end;
        for(int i=1;i<intervals.size();i++){
            Interval curr = intervals.get(i);
            int currStart = curr.start;
            int currEnd = curr.end;
            if(previous > currStart){
                return false;
            }else{
                previous = currEnd;
            }
        }
        return true;
    }
}
