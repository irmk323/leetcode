package codility;

// ==================================
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
class CountSemiprimes {
    public int[] solution(int N, int[] P, int[] Q) {

        // create sieve of erastos
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;
        int sqrt = (int)Math.sqrt(N);
        for(int i =2; i<= sqrt; i++){
            if(isPrime[i]){
                for(int j = i* i; j<= N; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        // judge if it's semiprime
        boolean[] isSemiPrime = new boolean[N+1];
        for(int p = 2; p<= N ; p++){
            if(isPrime[p]){
                for(int q= p; q<= N; q++){
                    if(isPrime[q]){
                        int semiprime = p * q;
                        if(semiprime <= N){
                            isSemiPrime[semiprime] = true;
                        }
                    }
                }
            }
        }
        int[] prefix = new int[N+1];
        for(int i =1; i<= N; i++){
            prefix[i] = prefix[i-1] + (isSemiPrime[i]? 1: 0);
        }

        int[] result = new int[P.length];
        for(int i = 0; i< P.length; i++){
            int start = P[i];
            int end = Q[i];
            result[i] = prefix[end] - prefix[start -1];
        }
        return result;
    }  
}




