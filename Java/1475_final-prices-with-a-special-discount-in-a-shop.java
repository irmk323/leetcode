import java.util.Deque;

class Solution {
    public int[] finalPrices(int[] prices) {
        int[] res = prices.clone();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i< prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]){
                res[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        return res;

    }
}