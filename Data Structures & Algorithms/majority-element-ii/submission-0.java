class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i] , map.getOrDefault(nums[i],0)+1);
            int val = map.get(nums[i]);
            if(val > nums.length/3){
                if(!ans.contains(nums[i])){
ans.add(nums[i]);
                }
                
            }
        }
        return ans;
    }
}