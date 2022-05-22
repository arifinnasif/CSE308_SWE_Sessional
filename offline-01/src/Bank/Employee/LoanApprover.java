package Bank.Employee;

import Bank.Bank;
import Bank.Loan;

public class LoanApprover extends Employee{
    protected LoanApprover(Bank bank) {
        super(bank);
    }

    public boolean approveLoan(Loan loan) {
        return bank.approveALoanRequest(loan);
    }
}
