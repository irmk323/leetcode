class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        createGraph(bombs, graph);
        int max = 0;
        for(int i = 0; i< bombs.length; i++){
            max = Math.max(max, dfs(i, new HashSet<>(), graph ));
        }
        return max;    
    }
    private int dfs(int cur, Set<Integer> visited, Map<Integer, List<Integer>> graph  ){
        visited.add(cur);
        int count = 1;
        for(int neib : graph.getOrDefault(cur, new ArrayList<>())){
            if(!visited.contains(neib)){
                 count += dfs(neib, visited, graph);
            }
        }
        return count;
    }

    private boolean isWithInRadius(int i, int j , int[][] bombs){
        long x1 = bombs[i][0] , y1 = bombs[i][1], r1 = bombs[i][2];
        long x2 = bombs[j][0] , y2 = bombs[j][1];
        return r1 * r1 >= (x1 - x2) *(x1 - x2) + (y1 - y2)*  (y1 - y2);
    }

    private void createGraph(int[][] bombs,Map<Integer, List<Integer>> graph ){
        for(int i = 0; i< bombs.length; i++){
            for(int j = 0; j< bombs.length; j++){
                if(i == j ) continue;
                if(isWithInRadius(i, j , bombs)){
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
    }
}