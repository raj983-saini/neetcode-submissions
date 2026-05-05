

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Max heap: sort by value descending
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < n; i++) {
            // Add current element (value, index)
            pq.offer(new int[]{nums[i], i});

            // Remove elements outside the window
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }

            // Store the max for windows that have reached size k
            if (i >= k - 1) {
                result[i - k + 1] = pq.peek()[0];
            }
        }

        return result;
    }
}
