/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int q_val = q.val;
        int p_val = p.val;

        TreeNode node = root;
        while(node != null){
            if ( q_val <node.val && p_val <node.val ){
                node = node.left;
            }else if ( q_val > node.val && p_val > node.val ){
                node = node.right;
            }else{
                return node;
            }
        }
    return node;
    }
}