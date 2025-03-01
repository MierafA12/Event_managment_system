import java.util.*;
class banks{
    int balance;
    void withdraw(){
        Scanner num = new Scanner(System.in);
        System.out.println("how much amount you want to withdrow from your account ");
        int amount = num.nextInt();
        if(balance >= amount){
            balance -= amount;
        }
        else{
            System.out.println("Insufficient balance");
        }
    }
    void deposit(int amount){
        balance += amount;
    }
}
public class bank {
   public static void main(String[] args){
    System.out.println("wellcome");
    Scanner num = new Scanner(System.in);
    System.out.println("Enter your balance");
    int balance=num.nextInt();
    System.out.println("select an option: ");
    Scanner option = new Scanner(System.in);
    System.out.println("1)withdraw  an amount: ");
    System.out.println("2)deposit an amount: ");
    System.out.println("3)exit");
    int choice = option.nextInt();
      switch(choice){
        case 1:
            banks b = new banks();
            b.balance = balance;
            b.withdraw();
            System.out.println("Your updated balance is: " + b.balance);
            break;
        case 2:
            System.out.println("Enter the amount you want to deposit: ");
            int deposit = num.nextInt();
            banks b1 = new banks();
            b1.balance = balance;
            b1.deposit(deposit);
            System.out.println("Your updated balance is: " + b1.balance);
            break;
        case 3:
            System.out.println("2Goodbye!");
            break;
        default:
            System.out.println("Invalid option. Please try again.");
      }
      System.out.println("thankyou for using our banking system. Goodbye!");
   } 
    
    
}
