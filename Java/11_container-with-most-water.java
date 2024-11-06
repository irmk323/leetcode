class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxArea = 0;
        while(left< right){
            int area = (right - left) * Math.min(height[right], height[left]);
            maxArea = Math.max(maxArea , area);
            if(height[left]< height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
        
    }
}