class Solution {

    public int longestPalindromeSubseq(String s){
        char[] str = s.toCharArray();
        int n = str.length;

        int T[][] = new int[n][n];
        for(int i=0; i < n; i++){
            T[i][i] = 1;
        }
        // for(int l = 2; l <= str.length; l++){
        //     for(int i = 0; i < str.length-l + 1; i++){
        //         int j = i + l - 1;
        //         if(l == 2 && str[i] == str[j]){

        // if you set 1 as start len means length as a gap beteen 1 [] 2 -> len 1 
        // if n  =3  column or rows are ...
        //   0, 1, 2 
        // 0
        // 1
        // 2

        // so between 0 to 2, there's 2 commas. means len <= n;
        for(int len = 1; len <= n; len++){
            for(int i = 0; i < n-len ; i++){
                int j = i + len ;
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