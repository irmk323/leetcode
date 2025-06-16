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

 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null );
        
    }
    private boolean isBST(TreeNode root,Integer min, Integer max ){
        if(root == null){
            return true;
        }
        // while checking left, root.val is always max,
        // any left node should be less than max
        if ( (max != null && max <= root.val )

      // while checking right, root.val is always min,
        // any right node should be more than min
             || ( min!= null && root.val <= min)){
            return false;
        }
        return isBST(root.left, min, root.val ) 
        // doesn't care how much the right node can be bigger
        // just care nodes are more than min = root.val for right
        && isBST(root.right, root.val , max );
    }
}