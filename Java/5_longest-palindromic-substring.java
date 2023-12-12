class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n < 2){
            return s;
        }
        int len = 0;
        String res = "";
        // https://www.youtube.com/watch?v=E-tmN1OM9aA&t=452s
        // for example there's many of possible center
        // abaab 
        // if substring length is odd a,b,a,a,b can be the center , so 5, 
        // id substring length is even, between a,b,a,a,b can be the center so 4 
        // then totally 2n -1 is the num of possible palindrome center = O(n)
        // visiting each centre is O(n)
        // checking palindrome is O(n) 
        // totally O(n^2)

        for(int i = 0; i< n;i++){
            String oddStr = expand(i,i,s);
            if(oddStr.length() > len){
                res = oddStr;
                len = oddStr.length();
            }
            String evenStr = expand(i,i+1,s);
            if(evenStr.length() > len){
                res = evenStr;
                len = evenStr.length();
            }
        }
        return res;
    }
    private String expand(int left, int right, String s){
        while(left >= 0 && right < s.length() && s.charAt(left)== s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}