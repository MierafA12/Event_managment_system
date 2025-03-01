package exercises;
import java.util.Scanner;

public class c1 {
public static void main(String[] args){
Scanner Char1= new Scanner(System.in);
System.out.println("enter the checked character");
char ch=Char1.next().charAt(0);


if (Character.isUpperCase(ch)){
    System.out.println("the character is uppercase");
}
    else if (Character.isLowerCase(ch)){
        System.out.println("the character is lower case");  

    }
    else {
        System.out.println("the character is neither uppercase nor lowercase");	
    }

}
}
