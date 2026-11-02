
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();

        Arrays.sort(hand);

        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        for (int i = 0; i < hand.length; i++) {

            int val = hand[i];

            if (map.get(val) == 0) {
                continue;
            }

            for (int j = 0; j < groupSize; j++) {

                int cur = val + j;

                if (map.getOrDefault(cur, 0) == 0) {
                    return false;
                }

                map.put(cur, map.get(cur) - 1);
            }
        }

        return true;
    }
}
