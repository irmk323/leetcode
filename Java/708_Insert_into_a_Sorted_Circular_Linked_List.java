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

class Solution {
    public Node insert(Node start, int x) {
        
        if (start == null) {
            Node node = new Node(x, null);
            node.next = node;
            return node;
        }
        
        Node cur = start;
        while (true) {
            if (cur.val < cur.next.val) { 
                if (cur.val <= x && x <= cur.next.val) { 
                    insertAfter(cur, x);
                    break;
                }
           
            } else if (cur.val > cur.next.val) { 
                if (cur.val <= x || x <= cur.next.val) { 
                    insertAfter(cur, x);
                    break;
                }
           
            } else {
                if (cur.next == start) {  
                    insertAfter(cur, x);
                    break;
                }
            }            
            cur = cur.next;
        }
        return start;
    }

    private void insertAfter(Node cur, int x) {
        cur.next = new Node(x, cur.next);
    }
}
