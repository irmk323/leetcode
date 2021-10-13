/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/
// Time O(N) Space(1)

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null ){
            Node newNode = new Node(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }
        
        Node cur = head;
        while(true){
            if(cur.val < cur.next.val){
                if(cur.val <= insertVal && insertVal <= cur.next.val){
                    insertAfter(cur , insertVal);
                    break;
                }
                
            }else if(cur.val > cur.next.val){
                  if(cur.val <= insertVal || insertVal <= cur.next.val){
                    insertAfter(cur , insertVal);
                    break;
                }   
            }else{
                if(cur.next == head){
                    insertAfter(cur , insertVal);
                    break;
                }
            }
            cur = cur.next;
        }
        return head;   
    }
    private void insertAfter(Node cur, int x){
        cur.next = new Node(x, cur.next);
    }
}
