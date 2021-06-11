
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
   public void selialize(TreeNode root, ArrayList<Integer> array){
        if(root == null){
            array.add(-1);
            return;
        }
        array.add(-1);
        selialize(root.left, array);
        selialize(root.right, array);
        return;
    }
    
    int index = 0;
    public TreeNode deselialize(ArrayList<Integer> array){
        if(index == array.size() ||  array.get(index) == -1){
            index += 1;
            return null;
        }
        TreeNode root = new TreeNode(array.get(index));
        index += 1;
        root.left = deselialize(array);
        root.right = deselialize(array);
        return root;
    }    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
