import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        stack.add(Integer.valueOf(operations[0]));

        for(int i = 1; i< operations.length; i++ ){
            if(operations[i].equals("D")){
                int peek = stack.peek();
                stack.add(peek *2);
            }else if(operations[i].equals("C")){
                stack.pop();
            }else if(operations[i].equals("+")){
                int secondFromTop = stack.get(stack.size() - 2);
                int firstFromTop = stack.get(stack.size() - 1);
                stack.add(secondFromTop + firstFromTop );
            }else {
                stack.add(Integer.valueOf(operations[i]));
            }
        }
        int sum = 0;
        for(int e : stack){
            sum+=e;
        }
        return sum;
    }
}