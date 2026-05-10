class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = searchMaxRowLessThanTarget(matrix, target);
        if(row < 0){
            return false;
        }
        int left =0;
        int right = matrix[0].length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(target == matrix[row][mid]){
                return true;
            }else if(target > matrix[row][mid]){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return false;
    }
    private int searchMaxRowLessThanTarget(int[][] matrix, int target){
        int left =0;
        int right = matrix.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(target == matrix[mid][0]){
                return mid;
            }else if(target > matrix[mid][0]){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }
        return right;
    }
}