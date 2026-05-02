class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> array = new ArrayList<>();
        for(int i  = 0; i< position.length; i++){
            double time = (double)(target - position[i]) / speed[i];
            array.add(new Car(position[i], time));
        }
        array.sort(Comparator.comparingInt((Car car) -> car.position).reversed());
        Deque<Double> stack = new ArrayDeque<>();
        for(int i  = 0; i< position.length; i++){
            if(stack.isEmpty() || stack.peek() < array.get(i).time ){
                stack.push(array.get(i).time );
            }
        }
        // posi 10, 8, 5,3,0
        // time 5, 2, 1
        return stack.size();
    }
}

class Car{
    int position;
    double time;
    public Car(int position, double time){
        this.position = position;
        this.time = time;
    }
}