

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        int flowerlen =  flowerbed.length-1;
        for(int i =0; i<flowerbed.length; i++){
            boolean leftEmpty = (i == 0 || flowerbed[i-1] == 0);
            boolean rightEmpty = (i==flowerlen || flowerbed[i+1] == 0 );
            if(flowerbed[i] == 0 && leftEmpty && rightEmpty){
                flowerbed[i] = 1;
                n--;
                if(n==0){
                    return true;
                }
            }
        }
        return false;
        
    }
}