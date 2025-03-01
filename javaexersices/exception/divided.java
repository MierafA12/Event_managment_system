package exception;
import java.util.InputMismatchException;
import java.util.Scanner;

public class divided {
  public static void main(String[] args) {
     Scanner num = new Scanner(System.in);
     System.out.print("Enter first number: ");
     int x =num.nextInt();
     System.out.print("Enter second number: ");
     int y = num.nextInt();
     try{
        int z=x/y;
        System.out.println("Result: "+z);
     }catch(ArithmeticException e){
        System.out.println("Error: Division by zero.");
     }
     catch ( InputMismatchException e) { 
       System.out.println("Error: Invalid input. Please enter integers only.");
     }
     catch(Exception e){
        System.out.println("An error occurred: ");
     }
     finally{
      System.out.println(x/y) ; 
     }
  }
}
