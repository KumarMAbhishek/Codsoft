package interface_ATM;



public class Account {
    protected String accountNumber;
    protected double balance;
    protected double PIN;

    public void AccountInfo() {
        System.out.println("Account Information:");
        System.out.println("Account Number:" + accountNumber);
        System.out.println("Balance:" + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount " + amount + " Deposited Successfully!!");
    }

    public void changePIN(double PIN) {
        this.PIN = PIN;
        System.out.println("PIN Changed Successfully");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount " + amount + " Withdrawn Successfully");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void accountCreate(String accountNumber, double initialBalance, double PIN) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.PIN = PIN;
        System.out.println("Account Created Successfully!");
    }


    
}
