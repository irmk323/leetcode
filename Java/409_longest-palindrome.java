class Solution {
    public int longestPalindrome(String s) {
        Set<Character> charSet = new HashSet<>();
        int ans = 0;
        for(char c : s.toCharArray()){
            if ( charSet.contains(c) ){
                ans += 2;
                charSet.remove(c);
            }else{
                charSet.add(c);
            }
        }
        return charSet.size() > 0 ? ans + 1: ans;
        
    }
}