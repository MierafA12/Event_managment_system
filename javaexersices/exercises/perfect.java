package exercises;
import java.util.Scanner;

public class perfect {
    
    public static void main(String[] args) {
    Scanner perfect = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int x=perfect.nextInt();
    
    int sum =0;
    for  (int i=1; i<x; i++){
        if (x % i == 0){
            sum =sum + i;
    }
}

    if (sum == x){
        System.out.println(x + " is a perfect number.");
    }
    else{
        System.out.println(x + " is not a perfect number.");
    }

  
}}