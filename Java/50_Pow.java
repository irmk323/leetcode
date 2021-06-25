//Runtime error
class Solution {
    private double pow_until(double x, int n){
        if(n == 0) return 1.0;
        if(n == 1) return x;
        if( n < 0 ) return pow_until(1/x, -n);
        double result = pow_until(x*x, n/2);
        if(n%2 == 1) result *= x;
        return result;
    }
    public double myPow(double x, int n) {
        return  pow_until(x, n);
    }
}
