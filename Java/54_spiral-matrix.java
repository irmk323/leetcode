class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0;
        int left = 0;
        int right = matrix[0].length;
        int bottom = matrix.length;

        while(top < bottom && left < right){
            for(int i = left; i < right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            for(int i = top; i < bottom; i++){
                res.add(matrix[i][right-1]);
            }
            right--;
            if(!(top < bottom && left < right)){
                break;
            }  
            for(int i = right - 1; i >=left ; i--){
                res.add(matrix[bottom-1][i]);
            }
            bottom--;     
            for(int i = bottom -1 ; i >= top ; i--){
                res.add(matrix[i][left]);
            }
            left++;          
        }
        return res;
    }
}