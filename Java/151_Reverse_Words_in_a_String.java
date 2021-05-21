class Solution {
    public String reverseWords(String s) {
        String result = "";
        String[] array = s.split("\\s+");
        List<String> list = Arrays.asList(array);
        Collections.reverse(list);
        for(String r : list){
            result +=   " " + r ;
        }
        return result.trim();
    }
}
