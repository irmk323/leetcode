class Node{
    public String url;
    public Node prev;
    public Node next;
    public Node(String url){
        this.url = url;
        prev = null;
        next = null;
    }
}
class BrowserHistory {
    private Node head;
    private Node cur;

    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        cur = head;
    }
    
    public void visit(String url) {
        Node newNode = new Node(url);
        cur.next = newNode;
        newNode.prev = cur;
        cur = newNode;
    }
    
    public String back(int steps) {
        while(steps > 0 && cur.prev != null){
            cur = cur.prev;
            steps--;
        }
        return cur.url;
        
    }
    
    public String forward(int steps) {
        while(steps > 0 && cur.next != null){
            cur = cur.next;
            steps--;
        }
        return cur.url;        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */