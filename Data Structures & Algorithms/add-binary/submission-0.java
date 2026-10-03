class Solution {
    public String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        StringBuilder ss = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {

            int aa = 0;
            int bb = 0;

            if (i >= 0) {
                aa = a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                bb = b.charAt(j) - '0';
                j--;
            }

            int sum = aa + bb + carry;

            int bit = sum % 2;
            carry = sum / 2;

            ss.append(bit);
        }

        return ss.reverse().toString();
    }
}