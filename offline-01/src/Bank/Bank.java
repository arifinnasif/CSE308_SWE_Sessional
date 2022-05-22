package Bank;

import Bank.Account.*;
import Bank.Employee.Cashier;
import Bank.Employee.Employee;
import Bank.Employee.ManagingDirector;
import Bank.Employee.Officer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class Bank {
    public enum AccountTypes {
        SAVINGS,
        FIXED_DEPOSIT,
        STUDENT,
        LOAN
    }
    static private int year = 0;



    private double internalFund;
    private final ArrayList<Loan> loanReqs;
    private final ArrayList<Loan> loans;
    private final HashMap<String, Employee> employeeHashMap;
    private final HashMap<String, Account> accountHashMap;
    public Bank() {
        employeeHashMap = new HashMap<>();
        accountHashMap = new HashMap<>();

        this.internalFund = 1000000;
        this.loanReqs = new ArrayList<>();
        this.loans = new ArrayList<>();

        ManagingDirector MD = new ManagingDirector(this);

        Officer O1 = new Officer(this);
        Officer O2 = new Officer(this);

        Cashier C1 = new Cashier(this);
        Cashier C2 = new Cashier(this);
        Cashier C3 = new Cashier(this);
        Cashier C4 = new Cashier(this);
        Cashier C5 = new Cashier(this);

        employeeHashMap.put("MD", MD);

        employeeHashMap.put("O1", O1);
        employeeHashMap.put("O2", O2);

        employeeHashMap.put("C1", C1);
        employeeHashMap.put("C2", C2);
        employeeHashMap.put("C3", C3);
        employeeHashMap.put("C4", C4);
        employeeHashMap.put("C5", C5);
    }

    public Employee findEmployee(String str) {
        if (str == null) return null;
        return employeeHashMap.get(str.toUpperCase(Locale.ROOT));
    }

    public Account findAccount(String str) {
        if (str == null) return null;
        return accountHashMap.get(str.toUpperCase(Locale.ROOT));
    }

    private Account createAccount_(String name, AccountTypes account_type, double initial_balance) throws InvalidAmountException {
        if (name == null) return null;
        if(account_type == AccountTypes.SAVINGS) return new SavingsAccount(name, initial_balance, this);
        if(account_type == AccountTypes.STUDENT) return new StudentAccount(name, initial_balance, this);
        if(account_type == AccountTypes.FIXED_DEPOSIT) return new FixedDepositAccount(name, initial_balance, this);
        if(account_type == AccountTypes.LOAN) return new LoanAccount(name, initial_balance, this);
        return null;
    }

    public boolean createAccount(String str, AccountTypes account_type, double initial_balance) throws InvalidAmountException {
        if (str == null) return false;
        if(doesExist(str.toUpperCase(Locale.ROOT))) return false;
        accountHashMap.put(str.toUpperCase(Locale.ROOT), createAccount_(str.toUpperCase(Locale.ROOT), account_type, initial_balance));
        return true;
    }

    public boolean doesExist(String str) {
        if (str == null) return false;
        return findAccount(str.toUpperCase(Locale.ROOT)) != null;
    }

    public void addToLoanRequests(Loan loanRequest) {
        loanReqs.add(loanRequest);
    }

    boolean rejectALoanRequest(Loan loanRequest) {
        boolean temp = loanReqs.contains(loanRequest);
        if(temp && loanRequest.getRequestState() == Loan.RequestState.WAITING) {
            loanRequest.setRequestState(Loan.RequestState.REJECTED);
            loanReqs.remove(loanRequest);
        }
        return temp;
    }

    public boolean approveALoanRequest(Loan loanRequest) {
        boolean temp = loanReqs.contains(loanRequest);
        if(temp && loanRequest.getRequestState() == Loan.RequestState.WAITING && internalFund >= loanRequest.getInitialAmount()) {

//            loanRequest.setStartTime(year);
            loanRequest.approve();
            loanReqs.remove(loanRequest);
            loans.add(loanRequest);
//            the following line is commented out because loaned money is added to A/C balance
//            increaseInternalFund(-loanRequest.getInitialAmount());

//            but as the loan-account holders cannot withdraw. that must have meant that the additional loans taken out of the bank immediately
            if(loanRequest.getAccount() instanceof LoanAccount)
                increaseInternalFund(-loanRequest.getInitialAmount());
        }
        return temp;
    }

    public ArrayList<Loan> getAllLoans() {
        return loans;
    }

    public ArrayList<Loan> getAllLoanReqs() {
        return loanReqs;
    }

    public void incrementYear() {
        year++;
        for(Account account: accountHashMap.values()) {
            account.incrementYear();
        }
    }

    public boolean increaseInternalFund(double arg) {
        if(arg<0 && -arg > this.internalFund) {
            System.err.println("Cannot process the operation. Insufficient internal fund");
            return false;
        }
        this.internalFund += arg;
        return true;
    }

    public int getYear() {
        return year;
    }

    public double getInternalFund() {
        return internalFund;
    }
}
