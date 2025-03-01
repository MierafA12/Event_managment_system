package exercises;
import java.util.Scanner;

class InnerEmployee {
String employName;
int employAge;
String employWork;
double employSalery;

public  InnerEmployee (String employName ,int employAge ,String employWork ,double employSalery) {
  this.employName =employName;
  this.employAge = employAge;
  this.employWork = employWork;
  this.employSalery = employSalery;
    
}
void display (){
    System.out.println("Hi employee, " + employName + ".");
    System.out.println("Age: " + employAge + ", Work: " + employWork + ", Salary: " + employSalery);
}

}
public class Employee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

     
        System.out.println("Enter employee name:");
        String employName = scanner.nextLine();

      
        System.out.println("Enter employee age:");
        int employAge = scanner.nextInt();

      
        scanner.nextLine();

        System.out.println("Enter employee work:");
        String employWork = scanner.nextLine();

 
        System.out.println("Enter employee salary:");
        double employSalery = scanner.nextDouble();
       
        InnerEmployee employee_info = new InnerEmployee(employName , employAge , employWork , employSalery);
        employee_info.display();
    
    }
}




