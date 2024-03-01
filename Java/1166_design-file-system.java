class FileSystem {
    class TrieNode {
        String name;
        int val = -1;
        Map<String, TrieNode> map = new HashMap<>();

        TrieNode(String name){
            this.name = name;
        }
    }
    TrieNode root;

    public FileSystem() {
        this.root = new TrieNode("");
    }
    
    public boolean createPath(String path, int value) {
        TrieNode cur = traversePath(path, true);
        if(cur == null) {
            return false;
        }
        cur.val = value;
        return true;
    }
    
    public int get(String path) {
        TrieNode cur = traversePath(path, false);
        return (cur != null) ? cur.val : -1;
    }

    private TrieNode traversePath(String path, boolean createPath){
        String[] comps = path.split("/");

        TrieNode cur = root;
        for(int i = 1; i< comps.length; i++){
            String curStr = comps[i];
            if (!cur.map.containsKey(curStr)){
                if( createPath && i == comps.length -1 ){
                    cur.map.put(curStr, new TrieNode(curStr));
                }else{
                    return null;
                }
            }
            cur = cur.map.get(curStr);
        }
        return cur;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */