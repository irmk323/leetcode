class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb  = new StringBuilder();
        int sblen = 0;
        for(char c: s.toCharArray()){
            if(sblen != 0 && c == sb.charAt(sblen -1)){
                sb.deleteCharAt(sblen-- -1);
                // sblen--;
            }else{
                sb.append(c);
                sblen++;
            }
        }
        return sb.toString();
    }
}