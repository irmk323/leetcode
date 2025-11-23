// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< A.length; i++){
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
        }
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(e.getValue() == 1){
                return e.getKey();
            }
        }
        return -1;
    }
}