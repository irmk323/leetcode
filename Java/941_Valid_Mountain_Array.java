// Time O(n)
// Space O(1)
class Solution {
    public boolean validMountainArray(int[] arr) {
        
        int N = arr.length, i = 0;
        //walk up
        while(i+1 < N && arr[i] < arr[i+1]) i++;
        
        //peek cannot be first or end
        if(i == 0 || i == N-1) return false;
        
        // walk down
        while(i+1 < N && arr[i] > arr[i+1]) i++;
        
        return i == N -1;
    }
}
