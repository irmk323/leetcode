class Solution {
    // dhfgacbaf
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        int maxSize = 0;
        for( char rightChar : s.toCharArray() ){
            if(charSet.contains(rightChar)){
                maxSize = Math.max(maxSize, charSet.size());
                while(true){
                    if (s.charAt(left) == rightChar){
                        break;
                    } else {
                        charSet.remove(s.charAt(left));
                    }
                    left ++;
                }
            }else{
                charSet.add(rightChar);
            }
        }
        return Math.max(maxSize, charSet.size());
    }
}
