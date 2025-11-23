class Solution {
    public int[] solution(int[] A, int K) {
        // Implement your solution here
        int n = A.length;
        int[] ans = new int[n];
        for(int i =0; i<n; i++){
            int index = (i + K ) % n;
            ans[index] = A[i];
        }
        return ans;
    }
}