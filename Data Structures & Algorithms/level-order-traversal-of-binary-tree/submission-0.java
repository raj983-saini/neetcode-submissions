/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        return bfs(root,res);
    }
    public List<List<Integer>> bfs(TreeNode root,List<List<Integer>> res){
        if(root ==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for(int s=0;s<size;s++){
                TreeNode pol = queue.poll();
                currentLevel.add(pol.val);
                if(pol.left!=null) queue.offer(pol.left);
                if(pol.right!=null) queue.offer(pol.right);
            }
            res.add(currentLevel);
        }
return res;
    }
}
