class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) ->
            Integer.compare(a[0], b[0])
        );

        int m = queries.length;
        int[] output = new int[m];

        // Store queries as {queryValue, originalIndex}
        int[][] sortedQueries = new int[m][2];

        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) ->
            Integer.compare(a[0], b[0])
        );

        // Store {intervalLength, rightEnd}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int i = 0;

        for (int[] query : sortedQueries) {
            int q = query[0];
            int index = query[1];

            // Add intervals that have started
            while (i < intervals.length &&
                   intervals[i][0] <= q) {
                int left = intervals[i][0];
                int right = intervals[i][1];
                int length = right - left + 1;

                minHeap.offer(new int[]{length, right});
                i++;
            }

            // Remove intervals that no longer cover q
            while (!minHeap.isEmpty() &&
                   minHeap.peek()[1] < q) {
                minHeap.poll();
            }

            // The shortest valid interval is at the top
            if (minHeap.isEmpty()) {
                output[index] = -1;
            } else {
                output[index] = minHeap.peek()[0];
            }
        }

        return output;
    }
}
