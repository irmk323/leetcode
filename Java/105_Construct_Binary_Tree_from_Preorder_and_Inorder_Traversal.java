class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length -1 ;
        if(preorder.length!=inorder.length) return null;
        return buildTree_rec(preorder, 0 , preorder.length -1  , inorder , 0, inorder.length -1);
    }
    
    public TreeNode buildTree_rec(int[] preorder, int p1 , int p2, int[] inorder , int i1 , int i2) {
        if(p1 > p2 || i1 > i2) return null;
        TreeNode root = new TreeNode(preorder[p1]);
        
        int it = i1;
        for(int i = i1; i <= i2; i++){
            if(inorder[i]==root.val){ it = i; break;  }

        }
        int diff = it - i1;
        root.left = buildTree_rec(preorder, p1 + 1, p1 + diff, inorder,i1, it - 1);
        root.right = buildTree_rec(preorder, p1 + diff +1, p2 , inorder, it+1 , i2);
        return root;
        
    }
}
