package inheritance;
// import java.util.Scanner;
// class App{
//     public static void main(String[] args) {
//         Scanner myName = new Scanner(System.in);
//         System.out.print("Enter user name: ");
//         String userName = myName.nextLine();
//         Scanner myAge = new Scanner(System.in);
//         System.out.print("Enter user age: ");
//         int userAge = myAge.nextInt();
//         System.out.println("Hello, " + userName + "! Your age is " + userAge);

// }}

public class App {

    // Parent class
    class ParentClass {
        // Fields and methods of the parent class
        public void greet() {
            System.out.println("Hello from the parent class!");
        }
    }

    // Child class
    class ChildClass extends ParentClass {
        // Child class inherits from ParentClass
        public void sayGoodbye() {
            System.out.println("Goodbye from the child class!");
        }
    }

    public static void main(String[] args) {
        // Create an instance of the ChildClass and use methods
        App app = new App(); // Create the outer class instance
        ChildClass child = app.new ChildClass(); // Create an instance of the ChildClass

        child.greet(); // Inherited from ParentClass
        child.sayGoodbye(); // Method of ChildClass
    }
}
