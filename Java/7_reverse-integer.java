class Solution {
    public int reverse(int x) {
        // Integer.MAX_VALUE = 2147483647
        // Integer.MIN_VALUE = -2147483648 
        // for the constraints, x (input) cannot be more than this.
        int rev = 0;
        while(x != 0){
            int mod = x % 10;
            x/= 10;

                          //  2147483647
            // in the case of 2147483642 still the range of MAX_VALUE, but 
            // when it reaches to the digit length to 2147483640(last digit supporsed to be input ) we find it as
            // already larger than MAX_VALUE

            // same as negatve int
            if (rev > Integer.MAX_VALUE /10 || rev < Integer.MIN_VALUE /10){
                return 0;
            }
            rev = (rev * 10 ) + mod;
        }
        return rev;
    }
}

