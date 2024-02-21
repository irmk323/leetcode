class Solution {
    public int minFlips(String target) {
        int count = 0;
        char prev = '0';
        for(char c: target.toCharArray()){
            if (c != prev){
                count++;
                prev = c;
            }
        }
        return count;
    }
}