//O(n) 
class Solution {
    public int heightChecker(int[] heights) {
        int[] freq = new int[101];
        
        for(int height: heights){
            freq[height]++;
        }
        int result = 0, curHeight = 0;
        for(int i = 0; i< heights.length; i++){
            while(freq[curHeight] == 0){
                curHeight++;
            }
            if(curHeight != heights[i]){
                result++;
            }
            freq[curHeight]--;
        }
        return result;
    }
}
