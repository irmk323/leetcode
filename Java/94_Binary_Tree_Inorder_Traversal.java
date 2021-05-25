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
    public List<Integer> inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        dfs(root, res);
        return res;
    }
    private void dfs(TreeNode root, List<Integer> list){
        if(root != null){
            if(root.left != null){
               dfs(root.left, list);
            }
            list.add(root.val);
            if(root.right != null){
                dfs(root.right, list);
            }
        }
        
        
    }
}
