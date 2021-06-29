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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return  generateTrees(1, n);     
    }
    private List<TreeNode> generateTrees(int start, int last) {
        List<TreeNode> roots = new ArrayList<>();
        if(start > last ){
            roots.add(null);
            return roots;
        }else{
            for(int i = start; i<= last; i++){
                List<TreeNode> leftSubtree =  generateTrees(start, i-1);
                List<TreeNode> rightSubtree =  generateTrees(i+1, last);
                
                for(TreeNode l :leftSubtree){
                    for(TreeNode r :rightSubtree){
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        roots.add(root);
                    }
                }
            }  
        }
        return roots; 
    }   
}
