class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findComb(candidates, 0, 0, target, new ArrayList<>(), ans);
        return ans;
    }

    public void findComb(int[] nums, int i, int sum, int target,
                         List<Integer> cur, List<List<Integer>> ans) {

        if (sum == target) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        if (sum > target || i == nums.length) {
            return;
        }

        // ✅ PICK nums[i]
        cur.add(nums[i]);
        findComb(nums, i + 1, sum + nums[i], target, cur, ans);
        cur.remove(cur.size() - 1);

        // ✅ SKIP DUPLICATES BEFORE NOT-PICK
        int nextIndex = i + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[i]) {
            nextIndex++;
        }

        // ❌ NOT PICK nums[i] and its duplicates
        findComb(nums, nextIndex, sum, target, cur, ans);
    }
}
