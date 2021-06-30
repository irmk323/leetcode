class Solution {
    public int[] sortArray(int[] nums) {
        int res[] = new int[nums.length];
        if(nums == null || nums.length == 0) return res;
        mergeSort(nums, 0 , nums.length-1);
        return nums; 
    }
     private void mergeSort(int[] nums, int l, int r) {
         if(l >= r) return;
         int mid = l + (r -l)/2;
         mergeSort(nums, l, mid);
         mergeSort(nums, mid+1, r);
         merge(nums, l , r);
     }
    private void merge(int[] nums, int l, int r) {
        int mid = l + (r -l)/2;
        //start from 0 , so + 1
        int tmp[] = new int [r - l + 1 ];
        int i = l , j = mid + 1 , k = 0;
        while(i <= mid || j <= r){
            if (i > mid || j <= r && nums[i] > nums[j]) {
                tmp[k++] = nums[j++];
            } else {
                tmp[k++] = nums[i++];
            }
        }
        //System.arraycopy(元配列, 元開始位置, 新配列, 新開始位置, 長さ)　
        System.arraycopy(tmp , 0 , nums , l, r-l+1);
    }
}
