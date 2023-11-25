class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : arr ){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(freqMap.values());
        while( 0 < k){
            k -= pq.poll();
        }
        return k < 0 ? pq.size()+ 1 : pq.size() ;
    }
}