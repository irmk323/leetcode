
// time O(N)
// mem O(1)
class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int minDif = Integer.MAX_VALUE;
        int leftSum = A[0];
        int rightSum = 0;
        for(int i = 1; i< A.length; i++){
            rightSum += A[i];
        }
        for(int i = 1; i< A.length; i++){
            int curDif = Math.abs(leftSum -rightSum);
            minDif = Math.min(minDif, curDif);
            leftSum += A[i];
            rightSum -= A[i];
        }
        return minDif;
    }
}