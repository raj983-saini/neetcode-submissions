class Solution {
    public int majorityElement(int[] nums) {
        int max = 0;
        int maxVal = nums[0];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            int local = map.get(nums[i]);
            if(max<local){
                maxVal = nums[i];
                max = local;
            }
        }
        if(max>nums.length/2){
            return maxVal;
        }
        return -1;
    }
}