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
    public TreeNode buildTree_rec(int[] inorder, int i1, int i2 ,int[] postorder, int p1, int p2) {
        if(i1 >= i2 || p1 >= p2) return null;
        TreeNode root = new TreeNode(postorder[p2 - 1]);
        int it = 0;
        for(int i = i1; i < i2; i++){
            if(postorder[p2-1] == inorder[i]){
                it =i;
                break;
            }
        }
            int diff = it - i1;
            root.left = buildTree_rec(inorder, i1,  i1 + diff , postorder, p1,  p1+ diff);
            root.right = buildTree_rec(inorder, i1 + diff + 1,  i2 , postorder, p1+ diff,  p2-1);
        return root;
        
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
       if(n == 0){
           return null;
       }
        return buildTree_rec(inorder, 0, n , postorder, 0, n);
    }
}
