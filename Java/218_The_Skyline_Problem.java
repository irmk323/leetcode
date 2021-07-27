class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        Map<Integer, List<int[]>> cps = new TreeMap<>();
        for (int[] b : buildings) {
            cps.computeIfAbsent(b[0], (k) -> new ArrayList<int[]>()).add(b);
            cps.computeIfAbsent(b[1], (k) -> new ArrayList<int[]>()).add(b);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((b1, b2) -> Integer.compare(b2[2], b1[2]));
        List<List<Integer>> ret = new ArrayList<>();
        for (Integer x : cps.keySet()) {
            for (int[] b : cps.get(x)) {
                if (x == b[0]) {
                    pq.offer(b);
                } else {
                    pq.remove(b);
                }
            }
            if (pq.isEmpty()) {
                ret.add(Arrays.asList(x, 0));
            } else if (ret.isEmpty() || pq.peek()[2] != ret.get(ret.size() - 1).get(1)) {
                ret.add(Arrays.asList(x, pq.peek()[2]));
            }
        }
        return ret;
    }
}
