class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        //TreeMapを使うのはソートのため。
        Map<Integer, List<int[]>> cps = new TreeMap<>();
        for (int[] b : buildings) {
            // 指定されたキーがまだ値に関連付けられていない(またはnullにマップされている)場合、
            // 指定されたマッピング関数を使用してその値の計算を試行し、nullでない場合はそれをこのマップに入力します
            cps.computeIfAbsent(b[0], (k) -> new ArrayList<int[]>()).add(b);
            cps.computeIfAbsent(b[1], (k) -> new ArrayList<int[]>()).add(b);
        }
        
        /*
        PriorityQueue<int[]> pq = new PriorityQueue<>((b1, b2) -> Integer.compare(b2[2], b1[2]));
        Integer.compare    
                 パラメータ:
        x - 比較する最初のint
        y - 比較する2番目のint
        戻り値:
        x == yの場合は値0、x < yの場合は0より小さい値、x> yの場合は0より大きい値
        */
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((b1, b2) -> Integer.compare(b2[2], b1[2]));
        List<List<Integer>> ret = new ArrayList<>();
        for (Integer x : cps.keySet()) {
            for (int[] b : cps.get(x)) {
                if (x == b[0]) {
                    pq.add(b);
                    System.out.println("aaa");
                    for(int i = 0; i < pq.size(); i++){
                    System.out.println(pq.peek()[i]);                       
                    }
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
