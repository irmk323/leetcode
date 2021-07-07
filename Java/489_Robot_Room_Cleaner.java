/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    public void cleanRoom(Robot robot) {
        dfs(robot, 0,0,0, new HashSet<String>());  
    }
    private void dfs(Robot r, int x, int y, int dir, Set<String> c){
        String p = x + "-" + y;
        if(c.contains(p)) return ;
        r.clean();
        c.add(p);
        
        for(int n = 0; n < 4; n++){
            if(r.move()){
                int nextX = x, nextY = y;
                switch(dir){
                    case 0: nextY -=1; break;
                    case 90: nextX +=1; break;
                    case 180: nextY++; break;
                    case 270: nextX--; break;
                }
                dfs(r, nextX, nextY, dir, c);
                r.turnLeft();
                r.turnLeft();
                r.move();
                r.turnRight();
                r.turnRight();
            }
            dir+= 90;
            r.turnRight();
            dir = dir%360;
        }
    }
}
