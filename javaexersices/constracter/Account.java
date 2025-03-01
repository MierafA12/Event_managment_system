package constracter;
import java.util.Scanner;

 class Account {
    String AccountNumber;
    double Balance;

    // Constructor with basic validation
     Account(String accountNumber, double balance) {
        if (accountNumber ==  null || accountNumber.isEmpty()) {
            System.out.println("Account number cannot be null or empity.");   
        }
        else {
          AccountNumber=accountNumber;
        }
        if (balance < 0) {
            System.out.println("Balance cannot be negative."); 
        }
        else {
            Balance=balance;
        }
        System.out.println("avcount" +accountNumber);
       
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account number:");
        String accountNumber = scanner.nextLine();

        System.out.println("Enter balance:");
        double balance = scanner.nextDouble();

        // Create Account object
       Account  bank = new Account(accountNumber, balance);
      
 
    }
}

