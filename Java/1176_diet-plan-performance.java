class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int point = 0;
        int sum = 0;
        for(int i =  0; i< k; i++){
            sum += calories[i];
        }
        for(int i=k ; i< calories.length; i++){
            if(sum < lower){
                point --;
            }else if(sum > upper){
                point++;
            }
            sum += calories[i] - calories[i-k];
        }
        if(sum < lower){
                point --;
            }else if(sum > upper){
                point++;
        }
        return point;
    }

}
// k = 3
//  l   r
// [6,5,0,0]