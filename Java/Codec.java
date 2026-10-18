public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        while(index < s.length()){
            int j= index;
            while(s.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(s.substring(index,j));
            String curStr = s.substring(j+1,j+ len+1);
            ans.add(curStr);
            index = j+ len+1;
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));