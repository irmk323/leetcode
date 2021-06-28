class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1) return 0;
        int parent = kthGrammar(n-1, (k+1)/2);
        boolean isKOdd = k % 2 == 1 ? true :false;
        if(parent == 1){
            return isKOdd ? 1 : 0;
        }else{
            return isKOdd ? 0 : 1;
        }
    }
}
