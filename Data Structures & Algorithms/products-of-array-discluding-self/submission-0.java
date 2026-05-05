class Solution {
    public int[] productExceptSelf(int[] nums) {
        int sum =1;
        int prifex[] = new int[nums.length];
        int sufiex[] = new int[nums.length];
        int ans[] = new int[nums.length];
    for(int i=0;i<nums.length;i++){
      prifex[i] = sum;
      sum = nums[i]*sum;
    }
    sum = 1;
      for(int i=nums.length-1;i>=0;i--){
      sufiex[i] = sum;
      sum = nums[i]*sum;
    }
    for(int i=0;i<nums.length;i++){
       ans[i] = prifex[i]*sufiex[i];
    }
    return ans;

    }
}  
