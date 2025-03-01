package constracter;
import java.util.Scanner;
public class Book {
    String Title;
    String Author;
    double Price;
    Book(String T, String Author){
        this.Title = T;
      System.out.println("the title of the first book is " + Title);
      System.out.println("the Author of the first book is " + Author);
     
    }
    Book(String Title, String Author, double Price){
        System.out.println("the title of the second book is " + Title);
        System.out.println("the Author of the second book is " + Author);
        System.out.println(" the Price of the second book is " + Price);

    }
    public static void main (String[] args){
        Scanner BookInfo = new Scanner(System.in);
        System.out.println("enter book title");
        String T = BookInfo.nextLine();
        System.out.println("enter book author");
        String Author = BookInfo.nextLine();
        System.out.println("enter book price");
        double Price = BookInfo.nextDouble();
        Book MyBook1 = new Book(T,Author);
        Book MyBook2 = new Book(T,Author,Price);

    }
}
