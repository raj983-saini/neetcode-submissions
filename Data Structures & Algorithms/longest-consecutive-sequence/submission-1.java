class Solution {
    public int longestConsecutive(int[] nums) {
      Set<Integer> set = new HashSet<>();
      int max =0;
      int cnt = 1;
      for(int n:nums){
        set.add(n);
      }
      for(int i =0;i<nums.length;i++){
        int l = nums[i]-1;
        while(set.contains(l)){
            cnt++;
            l--;
        }
        max = Math.max(cnt,max);
        cnt=1;
      }
      return max;
    }
}
