// Time O(n)
// Space O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        Integer rp = 1;
        for(int i = 1; i< nums.length; i++){
            rp *= nums[i-1];
            ans.add(rp);
        }
        // [2*3*4 =24,  3*4 =12, 4,  ]
        rp = 1;
        for(int i = nums.length -2; i>=0; i--){
            rp *= nums[i+1];
            ans.set(i, ans.get(i) * rp);
        }
        int[] resInt = new int[ans.size()];
        for(int i = 0; i< ans.size(); i++){
            resInt[i] = ans.get(i);
        }
        return resInt;
    }
}

// O(n)


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
