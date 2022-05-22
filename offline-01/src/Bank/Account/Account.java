package Bank.Account;

import Bank.Bank;
import Bank.Loan;

public abstract class Account {
    protected double balance;
    protected Bank bank;
    //protected double interestRate;
    protected static final double LOAN_INTRATE = 0.10;
    protected double totalApprovedLoans;
    protected String name;

    protected Account(String name, double balance, Bank bank) throws InvalidAmountException {
        setBalance(balance);
        this.name = name;
        this.bank = bank;
        this.totalApprovedLoans = 0;
        if(!bank.increaseInternalFund(balance)) throw new InvalidAmountException("Not enough fund");
    }

    public void deposit(double amount) throws InvalidAmountException {
        if(amount <= 0) throw new InvalidAmountException("Deposit amount must be positive");
        balance+=amount;
        bank.increaseInternalFund(amount);
    }

    //changable
    protected void setBalance(double balance) throws InvalidAmountException {
        if(balance < 0) throw new InvalidAmountException("Initial amount cannot be negative");
        this.balance = balance;
    }


    public boolean requestLoan(double amount) throws InvalidAmountException {
        if(amount <= 0) throw new InvalidAmountException("Loan amount must be positive");
        boolean temp = checkLoanPrereq(amount);
        if(temp) {
            Loan lr = new Loan(amount, this);
            bank.addToLoanRequests(lr);
        }
        return temp;
    }

//    public double getTotalLoan() {
//        double sum = 0;
//        if(bank.getAllLoans() == null) return 0;
//        for(Loan loan : bank.getAllLoans()) {
//            if(loan.getAccount() == this) sum+= loan.getInitialAmount();
//        }
//        return sum;
//    }

//    public void setInterestRate(double interestRate) {
//        this.interestRate = interestRate;
//    }
    // change in loan account
    public void increaseTotalApprovedLoans(double amount) {
        this.totalApprovedLoans += amount;
        balance+=amount;
    }

    public double getTotalApprovedLoans() {
        return totalApprovedLoans;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void incrementYear();

    protected abstract boolean checkLoanPrereq(double amount);
}
