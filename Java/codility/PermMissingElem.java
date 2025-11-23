
//memory O(N)
//time O(N)
class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int n = A.length;
        int[] chechBox = new int[n+2];
        for(int i =0; i<n;i++){
            chechBox[A[i]] +=1;
        }

        for(int i =1; i<n+2;i++){
            if(chechBox[i] == 0){
                return i;
            }
        }
        return 0;
    }
}

// To make it memory O(1)
// total sum
class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int n = A.length + 1;
        long expected = (long) n * (n+1)/2;
        long actual = 0;

        for(int v : A){
            actual += v;
        }
        return (int) (actual - expected);
    }
}
// memory o(1)

class Solution {
    public int solution(int[] A) {
        int n = A.length + 1;
        int xor = 0;
        for (int v : A) {
            xor ^= v;
        }
        for (int i = 0; i < n; i++) {
            xor ^= i;
        }
        return xor;
    }
}