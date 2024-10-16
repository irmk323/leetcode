// O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for(int i = 1; i < n; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        int R = 1;
        for(int j = n-1; j >= 0; j--){
            ans[j] = ans[j] * R;
            R *= nums[j];
        }
      
        return ans;
    }
}


// [1, 1*2 = 2, 1*2*3 =6, 1*2*3*4 =24]
// [?, 1,2,6]

//  [1,2,3,4]
// //  run product from left to right
// [1*2*3*4 =24, 2*3*4 =24, 3*4 =12, 4 ]
// //  run product from right to left
// [1,           1*2 = 2, 1*2*3 =6, 1*2*3*4 =24]

// //  remove extra from line 14
// [,           1 =, 1*2 =2, 1*2*3* =6]
// //  remove extra from line 15
// [2*3*4 =24,  3*4 =12, 4,  ]


// i = 1, 2*3*4 = 24
// i = 2, 1*3*4 = 12
// i = 3, 1*2*4 = 8

// Input: nums = [1,2,3,4] =24
// Output: [24,12,8,6]


// O(n^2)
// for i ()
//   for j 


