class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }
        List<Integer> list = new ArrayList<>(freqMap.keySet());
        int[] keyList = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(keyList);
        int oneLeft = 0; int twoLeft = 0;
        for(int i =0; i <keyList.length; i++ ){
            int curVal = keyList[i] * freqMap.get(keyList[i]);
            int temp = oneLeft;
            if(i > 0 && keyList[i] == keyList[i-1]+1){
                oneLeft = Math.max(curVal + twoLeft, oneLeft);
                
            }else{
                oneLeft+= curVal;
            }
            twoLeft = temp;
        }
        return oneLeft;
    }
}