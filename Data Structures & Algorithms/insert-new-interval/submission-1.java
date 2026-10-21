

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n1 = newInterval[0];
        int n2 = newInterval[1];

        boolean merge = false;
        List<int[]> arr = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (currentEnd < n1) {
                // Case 1: Current interval is before newInterval
                arr.add(new int[]{currentStart, currentEnd});
            }
            else if (currentStart > n2) {
                // Case 2: Current interval is after newInterval
                if (!merge) {
                    arr.add(new int[]{n1, n2});
                    merge = true;
                }

                arr.add(new int[]{currentStart, currentEnd});
            }
            else {
                // Case 3: Intervals overlap
                n1 = Math.min(n1, currentStart);
                n2 = Math.max(n2, currentEnd);
            }
        }

        // If the merged interval hasn't been inserted yet
        if (!merge) {
            arr.add(new int[]{n1, n2});
        }

        return arr.toArray(new int[arr.size()][]);
    }
}

