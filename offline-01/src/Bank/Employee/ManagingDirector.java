package Bank.Employee;

import Bank.Account.*;
import Bank.Bank;

public class ManagingDirector extends LoanApprover{
    public ManagingDirector(Bank bank) {
        super(bank);
    }

    public void changeDepositInterestRate(Bank.AccountTypes accountTypes, double interest_rate) {
        if(accountTypes == Bank.AccountTypes.SAVINGS) SavingsAccount.setInterestRate(interest_rate);
        else if(accountTypes == Bank.AccountTypes.STUDENT) StudentAccount.setInterestRate(interest_rate);
        else if(accountTypes == Bank.AccountTypes.FIXED_DEPOSIT) FixedDepositAccount.setInterestRate(interest_rate);
        else if(accountTypes == Bank.AccountTypes.LOAN) LoanAccount.setInterestRate(interest_rate);
    }

    public double getInternalFund() {
        return bank.getInternalFund();
    }

    @Override
    public String toString() {
        return "Managing Director\n" +
                "   - can lookup total deposit of any account\n" +
                "   - can approve loans\n" +
                "   - can change interest rate\n" +
                "   - can look into internal funds";
    }
}
