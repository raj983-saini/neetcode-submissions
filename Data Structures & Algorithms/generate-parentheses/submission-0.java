class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        gen(n, 0, 0, new StringBuilder(), ans);
        return ans;
    }

    private void gen(int n, int open, int close,
                     StringBuilder sb, List<String> ans) {

        // base condition
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }

        // add '(' if we still can
        if (open < n) {
            sb.append('(');
            gen(n, open + 1, close, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }

        // add ')' only if valid
        if (close < open) {
            sb.append(')');
            gen(n, open, close + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
