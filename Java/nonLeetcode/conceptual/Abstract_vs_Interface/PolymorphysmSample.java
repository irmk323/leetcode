package nonLeetcode.conceptual.Abstract_vs_Interface;

public class PolymorphysmSample {
    public static void main(String[] args) {
        Animal animal1 = new Cat();
        System.out.println(animal1.shout());
        // animal1.run();
    }
}


public class Animal{
    public String shout(){
        return "Don't know";
    }
}


public class Cat extends Animal{
    public String shout(){
        return "Meow";
    }
    public void run(){

    }
}