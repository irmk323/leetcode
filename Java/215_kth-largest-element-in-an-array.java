// Time : O(Nlogk)
// Space: O(k)
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

// LTE ...!!!
// Time : O(n) (worst case O(n^2)
// Space: O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
      k = nums.length - k;
      return quickSort(nums, 0,nums.length -1,  k);
    }
    public int quickSort(int[]nums, int left, int right,  int k){
      int pivot = nums[right];
      int pointer  = left;
      for(int i = left; i < right; i++){
        if(nums[i] <= pivot){
          swap(nums, pointer, i);
          pointer++;
        }
      }
      swap(nums, right, pointer);
      if (pointer > k ){
        return quickSort(nums, left, pointer -1, k);
      }else if (pointer < k ){
        return quickSort(nums, pointer+1, right, k);
      }else{
        return nums[pointer];
      }
    }
    public void swap(int[] nums, int i, int j){
      int temp = nums[i];
      nums[i] =nums[j];
      nums[j] = temp;
    }
}

// Time : O(n + m) m is range of max and min
// Space: O(n)
// effective when the constraint is  -10^4 <= nums[i] <= 10^4
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num: nums){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int len = max -min +1; // taking the range of min and max
        int[] count = new int[len];

        for(int num: nums){
            count[num -min]++; 
        }
        int remain = k;
        for(int i = count.length -1; i>= 0; i-- ){
            remain -= count[i];
            if (remain <= 0){
                return i + min; // add offset value.
            }
        }
        return -1;        
    }
}