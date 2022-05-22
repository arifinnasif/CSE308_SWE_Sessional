package Bank.Account;

import Bank.Bank;

public abstract class NormalAccount extends Account {
    //private double maxLoan;
    private static final double SERVICE_CHARGE = 500;

    protected NormalAccount(String name, double balance, Bank bank) throws InvalidAmountException {
        super(name, balance, bank);
        //this.maxLoan = maxLoan;
    }

    @Override
    public void incrementYear() {
        this.balance += balance*getInterestRate();
        this.balance -= this.getTotalApprovedLoans()*LOAN_INTRATE;
        this.balance -= SERVICE_CHARGE;
    }

    @Override
    protected boolean checkLoanPrereq(double amount) {
        return totalApprovedLoans + amount <= getMaxLoan();
    }


    public abstract void withdraw(double amount) throws InsufficientBalanceException, InvalidAmountException;

    protected abstract double getMaxLoan();

    protected abstract double getInterestRate();
}
