class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> ansList = new ArrayList<>();
        ansList.add(nums[0]);
        // [10,9,2,5,3,7,101,18]
        for(int i = 1; i< nums.length; i++ ){
            int num = nums[i];
            if(num > ansList.get(ansList.size() -1)){
                ansList.add(nums[i]);
            }else{
                int elem = binarySearch(ansList, num);
                ansList.set(elem, num);
            }
        }
        return ansList.size();

    }
    private int binarySearch(List<Integer> ansList,int num){
        int left = 0, right = ansList.size() -1;
        while(left <= right){
            // [1,2,5,7,9] need to find 5
            int mid = (left + right) /2;
            if(ansList.get(mid) < num){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return left;
    }
}