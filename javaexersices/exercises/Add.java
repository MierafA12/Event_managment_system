package exercises;
import java.util.Scanner;

public class Add {

    public static void main(String[] args) {
        Scanner num = new Scanner (System.in);
         System.out.print("Enter the first number: ");
         int num1 = num.nextInt();
         System.out.print("Enter the second number: ");
         int num2 = num.nextInt();
         int sum = num1 + num2;
         int difference=num1-num2;
         int multipication=num1*num2;
         double division=(double)num1/num2;
         int remainder = num1%num2;
         System.out.println("Sum of " + num1 + " and " + num2 + " is: " + sum);
         System.out.println("difference of " + num1 + " and " + num2 + " is: " + difference);
         System.out.println("multipication of " + num1 + " and " + num2 + " is: " + multipication);
         System.out.println("division of " + num1 + " and " + num2 + " is: " + division);
         System.out.println("remainder of " + num1 + " and " + num2 + " is: " + remainder );
         num.close(); 
     

    }
      
}