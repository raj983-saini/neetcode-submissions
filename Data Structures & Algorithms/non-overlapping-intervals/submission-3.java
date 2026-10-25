
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int previous = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (previous > currentStart) {
                count++;
            } else {
                previous = currentEnd;
            }
        }

        return count;
    }
}
