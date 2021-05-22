class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        List<String> list = Arrays.asList(str);
        String result = "";
        for(String st : list){
            StringBuilder strb = new StringBuilder(st);
            result += " " + strb.reverse().toString();
        }
        return result.substring(1);
    }
}
