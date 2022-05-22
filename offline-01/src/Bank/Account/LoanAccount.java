package Bank.Account;

import Bank.Bank;


public class LoanAccount extends Account{
    private static double interestRate;
    public LoanAccount(String name, double balance, Bank bank) throws InvalidAmountException {
        super(name, balance, bank);
        setInterestRate(0.10);
    }

    public static void setInterestRate(double interestRate) {
        LoanAccount.interestRate = interestRate;
    }



    @Override
    protected void setBalance(double balance) throws InvalidAmountException {
        if(balance >= 0) throw new InvalidAmountException("Loan account must have a negative initial balance");
        this.balance = balance;
    }
    @Override
    public void incrementYear() {
        this.balance -= this.balance * LoanAccount.interestRate;
        this.totalApprovedLoans += this.totalApprovedLoans * LoanAccount.LOAN_INTRATE;
    }

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        if(-balance<amount) {
            double temp = -this.balance;
            if(this.totalApprovedLoans < (amount - temp)) throw new InvalidAmountException("depositing more than more than what is owed");

            this.balance = 0;

            this.totalApprovedLoans = this.totalApprovedLoans - (amount - temp);
            return;
        }
        super.deposit(amount);
    }

    @Override
    public void increaseTotalApprovedLoans(double amount) {
        this.totalApprovedLoans += amount;
    }

    @Override
    protected boolean checkLoanPrereq(double amount) {
        return -this.balance*0.05 >= totalApprovedLoans + amount;
    }

    @Override
    public String toString() {
        return "name: "+name+"; A/C type: LOAN";
    }
}
