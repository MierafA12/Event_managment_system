package exercises;
import java.util.Scanner;

public class Float {
    public static void main(String[] args) {
     Scanner float_num = new Scanner(System.in);
     System.out.print("Enter a float number: ");
     float number = float_num.nextFloat();
     int x = (int) number;
     System.out.println("The integer part is: " + x);
     float y= number - x;
     System.out.println("The fractional part is: " + y);
        }
    
}


