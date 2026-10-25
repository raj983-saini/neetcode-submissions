class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return 0;
        }

        intervals.sort((a, b) ->
            Integer.compare(a.start, b.start)
        );

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Interval curr : intervals) {
            // Reuse a room if its meeting has ended
            if (!minHeap.isEmpty() &&
                minHeap.peek() <= curr.start) {
                minHeap.poll();
            }

            // Allocate a room for the current meeting
            minHeap.offer(curr.end);
        }

        return minHeap.size();
    }
}
