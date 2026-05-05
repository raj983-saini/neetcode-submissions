class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (subRoot == null) return true;   // empty tree is subtree
        if (root == null) return false;

        if (root.val == subRoot.val && check(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) 
            || isSubtree(root.right, subRoot);
    }

    public boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;

        return check(root.left, subRoot.left) 
            && check(root.right, subRoot.right); 
    }
}
