/* 
Name: Salman Arain.
Roll Number: 24SW43.
Project: ATM System.
*/
import java.util.Scanner;

public class SimpleAtm {

    private static final String CORRECT_PIN1 = "1234";
    private static final String CORRECT_PIN2 = "0000";
    private static final String CORRECT_PIN3 = "1111";
    private static final String CORRECT_PIN4 = "2222";
    private static final String CORRECT_PIN5 = "3333";
    private static float balance = 10000.0f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        String enteredPIN;
        System.out.println("=========================");
        System.out.println("|    WELCOME TO ATM      |");
        System.out.println("=========================");
        System.out.println("|   ___ ___ ___    ___   |");
        System.out.println("|  | 7 | 8 | 9 |  | <-|  |");
        System.out.println("|  |___|___|___|  |___|  |");
        System.out.println("|  |___|___|___|  |___|  |");
        System.out.println("|  | 4 | 5 | 6 |  |Clr|  |");
        System.out.println("|  |___|___|___|  |___|  |");
        System.out.println("|  | 1 | 2 | 3 |  |Ent|  |");
        System.out.println("|  |___|___|___|  |___|  |");
        System.out.println("|  | . | 0 |00 |  |OK |  |");
        System.out.println("|  |___|___|___|  |___|  |");
        System.out.println("|________________________|");

        // PIN Entry with 3 attempts
        while (attempts < 3) {
            System.out.print("Enter your 4-digit PIN: ");
            enteredPIN = scanner.nextLine();

            if (enteredPIN.equals(CORRECT_PIN1)) {
                showMenu(scanner);
                return;
            } else if (enteredPIN.equals(CORRECT_PIN2)) {
                showMenu(scanner);
                return;
            }else if (enteredPIN.equals(CORRECT_PIN3)) {
                showMenu(scanner);
                return;
            }else if (enteredPIN.equals(CORRECT_PIN4)) {
                showMenu(scanner);
                return;
            }else if (enteredPIN.equals(CORRECT_PIN5)) {
                showMenu(scanner);
                return;
            }else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts left: " + (3 - attempts));
            }
        }

        System.out.println("Too many incorrect attempts. Access Denied.");
        scanner.close();
    }

    private static void showMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                scanner.next(); // discard invalid input
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. GoodBy!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: Rs:"+balance);
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter deposit amount: Rs:");
        float amount = scanner.nextFloat();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter withdrawal amount: Rs:");
        float amount = scanner.nextFloat();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Invalid or insufficient funds.");
        }
    }
}
