
// O(1)
class Solution {
    public int trap(int[] height) {

        int left= 0;
        int right = height.length-1;
        int res =0;
        int leftMax = height[left];
        int rightMax = height[right];

        while(left < right){
            if(leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
            }else{
                right--;
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
            }
        }
        return res;
    }
}


// ==========prefix suffix=========================

class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = height[0];
        right[height.length-1] = height[height.length-1];
        for(int i =1; i<height.length; i++){
            left[i] = Math.max(height[i], left[i-1]);
        }
        // 0,1,1,2,2,2,2,2,3,3,3,3,3
        // 3,3,3,3,3,3,3,3,3,2,2,2,1 
        for(int i =height.length -2; i>=0; i--){
            right[i] = Math.max(height[i], right[i+1]);
        }

        int sum[] = new int[height.length];
        for(int i =1; i<height.length; i++){
            sum[i]  = Math.min(left[i],right[i]) - height[i];
        }
        return Arrays.stream(sum).sum();

        
    }
}

=========