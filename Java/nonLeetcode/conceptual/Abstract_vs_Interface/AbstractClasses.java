package nonLeetcode.conceptual.Abstract_vs_Interface;

//  An abstract class is a class that cannot be instantiated 
public class AbstractClasses {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.makeNoise();
        Dog dog = new Dog();
        dog.eat();
        dog.makeNoise();
        System.out.println(AnimalStuff.someThing());
        // System.out.println(AnimalStuff.saySomething());
    }
}

// you can implement many interfaces
public class Dog extends Animal implements AnimalStuff {
    @Override
    public void eat(){
        System.out.println("eat dog food");
    }
    @Override
    public void makeNoise(){
        System.out.println("bow");
    }

}

public class Cat extends Animal{
    @Override
    public void makeNoise(){
        System.out.println("meow");
    }
}

public abstract class Animal {
    int age;
    String name;
    // enforce and organize exactly what subclass of Animal must have
    public abstract void makeNoise();
    // you can create concrete class as well.
    public void printName(){
        System.out.println("My name is" + name);
    }
}

public interface  AnimalStuff {
    // this gonna be public final
    // int age =  1;
    private String saySomething(){
        return "Say something";
    }
    public void eat();
    static int someThing(){
        return 0;
    }
    
}