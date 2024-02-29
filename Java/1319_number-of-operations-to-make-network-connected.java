class Solution {
    private void dfs(int i,  Map<Integer, List<Integer>> adj, boolean[] visited){
        visited[i] = true;
        if(!adj.containsKey(i)){
            return ;
        }
        List<Integer> nodes = adj.get(i);
        for(int neighbor: nodes){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                dfs(neighbor, adj, visited);
            }
        }
    }


    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] connection: connections){
            adj.computeIfAbsent(connection[0], k -> new ArrayList<Integer>()).add(connection[1]);
            adj.computeIfAbsent(connection[1], k -> new ArrayList<Integer>()).add(connection[0]);
        }

        int numCount = 0;
        boolean[] visited = new boolean[n];
        for(int i= 0; i< n;i++){
            if(!visited[i]){
                numCount++;
                dfs(i,adj, visited);
            }
        }
        return numCount -1;
    }
}