class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ss = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;

            int remainder = columnNumber % 26;
            char ch = (char) ('A' + remainder);

            ss.append(ch);

            columnNumber /= 26;
        }

        return ss.reverse().toString();
    }
}