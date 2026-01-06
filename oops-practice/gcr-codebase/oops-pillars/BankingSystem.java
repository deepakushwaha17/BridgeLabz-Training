package oopsPillars;

public class BankingSystem {

    public static void main(String[] args) {

        BankAccount[] accounts = new BankAccount[3];

        accounts[0] = new SavingsAccount("SAV101", "Mahi", 5000, 4);
        accounts[1] = new CurrentAccount("CUR202", "Khushi", 2000, 2, 1000);
        accounts[2] = new SavingsAccount("SAV303", "Jyoti", 800, 5);

        double depositAmount = 1000;
        double withdrawAmount = 500;

        for(BankAccount acc : accounts) {
            acc.displayAccount();

            // Deposit and Withdraw
            acc.deposit(depositAmount);
            acc.withdraw(withdrawAmount);

            // Calculate Interest
            System.out.println("Interest: " + acc.calculateInterest());

            // Loan processing if applicable
            if(acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                loanAcc.applyForLoan(2000);
            }
        }
    }
}


//abstract class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    protected void setBalance(double balance) { this.balance = balance; }

    // Concrete methods
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    public void displayAccount() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

//interface
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

//subclasses
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    @Override
    public void applyForLoan(double amount) {
        if(calculateLoanEligibility()) {
            System.out.println("Loan approved for: " + amount);
        } else {
            System.out.println("Loan not eligible.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 1000; // simple eligibility
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate; 
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double interestRate, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    @Override
    public void applyForLoan(double amount) {
        if(calculateLoanEligibility()) {
            System.out.println("Loan approved for: " + amount);
        } else {
            System.out.println("Loan not eligible.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() + overdraftLimit >= 500; // eligibility with overdraft
    }
}
