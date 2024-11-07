// Time N
// Space N
class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i< nums.length; i++){
            int cur =  nums[i];
            int complement = k -cur;
            if(map.getOrDefault(complement, 0) > 0){
                map.put(complement, map.get(complement) -1);
                count++;
            }else{
                map.put( cur, map.getOrDefault( cur, 0) + 1);
            }
        }
        return count;
    }
}