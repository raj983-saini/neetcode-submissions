class Solution {
      private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()) return ans;
        find(0,ans,digits,"");
        return ans; 
    }
    public void find(int i , List<String> ans, String digits,String res){
        if(res.length() >= digits.length()){
            ans.add(res);
            return;
        }
        String chars = digitToChar[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            find(i + 1, ans ,digits ,res + c);
        }


    }
}
