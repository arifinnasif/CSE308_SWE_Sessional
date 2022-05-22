package Bank.Account;

import Bank.Bank;

public class SavingsAccount extends NormalAccount{
    private static double interestRate;
    private static final double maxLoan = 10000;
    public SavingsAccount(String name, double balance, Bank bank) throws InvalidAmountException {
        super(name, balance, bank);
        setInterestRate(0.10);
    }

    public static void setInterestRate(double interestRate) {
        SavingsAccount.interestRate = interestRate;
    }

    @Override
    protected double getInterestRate() {
        return interestRate;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException {
        if(this.balance <= 0) throw new InvalidAmountException("Withdrawal must be positive");
        if(this.balance - amount < 1000) throw new InsufficientBalanceException();

        if(bank.increaseInternalFund(-amount))
            this.balance-=amount;
    }

    @Override
    protected double getMaxLoan() {
        return maxLoan;
    }

    @Override
    public String toString() {
        return "name: "+name+"; A/C type: SAVINGS";
    }
}
