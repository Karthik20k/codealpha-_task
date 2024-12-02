import java.util.Scanner;

public class BankingApplication {
public static void main(String[] args) {
Scanner scanner = new Scanner([System.in](http://system.in/));
double balance = 0.0;
boolean running = true;

```
    System.out.println("Welcome to Simple Banking Application!");

    // Main menu loop
    while (running) {
        System.out.println("\\nMain Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Check balance
                System.out.printf("Your current balance is: $%.2f%n", balance);
                break;

            case 2:
                // Deposit money
                System.out.print("Enter amount to deposit: $");
                double depositAmount = scanner.nextDouble();
                if (depositAmount > 0) {
                    balance += depositAmount;
                    System.out.printf("You successfully deposited $%.2f. New balance: $%.2f%n", depositAmount, balance);
                } else {
                    System.out.println("Invalid amount. Please enter a positive value.");
                }
                break;

            case 3:
                // Withdraw money
                System.out.print("Enter amount to withdraw: $");
                double withdrawalAmount = scanner.nextDouble();
                if (withdrawalAmount > 0 && withdrawalAmount <= balance) {
                    balance -= withdrawalAmount;
                    System.out.printf("You successfully withdrew $%.2f. New balance: $%.2f%n", withdrawalAmount, balance);
                } else if (withdrawalAmount > balance) {
                    System.out.println("Insufficient funds. Transaction canceled.");
                } else {
                    System.out.println("Invalid amount. Please enter a positive value.");
                }
                break;

            case 4:
                // Exit program
                System.out.println("Thank you for using Simple Banking Application. Goodbye!");
                running = false;
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    scanner.close();
}

```

}