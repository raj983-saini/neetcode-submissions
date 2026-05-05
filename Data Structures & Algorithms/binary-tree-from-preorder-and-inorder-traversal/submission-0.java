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
    int index =0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
     return   help(preorder ,inorder , 0 , inorder.length-1);
    }
    public TreeNode help(int[] preorder, int[] inorder , int start ,int end){
        if(start > end) return null;

        TreeNode root = new TreeNode(preorder[index++]);
        int ind = find(inorder , start ,end , root.val);

        root.left =help(preorder , inorder , start ,ind-1);
        root.right=help(preorder , inorder , ind+1 ,end);
        return root;
    }
    public int find(int[] inorder , int start , int end , int val){
        for(int s=start ;s<=end;s++){
            if(inorder[s] == val) return s;
        }
        return -1;
    }
}
