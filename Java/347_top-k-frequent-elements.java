class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      for(int num : nums){
        map.put(num, map.getOrDefault(num, 0) +1);
      }
      PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = 
      new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
      for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        maxHeap.add(entry);
      }

      List<Integer> res = new ArrayList<>();
      while(res.size() < k){
        Map.Entry<Integer, Integer> entry = maxHeap.poll();
        res.add(entry.getKey());
      }

      return res.stream().mapToInt(Integer::intValue).toArray();
    }
}