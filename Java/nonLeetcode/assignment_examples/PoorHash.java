// h(k) = k % N
// h(k) = (k * K) % N
// h(k) = (gcd(k+1, 2K+2) + K) % N
// h(k) = (gcd(k+1, K+2)) % N
// which one is not suitable in terms of causing a lot of colision

public class MyClass {
    public static void main(String args[]) {
        int N = 10;
        // int k = 0;
        String ans = "";
      for(int i = 0; i <= N; i++){
          // System.out.println(i % N); // => 1,2, 3,4,5,6,7,8,9,0,...
          // System.out.println((i* i) % N); => 0,1,4,9,6,5,
          // System.out.println((gcd(i+1, (2*i)+2)+i) % N); => 1,3,5,7,9,1,3...
          System.out.println(gcd(i+1, i+2) % N);  // =>1,1,1,1,1,1,1...not suitable for hash, many collision
      }
    }
    public static int gcd(int a, int b) {
      while (b != 0) {
        int r = a % b;
        a = b;
        b = r;
      }
      return a;
    }
}

