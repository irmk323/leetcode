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
        List<List<Integer>> result = new ArrayList();
        if(root == null ){
            return result;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList();
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                level.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}

//DFS version
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        helper(lists, root, 0);
        return lists;
    }
    public void helper(List<List<Integer>>lists, TreeNode root , int height){
        if(root == null) return;
        if(height == lists.size()){
            lists.add(new ArrayList<>());
        }
        lists.get(height).add(root.val);
        helper(lists, root.left, height+1);
        helper(lists, root.right, height+1);
    }
}
