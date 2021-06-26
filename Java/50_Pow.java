class Solution {
    // long is to handle the edge case like -2^31 <= n <= 2^31-1
    private double fast_pow(double x, long n){
        if(n == 0) return 1;
        if(n == x) return x;
        if( n < 0 ) return fast_pow(1/x, -n);
        double result = fast_pow(x*x, n/2);
        if(n % 2 == 1) result *= x;
        return result;
    }
    public double myPow(double x, int n) {
        return fast_pow(x, n);
    }
}
