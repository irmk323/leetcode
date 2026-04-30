import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] dailyTemperatures(int[] t) {
        int[] ans = new int[t.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i =0; i< t.length; i++){
            int curTem = t[i];
            while(!stack.isEmpty() && t[stack.peek()] < curTem ){
                int prev = stack.pop();
                ans[prev] = i-prev;
            }
            stack.push(i);
        }
        return ans;
    }
}