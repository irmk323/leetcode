class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int e : pushed) {
            stack.push(e);
            i = processStack(stack, popped, i);
        }
        return i == N;
    }

    private int processStack(Stack<Integer> stack, int[] popped, int i) {
        while (stack.size() > 0 && popped[i] == stack.peek()) {
            stack.pop();
            i++;
        }
        return i;
    }
}