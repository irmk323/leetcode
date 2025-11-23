package codility;

class Solution {
    public int[] solution(int N, int[] A) {
        int n = A.length;
        int curMax = 0;
        int base= 0;
        int[] ans = new int[N];
        for(int i =0; i<n ; i++){
            if(A[i] == N +1){
                base = curMax;
            }else{
                if(ans[A[i]-1] < base){
                    ans[A[i]-1] = base;
                }
                ans[A[i]-1] +=1;
                curMax = Math.max(curMax, ans[A[i]-1] );
            }
        }
        applyMaxValue(ans, base);
        return ans;
    }
    public void applyMaxValue(int[] ans, int base){
        for(int i = 0; i< ans.length; i++){
            if(ans[i] < base ){
                ans[i] = base;
            }
        }
    }
}







