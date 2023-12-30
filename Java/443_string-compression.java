class Solution {
    public int compress(char[] chars) {
        int ansIndex = 0,  index = 0;       
        while(index  < chars.length){
            int count = 0;
            char curChar = chars[index];
            while(index < chars.length && chars[index] == curChar){
                index++;
                count++;
            }
            chars[ansIndex++] = curChar;
            // ansIndex++;
            if(count != 1){
                for(char c: Integer.toString(count).toCharArray()){
                    chars[ansIndex++] = c;
                }
            }
        }
        return ansIndex;
    }
}