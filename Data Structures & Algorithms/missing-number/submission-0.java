class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int b =0;
        for(int i=0;i<n;i++){
            b = b ^ i;
            b = b^nums[i];
        }
        b = b^n;
        return b;
    }
}
