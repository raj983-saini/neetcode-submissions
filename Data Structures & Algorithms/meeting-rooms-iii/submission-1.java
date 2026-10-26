

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) ->
            Integer.compare(a[0], b[0])
        );

        long[] endTimes = new long[n];
        int[] count = new int[n];

        for (int[] meet : meetings) {
            long meetStart = meet[0];
            long meetEnd = meet[1];
            long duration = meetEnd - meetStart;

            int room = -1;

            // Find the lowest-numbered available room
            for (int i = 0; i < n; i++) {
                if (endTimes[i] <= meetStart) {
                    room = i;
                    break;
                }
            }

            if (room != -1) {
                endTimes[room] = meetEnd;
            } else {
                // Find the room that becomes free earliest
                room = 0;

                for (int i = 1; i < n; i++) {
                    if (endTimes[i] < endTimes[room]) {
                        room = i;
                    }
                }

                // Delay the meeting, preserving its duration
                endTimes[room] += duration;
            }

            count[room]++;
        }

        int answer = 0;

        for (int i = 1; i < n; i++) {
            if (count[i] > count[answer]) {
                answer = i;
            }
        }

        return answer;
    }
}
