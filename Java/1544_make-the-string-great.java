class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            int sblen = sb.length();
            if(sblen!=0 && Math.abs(sb.charAt(sblen -1) - c) == 32){
                sb.deleteCharAt(sblen -1);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}