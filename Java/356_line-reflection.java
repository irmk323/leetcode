class Solution {
    public boolean isReflected(int[][] points) {
        HashMap<Integer, Set<Integer>> map = new HashMap();
        Integer max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int[] p : points) {
            if(!map.containsKey(p[1])) map.put(p[1], new HashSet());
            map.get(p[1]).add(p[0]);
            max = Math.max(max, p[0]);
            min = Math.min(min, p[0]);
        } 
        int mid = min + max;
        for(Set<Integer> xs : map.values()){
            for(int x : xs) if(!xs.contains(mid - x)) return false;
        }
        return true;
    }
    }