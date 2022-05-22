package Bank.Account;

import Bank.Bank;

public class FixedDepositAccount extends NormalAccount{
    private final int yearCreated;
    private static double interestRate;
    private static final double maxLoan = 100000;
    public FixedDepositAccount(String name, double balance, Bank bank) throws InvalidAmountException {
        super(name, balance, bank);
        this.yearCreated = bank.getYear();
        setInterestRate(0.15);
    }

    public static void setInterestRate(double interestRate) {
        FixedDepositAccount.interestRate = interestRate;
    }

    @Override
    protected double getInterestRate() {
        return interestRate;
    }

    @Override
    protected void setBalance(double balance) throws InvalidAmountException {
        if(balance < 100000) throw new InvalidAmountException("Fixed deposit accounts require at least $100000 of initial balance");
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        if(amount < 50000) throw new InvalidAmountException("Deposit amount for fixed deposit accounts must be at least $50000");
        balance+=amount;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException {
        if(bank.getYear() <= yearCreated) {
            System.err.println("Cannot withdraw. need maturity of 1 year");
            return;
        }
        if(this.balance <= 0) throw new InvalidAmountException("Withdrawal must be positive");
        if(this.balance - amount < 0) throw new InsufficientBalanceException();


        if(bank.increaseInternalFund(-amount))
            this.balance-=amount;
    }

    @Override
    protected double getMaxLoan() {
        return maxLoan;
    }

    @Override
    public String toString() {
        return "name: "+name+"; A/C type: FIXED DEPOSIT";
    }
}
