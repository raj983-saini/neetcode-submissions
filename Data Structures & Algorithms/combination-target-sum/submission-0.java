class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        findComb(nums,0,0,target,cur,ans);
        return ans;
    }
    public void findComb(int[] nums,int i,int sum,int target,List<Integer> cur,List<List<Integer>> ans){
        if(sum==target){
            ans.add(new ArrayList<>(cur));
            return;
        }
        if (sum > target || i == nums.length) { // FIX 3
            return;
        }
        cur.add(nums[i]);
        sum += nums[i];
        findComb(nums,i,sum,target,cur,ans);
        cur.remove(cur.size() - 1);
        sum -= nums[i];
        findComb(nums,i+1,sum,target,cur,ans);
    }
}
