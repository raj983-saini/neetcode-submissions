class Solution {
    public long minEnd(int n, int x) {
        long result = x;
        long remaining = n - 1;
        int bit = 0;

        while (remaining > 0) {

            // Find next zero bit in x
            while ((x & (1L << bit)) != 0) {
                bit++;
            }

            // Put current bit of (n - 1) into that position
            if ((remaining & 1) != 0) {
                result |= (1L << bit);
            }

            remaining >>= 1;
            bit++;
        }

        return result;
    }
}