/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
// Time O(N)
// Space(1)
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;
        // creating a copy node
        // e.g.  
        // A->B->C
        // A->A'->B->B'->C->C'
        while(cur != null){
            Node next = cur.next;
            cur.next = new Node(cur.val, next, null);
            cur = next;
        }

        cur = head; // reset the pointer to the head.
        while(cur != null){
            if(cur.random != null)

                // A->A'->B->B'->C->C'
                // This case setting A ramdom to A' random;
                cur.next.random = cur.random.next;
            // Otherwise just go to the next original node(not ' char )
            cur = cur.next.next;
        }

        cur = head; // reset the cur to the head again
        Node copyHead = head.next; // means A'
        while(cur != null){ 
            // making 
            // A->A'->B->B'->C->C'
            // to
            // A->B->C A'->B'->C'
            Node originalNext = cur.next.next; // without ' 
            Node copy = cur.next; // with '
            cur.next = originalNext;
            if(originalNext !=null){
                copy.next = originalNext.next; // linking to ' chars
            }
            cur = originalNext;
        }
        return copyHead;      
    }
}