class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        find(nums,new boolean[nums.length],res,ans);
        return ans;
    }
    public void find(int[] nums,boolean[] visit,List<Integer> cur ,List<List<Integer>> ans){
        if(cur.size() == nums.length){
            ans.add(new ArrayList<>(cur));
             return;
        }
        for(int i =0;i<nums.length;i++){
            if(visit[i]) continue;
            visit[i] =true;
            cur.add(nums[i]);
            find(nums,visit,cur,ans);
            cur.remove(cur.size()-1);
            visit[i]=false;
        }
        
    }
}
