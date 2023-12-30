class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int maxRank = 0;
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int[] road : roads){
            adj.computeIfAbsent(road[0], k-> new HashSet<>()).add(road[1]);
            adj.computeIfAbsent(road[1], k-> new HashSet<>()).add(road[0]);
        }

        for(int n1= 0; n1< n; n1++){
            for(int n2= n1+1; n2< n; n2++){
                Set<Integer> empty = Collections.emptySet();
                int currentRank =
                 adj.getOrDefault(n1, empty).size() +
                 adj.getOrDefault(n2, empty).size();
                if (adj.getOrDefault(n1, empty).contains(n2)) {
                    --currentRank;
                }
                maxRank = Math.max(maxRank, currentRank);
            }
        }
        return maxRank;
    }
}