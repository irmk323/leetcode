// On the way

class Solution {
    public int heightChecker(int[] heights) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i< heights.length; i++){
            map.put(heights[i], map.getOrDefault(heights[i], 0) + 1);
        }
        
        System.out.println(map);
        
        int result = 0;
        List keys = new ArrayList(map.keySet());
        
        for (int i = 0, curHeight = 0 ; curHeight < heights.length ; curHeight++) {
            if(map.get((int)keys.get(i)) > 0) {
                if(heights[curHeight] != (int)keys.get(i)){
                    result++;
                }
                map.put((int)keys.get(i), map.get((int)keys.get(i)) - 1);    
            }else{
                i++;
            }
        }
        return result;
    }
}
