package inheritance;

public class Animal {
    public void makeSound(){
        System.out.println("Animal makes a sound");
    }

}
class Cat extends Animal {
    public void makeSound(){
        System.out.println("Cat meow");
    }
}
class main{
public static void main(String[] args){
    Cat animal = new Cat();
    animal.makeSound();
}
}