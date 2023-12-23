class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid: asteroids){
            while(!stack.isEmpty() && stack.peek() > 0 &&  0 > asteroid){
                int diff = asteroid + stack.peek();
                if(diff < 0){
                    stack.pop();
                }else if(diff > 0){
                    asteroid = 0;
                }else{
                    asteroid = 0;
                    stack.pop();
                }
            }
            if (asteroid != 0){
                stack.push(asteroid);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}