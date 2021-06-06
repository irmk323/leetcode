/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node leftNode = root;
        while(leftNode != null & leftNode.left != null){
            populateLeftNode(leftNode);
                leftNode = leftNode.left;
        }
        return root;
    }
    private void populateLeftNode(Node startNode){
        Node iter = startNode;
        while(iter != null){
            iter.left.next = iter.right;
            if(iter.next != null){
                iter.right.next = iter.next.left;
            }
            iter = iter.next;
        }
    }
}
