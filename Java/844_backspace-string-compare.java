import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for(char c: s.toCharArray()){
            if(c != '#'){
                stackS.add(c);
            }else{
                if(!stackS.isEmpty()){
                    stackS.pop();
                }
            }
        }
        for(char c: t.toCharArray()){
            if(c != '#'){
                stackT.add(c);
            }else{
                if(!stackT.isEmpty()){
                    stackT.pop();
                }
            }
        }
        return stackS.toString().equals(stackT.toString());

    }
}