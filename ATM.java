package interface_ATM;

import java.util.Scanner;

public class ATM {
    private Scanner sc;
    private Account account;

    public ATM() {
        sc = new Scanner(System.in);
        account = new Account();
    }

    public void Display() {
        System.out.println("Welcome to ATM Interface!!");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Withdraw Amount");
        System.out.println("4. Check Balance");
        System.out.println("5. Change PIN");
        System.out.println("6. Exit");
        System.out.println("Enter Your Choice:");
    }

    public void processingTransaction() {
        System.out.println();

        while (true) {
            Display();
            int options = sc.nextInt();
            switch (options) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    if (validatePIN()) {
                        System.out.println("Amount:");
                        double amount = sc.nextDouble();
                        account.deposit(amount);
                    }
                    break;

                case 3:
                    if (validatePIN()) {
                        System.out.println("Withdraw Amount:");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                    }
                    break;

                case 4:
                    if (validatePIN()) {
                        System.out.println("Your Account Information\n");
                        account.AccountInfo();
                    }
                    break;

                case 5:
                    if (validatePIN()) {
                        System.out.println("New PIN:");
                        double newPIN = sc.nextDouble();
                        account.changePIN(newPIN);
                    }
                    break;

                case 6:
                    sc.close();
                    System.exit(0);

                default:
                    break;
            }
        }

    }

    public void createAccount() {
        System.out.println("Enter Account Number:");
        String accNumber = sc.next();
        System.out.println("Enter Initial Balance:");
        double initialBalance = sc.nextDouble();
        System.out.println("Enter PIN:");
        double pin = sc.nextDouble();
        account.accountCreate(accNumber, initialBalance, pin);
    }

    public boolean validatePIN() {
        System.out.println("Enter PIN:");
        double enteredPIN = sc.nextDouble();
        if (enteredPIN == account.PIN) {
            return true;
        } else {
            System.out.println("Invalid PIN. Transaction aborted.");
            return false;
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.processingTransaction();
    }
}
