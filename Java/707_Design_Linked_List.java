//=============== Double Linked List====================
public class ListNode{
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int x) { val = x;}
}
class MyLinkedList {
    int size;
    ListNode head, tail;
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int index) {
        if(index < 0 || index >= size ) return -1;
        ListNode curr = head;
        if(index + 1 < size - index)
            for(int i = 0; i< index + 1 ; ++i) curr = curr.next;
        else{
            curr = tail;
            for(int i = 0; i< size - index ; ++i) curr = curr.prev;
        }
        return curr.val;
        
    }
    
    public void addAtHead(int val) {
        ListNode pred = head, succ = head.next;
        ++size;
        ListNode toAdd = new ListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
        
    }
    
    public void addAtTail(int val) {
        ListNode succ = tail, pred = tail.prev;
        ++size;
        ListNode toAdd = new ListNode(val);
        toAdd.prev= pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
        
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index < 0) index = 0;
        ListNode pred, succ;
        if(index < size - index){
            pred = head;
            for(int i = 0; i < index; i++) pred = pred.next;
            succ = pred.next;
        }else{
            succ = tail;
            for(int i = 0; i < size - index; i++) succ = succ.prev;
            pred = succ.prev;
        }
        ++size;
        ListNode toAdd = new ListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
            
        
    }
    
    public void deleteAtIndex(int index) {
    
    if (index < 0 || index >= size) return;

    ListNode pred, succ;
    if (index < size - index) {
      pred = head;
      for(int i = 0; i < index; ++i) pred = pred.next;
      succ = pred.next.next;
    }
    else {
      succ = tail;
      for (int i = 0; i < size - index - 1; ++i) succ = succ.prev;
      pred = succ.prev.prev;
    }

    --size;
    pred.next = succ;
    succ.prev = pred;
  }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */


//===============Single Linked List====================
// Time O(1) for addHead, O(N) for addTail O(K) for other ones.
// Space O(1)

public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}

}
class MyLinkedList {
    int size;
    ListNode head;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        ListNode curr = head;
        for(int i = 0; i< index+ 1; i++){
            curr = curr.next;
        }
        return curr.val;
        
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0 , val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size , val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index < 0) index = 0;
        size++;
        ListNode pred = head;
        for(int i = 0; i< index ; i++){
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        size--;
        ListNode pred = head;
        for(int i = 0; i< index ; i++){
            pred = pred.next;
        }
        pred.next = pred.next.next;
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
