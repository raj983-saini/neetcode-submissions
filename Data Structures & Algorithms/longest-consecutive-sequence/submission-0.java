class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for(int a :nums) set.add(a);
        for(int aa:set){
            if(!set.contains(aa-1)){
            int length = 1;
            while(set.contains(aa+length)){
                length++;
            }
           longest = Math.max(length , longest);
            }   
        }
        return longest;
    }
}
