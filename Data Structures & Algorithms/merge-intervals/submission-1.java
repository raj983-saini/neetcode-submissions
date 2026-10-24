

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) ->
            Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (ans.isEmpty()) {
                ans.add(new int[]{currentStart, currentEnd});
            } else {
                int[] previous = ans.get(ans.size() - 1);

                if (currentStart <= previous[1]) {
                    previous[1] = Math.max(previous[1], currentEnd);
                } else {
                    ans.add(new int[]{currentStart, currentEnd});
                }
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
