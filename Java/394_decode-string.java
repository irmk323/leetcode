class Solution {
    private int parseNumber(Stack<Character> stack) {
        StringBuilder strBuilder = new StringBuilder();
        while(stack.size() > 0 && Character.isDigit(stack.peek())){
            strBuilder.append(stack.pop());
        }
        return Integer.valueOf(strBuilder.reverse().toString());
    }

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c != ']'){
                stack.push(c);
            }else{
                // function that pops the stack and collects "str"
                StringBuilder patcialStr = new StringBuilder();
                while(stack.peek() != '['){
                    patcialStr.insert(0, stack.pop());
                }
                // func
                String str = patcialStr.toString();
                
                stack.pop(); // remove [
                int numRepeat = parseNumber(stack);
                // func that pushes a string K times into the stack
                while(numRepeat > 0){
                    stack.addAll(
                            str.chars()
                                .mapToObj(e -> (char)e)
                                .collect(Collectors.toList()));
                    numRepeat--;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
           ans.insert(0, stack.pop());
        }
        return ans.toString();
        
    }
}