class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length=0;
        Set<Character> chars= new HashSet<>();
        int left=0;
        for(int right=0;right<s.length();right++){
            if(!chars.contains(s.charAt(right))){
                chars.add(s.charAt(right));
                length = Math.max(length,right-left+1);
            }
            else{
                while(chars.contains(s.charAt(right))){
                   chars.remove(s.charAt(left));
                   left++;
                }
                 chars.add(s.charAt(right));
            }
        }
        return length;
    }
}