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

//  “35823985298(-12345)(12)"
//  [35823985298,-12345,12]
// Time O(n)
// Space O(n)
class Solution {
    public TreeNode str2tree(String s) {

        if(s.length() == 0){
            return null;
        }
        TreeNode output = new TreeNode();
        Tokenizer t = new Tokenizer(s);
        List<Integer> token;
        // List<List<int>> levels = new ArrayList<ArrayList<>>();
        // "4(2(3)(1))(6(5))"
        // [[4], [2,6], [3,1,5]] => [4,2,6....]
        // 4((3)(1))(6(5)) invalid

        Stack<TreeNode> stack = new Stack<TreeNode>();
        token = t.pop();
        output.val = token.get(1);
        stack.push(output);

        while((token = t.pop()).size() > 0){
            TreeNode curNode = stack.peek();

            switch(token.get(0)) {
            case 1:
                token = t.pop();
                TreeNode newNode = new TreeNode(token.get(1));
                if (curNode.left == null){
                    curNode.left = newNode;
                }
                else{
                    curNode.right = newNode;
                }
                stack.push(newNode);
                break;
            case 2:
                stack.pop();
            }
        } 
        return output;
    }
}


class Tokenizer{
    String s;
    int index;
    Tokenizer(String s){
        this.s = s;
        this.index=0;
    }

    public List<Integer> pop(){
        if( index >= s.length() ){
            return new ArrayList<>(Arrays.asList());
        }
        if (s.charAt(index) == '(' ){
            index++;
            return new ArrayList<>(Arrays.asList(1));
        }
        if (s.charAt(index) == ')'){
            index++;
            return new ArrayList<>(Arrays.asList(2));
        }
        int startIndex = index;
        while (index < s.length() && s.charAt(index) != '(' && s.charAt(index) != ')' ){
            index++;
        }
        return new ArrayList<>(Arrays.asList(0, Integer.parseInt(s.substring(startIndex, index))));
    }
}