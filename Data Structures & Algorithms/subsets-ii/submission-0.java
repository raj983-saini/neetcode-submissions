class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
    List<Integer> sub = new ArrayList<>();
    Arrays.sort(nums);
    findSub(nums,0,sub,ans);
    return ans;
    }
    public void findSub(int[] nums,int i,List<Integer> sub,List<List<Integer>> ans){
        if(i >= nums.length){
             ans.add(new ArrayList<>(sub));
             return;
        }
        sub.add(nums[i]);
        findSub(nums,i+1,sub,ans);
        sub.remove(sub.size()-1);
         int nextIndex = i + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[i]) {
            nextIndex++;
        }
        findSub(nums,nextIndex,sub,ans);

    }
}
