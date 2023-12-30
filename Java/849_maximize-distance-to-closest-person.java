class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int k = 0; 
        int ans = 0;
        for(int i =0; i< n; i++){
            if(seats[i] == 1){
                k = 0;
            }else{
                k++;
                ans = Math.max(ans, (k+1) /2);
            }
        }
        // the case for [0,0,0,1]
        for(int i = 0; i < n; i++ ){
            if(seats[i] == 1){
                ans = Math.max(ans, i);
                break;
            }
        }
         // the case for [1,0,0,0]
        for(int i = n-1; i >= 0; i-- ){
            if(seats[i] == 1){
                ans = Math.max(ans, n-1 -i);
                break;
            }
        }
        return ans;       
    }
}