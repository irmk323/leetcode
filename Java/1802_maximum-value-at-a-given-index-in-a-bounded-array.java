class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1,  right = maxSum;
        while(left < right){
            int mid = (left + right +1) /2;
            if(getSum(index, mid, n) <= maxSum){
                left = mid;
            }else{
                right = mid -1;
            }
        }
        return left;

    }
    private long getSum(int index, int value, int n){
        long count = 0;
        //left side calcuration.
        if (value > index){
            count += (long)(value + value - index) * (index +1 )/2;
        }else{
            count += (long)(1 + value )* value /2 + index - value +1;
        }
        //right side calcuration.
        if (value >= n- index){ // compare length if it cause 
            count += (long)( value + value - n + 1 + index)* (n- index)/2;
        }else{
            count += (long)(1 + value )* value /2 + n- index - value;
        }
    return count - value;
    }
}

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