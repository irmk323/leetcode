class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1) return 0;
        //basically ceil(K/2) become double
        //if k is odd, it is easy to get the parent k position just +1
        // if k is 3, parent k is 2, (3 + 1) /2 is 2.
        int parent = kthGrammar(n-1, (k+1)/2);
        boolean isKOdd = true;
        if(k % 2 == 0) isKOdd = false;
        
        if(parent == 1){
            if(isKOdd){
                return 1;
            }else{
                return 0;
            }
        }else{
            if(isKOdd){
                return 0;
            }else{
                return 1;
            }
        }
    }
}
