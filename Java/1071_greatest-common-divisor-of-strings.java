class Solution {
    public String gcdOfStrings(String str1, String str2) {
    // O(m+n) solution
        if(!(str1 +str2).equals(str2+ str1)){
            return "";
        }

        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }
    private int gcd(int x , int y){
        if(y == 0){
            return x;
        }else{
            return gcd(y, x%y);
        }
    }

    // Time  O(min(m,n)*(m+n))
    // Space O(min(m,n))
    //     int l1 = str1.length();
    //     int l2 = str2.length();
    //     for(int i =  Math.min(l1, l2); i > 0 ; i--){
    //         if(valid(str1, str2, i)){
    //             return str1.substring(0,i);
    //         }
    //     }
    //     return "";
    // }
    // private boolean valid(String str1, String str2, int k){
    //     int l1 = str1.length();
    //     int l2 = str2.length();
    //     if (l1 %k > 0 || l2 % k >0){
    //         return false;
    //     }else{
    //         String base = str1.substring(0,k);
    //         return str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty();
    //     }
    // }
}