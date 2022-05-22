package Bank.Employee;

import Bank.Bank;
import Bank.Loan;

public class Officer extends LoanApprover{

    public Officer(Bank bank) {
        super(bank);
    }

    @Override
    public String toString() {
        return "Officer\n" +
                "   - can lookup total deposit of any account\n" +
                "   - can approve loans";
    }
}
