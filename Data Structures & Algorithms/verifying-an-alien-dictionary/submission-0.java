class Solution {

    Map<Character, Integer> map = new HashMap<>();

    public boolean isAlienSorted(String[] words, String order) {

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!check(words[i], words[i + 1])) {
                return false;
            }
        }

        return true;
    }

    public boolean check(String a, String b) {

        int len = Math.min(a.length(), b.length());

        for (int i = 0; i < len; i++) {

            int c1 = map.get(a.charAt(i));
            int c2 = map.get(b.charAt(i));

            if (c1 < c2) return true;
            if (c1 > c2) return false;
        }

        return a.length() <= b.length();
    }
}