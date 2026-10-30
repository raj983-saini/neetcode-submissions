class Solution {
    public boolean canJump(int[] nums) {
        int max=0;
        int jump=0;
        for(int i=0 ;i<nums.length-1;i++){
            int cur = nums[i];
            max = Math.max(cur,max);
            if(max == 0){
                return false;
            }
            max--;
        }
        return true;
    }
}
