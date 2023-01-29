class Solution {
    public int findKthPositive(int[] arr, int k) {
        // if the kth missing is less than arr[0]
        // e.g [3,4,5] k =2
        if (k <= arr[0] - 1) {
            return k;
        }
        // e.g [2,4,5,9] k =4, need to return 7
        // k -= 2 -1 => 4-1 =3
        k -= arr[0] - 1;

        // search kth missing between the array numbers
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // missing between arr[i] and arr[i + 1]
            // why -1?
            // [2,3] => missing is 0, as (3-2)-1= 1 
            int currMissing = arr[i + 1] - arr[i] - 1;
            // if the kth missing is between
            // arr[i] and arr[i + 1] -> return it
            if (k <= currMissing) {
                return arr[i] + k;
            }
            // otherwise, proceed further
            k -= currMissing;
        }
        // if the missing number if greater than arr[n - 1]
        return arr[n - 1] + k;
    }
}

