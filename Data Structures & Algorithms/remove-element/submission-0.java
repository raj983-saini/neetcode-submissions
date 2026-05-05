class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
       for(int i =0;i<nums.length;i++){
       int temp = nums[i];
       nums[i]  =nums[j];
       nums[j] = temp; 
        
       if(nums[j] !=val){
       j++;
       }}
       return j;
    }
}