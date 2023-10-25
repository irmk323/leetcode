class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }
        // [100,4,200,1,3,2]
        int max = 0;
        for(int num : numSet){
            if( !numSet.contains(num -1)){
                int curNum = num;
                int curLen = 1;
                while( numSet.contains(curNum +1)){
                    curLen ++;
                    curNum ++;
                }
                max = Math.max(max, curLen);
            }
            
        }
        return max;
    }
}