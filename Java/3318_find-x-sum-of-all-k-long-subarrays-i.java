import java.util.Map;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int ansLen = nums.length - k +1;
        int left = 0;
        int[] ans = new int[ansLen];
        while(left < ansLen){
            Map<Integer,Integer> freqMap = createMap(nums, left, k);
            PriorityQueue<Map.Entry<Integer, Integer>> pq =
                    new PriorityQueue<>((a, b) -> {
                        int cmp = b.getValue() - a.getValue(); // value 降順
                        if (cmp != 0) return cmp;
                        return b.getKey() - a.getKey(); // value同じなら key 昇順
                    });
            pq.addAll(freqMap.entrySet());

            int calcPq = calPqSum(pq, x);
            ans[left] = calcPq;
            left++;
        }
        return ans;

    }
    private int calPqSum(PriorityQueue<Map.Entry<Integer, Integer>> pq,int x){
        int sum = 0;
        while( 0< pq.size() && x > 0){
            Map.Entry<Integer, Integer> map = pq.poll();
            sum += map.getKey() * map.getValue();
            x--;
        }
        return sum;

    }
    private Map<Integer,Integer> createMap(int[] nums, int left, int k){
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int i = left; i< left + k; i++){
            if(!freqMap.containsKey(nums[i])){
                freqMap.put(nums[i], 1);
            }else{
                freqMap.put(nums[i], freqMap.get(nums[i])+1 );
            }
        }
        System.out.println(freqMap);
        return freqMap;
    }
}