class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
            if (pq.size() > k){
                pq.remove();
            }
        }
        return pq.peek();
    }
}

// [3,2,1,5,6,4]
// 2
// 56