package codility;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int X, int[] A) {
        int sum = X *(X +1) /2;
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i< A.length; i++){
            if(!visited.contains(A[i])){
                sum -= A[i];
                visited.add(A[i]);
                if(sum == 0){
                    return i;
                }
            }
        }
        return -1;
    }
}