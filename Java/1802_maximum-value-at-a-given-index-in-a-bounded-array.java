class Solution {

    private long sumOneToK(long k){
        return (k * (k + 1)) / 2;　// sum of 1 to k
    }
    
    private long sumFromNDescending(long n, long numElements){
        long sequenceSize = Math.min(n, numElements); // (8, 4) => 4 ,  (3,4)=> 3
        long ones = numElements - sequenceSize; // (4-4) = 0
        return (n * sequenceSize - sumOneToK(sequenceSize - 1) + ones);
        
        // if you wanna calc [5,6,7,8] 
        // 8 8 8 8 means 8 * 4
        //   1 2 3 substructing
        // ==========
        // 8 7 6 5 result

        // if you wanna calc [1,1,2,3]
        // 3 3 3 
        //   1 2  substructing
        // ==========
        // 3 2 1  result
    }

    private long getSum(int n, int index, long candidate) {
        long sumLeft = sumFromNDescending(candidate, index +1 );
        long sumRight = sumFromNDescending(candidate , n-index);
        return (sumLeft + sumRight - candidate);
    }
    
    public int maxValue(int n, int index, int maxSum) {
        long left = 0, right = maxSum;
        
        while (left < right) {
            long mid = (left + right + 1) / 2;
            long sum = getSum(n,index, mid);
            if (sum > maxSum) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }
}





// class Solution {
//     public int maxValue(int n, int index, int maxSum) {
//         int left = 1,  right = maxSum;
//         while(left < right){
//             int mid = (left + right +1) /2;
//             if(getSum(index, mid, n) <= maxSum){
//                 left = mid;
//             }else{
//                 right = mid -1;
//             }
//         }
//         return left;

//     }
//     private long getSum(int index, int value, int n){
//         long count = 0;
//         //left side calcuration.
//         if (value > index){
//             count += (long)(value + value - index) * (index +1 )/2;
//         }else{
//             count += (long)(1 + value )* value /2 + index - value +1;
//         }
//         //right side calcuration.
//         if (value >= n- index){ // compare length if it cause 
//             count += (long)( value + value - n + 1 + index)* (n- index)/2;
//         }else{
//             count += (long)(1 + value )* value /2 + n- index - value;
//         }
//     return count - value;
//     }
// }

// Left side from given idx:
//     value > idx
    //  0 1 2 3 4 5
    // [2,3,4,5,4,3]  idx = 5

    // value <= idx
    //  0 1 2 3 4 5
    // [1,1,1,2,1,1]  idx = 5

// Right side from given idx:
//     value >  n - index
//      0 1 2 3 4 5
//     [2,3,4,5,4,3]  idx = 5

//     value <= n - index
//      0 1 2 3 4 5
//     [1,1,1,2,1,1]  idx = 5

