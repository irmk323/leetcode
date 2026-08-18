class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone: stones){
            pq.add(stone);
        }
        int last = smashStone(pq);

        return last;
    }
    private int smashStone(PriorityQueue<Integer> pq){
        if (pq.size() == 0){
            return 0;
        }
        if (pq.size() == 1){
            return pq.poll();
        }
        int first = pq.poll();
        int second = pq.poll();
        if(first != second){
            pq.add(first - second);
        }

        return smashStone(pq);
    }
}

// but simple while is like 
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            if (first != second) {
                pq.offer(first - second);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}