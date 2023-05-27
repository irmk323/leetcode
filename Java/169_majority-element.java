class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int num : nums){
            if (!counts.containsKey(num)){
                counts.put(num, 1);
            }else{
                counts.put(num, counts.get(num) + 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry: counts.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value > nums.length /2 ) {
                return key;
            }
        }
        return -1;
    }
}