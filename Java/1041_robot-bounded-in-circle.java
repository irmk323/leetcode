class Solution {
    public boolean isRobotBounded(String instructions) {
        // north 0,1
        // south 0,-1
        // west -1,0
        // east 1, 0
        int dirX = 0, dirY = 1;
        int x = 0, y = 0;
        for(char c : instructions.toCharArray()){
            if(c == 'L'){
                int temp = dirX;
                dirX = dirY * -1;
                dirY = temp; 
            }else if(c == 'R'){
                int temp = dirX;
                dirX = dirY ;
                dirY = -1 * temp; 
            }else{
                x += dirX;
                y += dirY;
            }
        }
        // !(dirX == 0 && dirY ==1) is mathmaticaly proven.. 
        return (x == 0 && y == 0) || !(dirX == 0 && dirY ==1);
        
    }
}

// L -> L-> L -> L-> ...
// X : Y ... on X side, do -1 from prev Y, Y takes X value as it is.
// 0  ,1
// -1 ,0
// 0  ,-1
// 1  ,0
// 0  ,1

// R -> R-> R -> R-> ...
// X : Y ... on Y side, do -1 from prev Y, X takes Y value as it is.
// 0  ,1
// 1 ,0
// 0  ,-1
// -1  ,0
// 0  ,1