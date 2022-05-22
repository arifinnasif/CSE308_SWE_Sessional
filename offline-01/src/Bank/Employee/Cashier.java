package Bank.Employee;

import Bank.Bank;

public class Cashier extends Employee{
    public Cashier(Bank bank) {
        super(bank);
    }

    @Override
    public String toString() {
        return "Cashier\n" +
                "   - can lookup total deposit of any account";
    }
}
