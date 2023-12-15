class Solution {
    public int deleteAndEarn(int[] nums) {
       Map<Integer, Integer> freqMap = new HashMap<>();
       for(int num : nums){
           freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
       }
       List<Integer> list= new ArrayList(freqMap.keySet());
       int[] keylist = list.stream().mapToInt(Integer::intValue).toArray();
       Arrays.sort(keylist);
       int earn1 = 0 , earn2 = 0;
        for(int i = 0; i< keylist.length; i++ ){
            int curEarn = keylist[i] * freqMap.get(keylist[i]);
            if(i > 0 && keylist[i] == keylist[i-1] +1 ){
                int temp = earn2;
                earn2 = Math.max(curEarn + earn1, earn2 );
                earn1 = temp;
            }else{
                 int temp = earn2;
                 earn2 = curEarn + earn2;
                 earn1 = temp;
            }
        } 
        return earn2;    
    }
}