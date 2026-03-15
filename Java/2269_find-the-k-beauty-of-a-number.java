class Solution {
    public int divisorSubstrings(int num, int k) {
        String sNum = String.valueOf(num);
        int count =0;
        for(int i =0; i<= sNum.length() -k; i++){
            int j = i+k;
            String subN = sNum.substring(i, j);
            int n = Integer.valueOf(subN);
            System.out.println(n);
            if(n > 0 && num% n == 0){
                count++;
            }
        }
        return count;
    }
}