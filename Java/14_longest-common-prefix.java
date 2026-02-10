class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];

        for(int i =1; i< strs.length; i++){

            // prefix = "flowe"
            // "flow".indexOf("flowe")   // -1

            // prefix = "flow"
            // "flow".indexOf("flow")    // 0 ✅

            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}