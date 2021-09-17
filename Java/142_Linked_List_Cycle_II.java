/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Time O(n)
// Space O(1)
public class Solution {
     public ListNode intersection(ListNode head) {
         ListNode slow = head;
         ListNode fast = head;
         while(fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
             if(slow ==fast ) return slow;
         }
         return null;      
    }
    
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null ) return null;
        ListNode intersec = intersection(head);
        if(intersec == null) return null;
        ListNode start = head;
        
        while(intersec != start){
            start = start.next;
            intersec = intersec.next;
        }
        return start;
    }
}



// Use hashset version
// Time O(n) and Space O(n) 

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();
        
        ListNode node = head;
        while(node != null){
            if(visited.contains(node)){
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        return null;
    }
}
