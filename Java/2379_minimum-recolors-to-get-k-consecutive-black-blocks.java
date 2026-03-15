class Solution {
    public int minimumRecolors(String blocks, int k) {
        int wCount = 0;
        int bCount = 0;
        for(int i = 0; i< k;i++){
            if(blocks.charAt(i) == 'W'){
                wCount++;
            }else{
                bCount++;
            }
        }
        if(blocks.length() == k){
            return wCount;
        }
        int min = wCount;
        for(int i = k ; i< blocks.length();i++){

            if(blocks.charAt(i) == 'W'){
                wCount++;
            }
            if(blocks.charAt(i-k) == 'W'){
                wCount--;
            }
            min = Math.min(wCount, min);
        }
        return min;
    }
}