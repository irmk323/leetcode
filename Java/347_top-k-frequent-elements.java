class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){ map.put(num, map.getOrDefault(num, 0) + 1); }
        
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(int key : map.keySet()){ heap.add(key); }
        
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ans.add(heap.poll());
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();        
    }
}

//
bucketsort ( M* N)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        // make a bucket for freq;
        List<List<Integer>> bucket = new ArrayList<>();
        for(int i=0; i<= nums.length; i++){
            bucket.add(new ArrayList<>());
        }

        // add freq into bucket
        for(int n : map.keySet()){
            int num = map.get(n);
            bucket.get(num).add(n);
        }

        int[] result = new int[k];
        int index =0;
        for(int i = nums.length; i >= 1; i--){
            for(int n: bucket.get(i)){
                result[index++] = n;
                if(index == k){
                    return result;
                }
            }
        }
        return result;

        
    }
}