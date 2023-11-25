class Solution {
    private boolean help(int startingIndex, int[] nums, Map<Integer, Boolean> memo) {

        if (startingIndex == nums.length) {
            return true;
        }

        if (memo.containsKey(startingIndex)) {
            return memo.get(startingIndex);
        }
        boolean res = false;
        if (same2(startingIndex, nums)) {
            res |= help(startingIndex + 2, nums, memo);
        }
        if (same3(startingIndex, nums) || increasing3(startingIndex, nums)) {
            res |= help(startingIndex + 3, nums, memo);
        }
        memo.put(startingIndex,res);
        return res;
    }


    private boolean same2(int startingIndex, int[] nums) {
        return (
            startingIndex < nums.length-1 &&
            nums[startingIndex] == nums[startingIndex+1]);
    }
    private boolean same3(int startingIndex, int[] nums) {
        return (
            startingIndex < nums.length-2 &&
            nums[startingIndex] == nums[startingIndex+1] &&
             nums[startingIndex+1] == nums[startingIndex+2]
            );
    }
    
    private boolean increasing3(int startingIndex, int[] nums) {
        return (
            startingIndex < nums.length-2 &&
            nums[startingIndex] +1 == nums[startingIndex+1] &&
             nums[startingIndex+1] +1 == nums[startingIndex+2]
            );
    }
    public boolean validPartition(int[] nums) {
        return help(0, nums, new HashMap<>());
    }
}

//     public boolean validPartition(int[] nums) {
//         int n = nums.length;
//         boolean[] dp = new boolean[n+1];
//         dp[n] = true;
//         for(int i = n-2; i >=0 ; i--){
//             if( same2(i, nums)) {
//                 dp[i] |= dp[i+2];
//                 // dp[i] = dp[i] || dp[i+2];
//             }

//             if( i < n-2 &&  ((nums[i] == nums[i+1] && nums[i+1]  == nums[i+2]) ||
//             (nums[i]+1 == nums[i+1]) &&nums[i+1] + 1 ==  nums[i+2])
//              ){
//                  dp[i] = dp[i] || dp[i+3];
//             }
//         }
//         return dp[0];
        
//     }
// }
// //.           f(5, list)
// [4,4,4,4,4,6,4,2,3,9]
// f(0, list)?
// if (list[0] == list[1] and f(2, list)). --> we're good
// if (list[0] == list[1] == list[2] and f(3, list)). --> we're good
// 2,3.   ??
// 3,2.   ??


// [4,4] ...




