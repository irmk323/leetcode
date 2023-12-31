class SnakeGame {
    int eatenNum;
    int[][] food;
    LinkedList<Position> snake;
    int rows, cols;


    public SnakeGame(int width, int height, int[][] food) {
        this.rows = height;
        this.cols = width;
        this.food = food;
        snake = new LinkedList<Position>();
        snake.add(new Position(0, 0));
        eatenNum = 0;
    }
    
    public int move(String direction) {
        Position cur = new Position(snake.get(0).x, snake.get(0).y);

        switch(direction){
            case "U":
                cur.x--;
                break;
            case "L":
                cur.y--;
                break;
            case "R":
                cur.y++;
                break;
            case "D":
                cur.x++;
                break;
        }
        if(isOutOfRange(cur)) return -1;
        if(hasEatenItself(cur)) return -1;


        snake.addFirst(cur);        
        if(eatenNum < food.length){ // if food is still remaining? 
            Position f = new Position(food[eatenNum][0], food[eatenNum][1]);
            if(cur.isEqual(f)){
                eatenNum++;
            }
        }
        while(snake.size() > eatenNum +1){ // +1 means it's head;
            snake.removeLast();
        }
        return eatenNum;
    }
    private boolean isOutOfRange(Position cur){
        return (cur.x < 0 || cur.y < 0 || cur.x >= rows || cur.y >= cols);
    }
    private boolean hasEatenItself(Position cur){
        for(int i =0; i< snake.size()-1; i++){
            Position next = snake.get(i);
            if(next.isEqual(cur)){
                return true;
            }
        }
        return false;
    }
}

class Position{
    int x;
    int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean isEqual(Position p){
        return this.x == p.x && this.y == p.y;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */