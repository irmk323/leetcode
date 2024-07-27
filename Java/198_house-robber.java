class Solution {
    public int rob(int[] nums) {
        int twoLeftNeighbour = 0, oneleftNeighbour = 0;
        for(int i = 0; i < nums.length; i++ ){
            int temp = Math.max(twoLeftNeighbour+ nums[i], oneleftNeighbour);
            twoLeftNeighbour = oneleftNeighbour;
            oneleftNeighbour = temp;
        }
        return oneleftNeighbour;
    }
}

//  0, 0 [2,7,9,3,1,[5],3,4,5]
// in the point of [5] 
// twoLeftNeighbour is 3, oneleftNeighbour is 1, those shift