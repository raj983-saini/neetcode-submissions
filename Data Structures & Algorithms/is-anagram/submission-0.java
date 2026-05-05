class Solution {
    public boolean isAnagram(String s, String t) {
      if(s.length() != t.length()) return false;

      int []nums = new int[26];
      for(char ch:s.toCharArray()){
        nums[ch-'a']++;
      }    
       for(char ch:t.toCharArray()){
        nums[ch-'a']--;
        if(nums[ch-'a'] <0) return false;
      }   
      return true;
    }
}
