package Bank.Account;

import Bank.Bank;

public class StudentAccount extends NormalAccount{
    private static double interestRate;
    private static final double maxLoan = 1000;
    public StudentAccount(String name, double balance, Bank bank) throws InvalidAmountException {
        super(name, balance, bank);
        setInterestRate(0.05);
    }

    public static void setInterestRate(double interestRate) {
        StudentAccount.interestRate = interestRate;
    }

    @Override
    protected double getInterestRate() {
        return interestRate;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException {
        if(this.balance <= 0) throw new InvalidAmountException("Withdrawal must be positive");
        if(amount >= 10000) throw new InvalidAmountException("Cannot withdraw more than $10000 from a student account");
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
        return "name: "+name+"; A/C type: STUDENT";
    }
}
