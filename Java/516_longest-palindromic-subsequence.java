class Solution {

    public int longestPalindromeSubseq(String s){
        char[] str = s.toCharArray();
        int n = str.length;

        int T[][] = new int[n][n];
        for(int i=0; i < n; i++){
            T[i][i] = 1;
        }

        for(int len = 1; len <= n; len++){
            for(int i = 0; i < n-len ; i++){
                int j = i + len ;
                // System.out.println(len + ":" + i +";" + j);
                if(len == 1 && str[i] == str[j]){
                    T[i][j] = 2;
                }else if(str[i] == str[j]){
                    T[i][j] = T[i + 1][j-1] + 2;
                }else{
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }
        return T[0][n-1];
    }
}