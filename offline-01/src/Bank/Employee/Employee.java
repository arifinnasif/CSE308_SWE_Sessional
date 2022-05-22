package Bank.Employee;

import Bank.Account.Account;
import Bank.Account.LoanAccount;
import Bank.Account.NormalAccount;
import Bank.Bank;

public class Employee {
    protected Bank bank;
    protected Employee(Bank bank) {
        this.bank = bank;
    }

    public double lookup(Account account) {
        if (account instanceof NormalAccount) {
            return account.getBalance();//+ account.getTotalApprovedLoans();
        } else if (account instanceof LoanAccount) {
            return -account.getBalance();//+ account.getTotalApprovedLoans();
        }
        return Double.NEGATIVE_INFINITY;
    }
}
