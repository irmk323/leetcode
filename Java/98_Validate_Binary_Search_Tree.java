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
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null); 
    }
    private boolean valid(TreeNode root, Integer l, Integer h) {
        if(root == null) return true;
        
        if(( l != null && root.val >= l) || ( h != null && root.val <= h)) return false;
        return valid(root.left, root.val , h ) && valid(root.right,  l,root.val );
    }
}
