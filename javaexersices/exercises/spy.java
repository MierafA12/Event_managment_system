package exercises;
import java.util.Scanner;

public class spy {
    public static void main(String[] args) {
        
        Scanner num = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int  number = num.nextInt();
        int  sum =0;
        int product =1;
    while (number>0){
        int remainder = number % 10;
        sum = sum + remainder;
        product = product * remainder;
        number = number / 10;
      }
     if (product == sum ){
        System.out.println("The given number is a spy number");
     }
     else{
        System.out.println("The given number is not a spy number");
     }
}
}
