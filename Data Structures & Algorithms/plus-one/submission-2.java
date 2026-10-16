

class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> ans = new ArrayList<>();
        int car = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i];

            if (val < 9 || car == 0) {
                ans.add(val + car);
                car = 0;
            } else {
                ans.add(0);
            }
        }

        if (car == 1) {
            ans.add(1);
        }

        Collections.reverse(ans);

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}
