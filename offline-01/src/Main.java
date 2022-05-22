import Bank.Account.Account;
import Bank.Account.InsufficientBalanceException;
import Bank.Account.InvalidAmountException;
import Bank.Account.NormalAccount;
import Bank.Bank;
import Bank.Employee.Employee;
import Bank.Employee.LoanApprover;
import Bank.Employee.ManagingDirector;
import Bank.Loan;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        enum Handler {
            EMPLOYEE,
            ACCOUNT,
            NONE
        }
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();
        System.out.println("Bank created. MD, O1, O2, C1, C2, C3, C4, C5 created");

        String str = null;
        Handler handler = Handler.NONE;

        while(true) {
            System.out.print(">>> ");
            String[] cmd = sc.nextLine().strip().split(" ");

            if(cmd[0].equalsIgnoreCase("create")) {
                try {
                    Bank.AccountTypes accountTypes = Bank.AccountTypes.SAVINGS;

                    if(cmd[2].equalsIgnoreCase("savings")) accountTypes = Bank.AccountTypes.SAVINGS;
                    else if(cmd[2].equalsIgnoreCase("student")) accountTypes = Bank.AccountTypes.STUDENT;
                    else if(cmd[2].equalsIgnoreCase("fixed")) accountTypes = Bank.AccountTypes.FIXED_DEPOSIT;
                    else if(cmd[2].equalsIgnoreCase("loan")) accountTypes = Bank.AccountTypes.LOAN;
                    else {
                        System.err.println("type not found");
                        continue;
                    }

                    if(cmd[1].equalsIgnoreCase("md")
                            || cmd[1].equalsIgnoreCase("o1")
                            || cmd[1].equalsIgnoreCase("o2")
                            || cmd[1].equalsIgnoreCase("c1")
                            || cmd[1].equalsIgnoreCase("c2")
                            || cmd[1].equalsIgnoreCase("c3")
                            || cmd[1].equalsIgnoreCase("c4")
                            || cmd[1].equalsIgnoreCase("c5")
                    ) {
                        System.err.println("Use different username");
                        continue;
                    }

                    if(bank.createAccount(cmd[1].toUpperCase(Locale.ROOT), accountTypes, Double.parseDouble(cmd[3]))) {
                        System.out.println(cmd[2]+" account created for "+cmd[1]+" with initial balance $"+cmd[3]);
                        str = cmd[1].toUpperCase(Locale.ROOT);
                        handler = Handler.ACCOUNT;
                    } else {
                        System.err.println("User already exists");
                    }

                } catch (InvalidAmountException e) {
                    e.printStackTrace();
                }
            } else if(cmd[0].equalsIgnoreCase("Deposit")) {
                Account account = bank.findAccount(str);
                if(account == null) {
                    System.err.println("Invalid operation. Open appropriate user first");
                    continue;
                }
                try {
                    account.deposit(Double.parseDouble(cmd[1]));
                    System.out.println(cmd[1]+" deposited. current balance "+account.getBalance());
                } catch (InvalidAmountException e) {
                    e.printStackTrace();
                }
            } else if(cmd[0].equalsIgnoreCase("Withdraw")) {
                Account account = bank.findAccount(str);
                if(account == null) {
                    System.err.println("Invalid operation. Open appropriate user first");
                    continue;
                }
                try {
                    if(!(account instanceof NormalAccount)) {
                        System.err.println("Cannot withdraw");
                        continue;
                    }
                    ((NormalAccount) account).withdraw(Double.parseDouble(cmd[1]));
                    System.out.println(cmd[1]+" withdrawn. current balance "+account.getBalance());
                } catch (InvalidAmountException | InsufficientBalanceException e) {
                    e.printStackTrace();
                }
            } else if(cmd[0].equalsIgnoreCase("Query")) {
                Account account = bank.findAccount(str);
                if(account == null) {
                    System.err.println("Invalid operation. Open appropriate user first");
                    continue;
                }
                if(account instanceof NormalAccount) {
                    System.out.println("current balance " + account.getBalance());
                    System.out.println("loan " + account.getTotalApprovedLoans());
                } else {
                    System.out.println("loan " + (-account.getBalance()));
                    System.out.println("additional loan " + account.getTotalApprovedLoans());
                }
            } else if(cmd[0].equalsIgnoreCase("Request")) {
                Account account = bank.findAccount(str);
                if(account == null) {
                    System.err.println("Invalid operation. Open appropriate user first");
                    continue;
                }
                try {
                    if(account.requestLoan(Double.parseDouble(cmd[1])))
                        System.out.println("Loan request successful, sent for approval");
                    else
                        System.err.println("Cannot place a loan request");
                } catch (InvalidAmountException e) {
                    e.printStackTrace();
                }
            } else if(cmd[0].equalsIgnoreCase("Close")) {
                if(str == null) {
                    System.out.println("Not logged in. Nothing closed");
                    continue;
                }
                System.out.println("Transaction Closed for "+str);
                str = null;
                handler = Handler.NONE;
            } else if(cmd[0].equalsIgnoreCase("Open")) {
                if(cmd[1].equalsIgnoreCase("o1")||
                        cmd[1].equalsIgnoreCase("o2")||
                        cmd[1].equalsIgnoreCase("c1")||
                        cmd[1].equalsIgnoreCase("c2")||
                        cmd[1].equalsIgnoreCase("c3")||
                        cmd[1].equalsIgnoreCase("c4")||
                        cmd[1].equalsIgnoreCase("c5")||
                        cmd[1].equalsIgnoreCase("md")) {
                    handler = Handler.EMPLOYEE;
                    str = cmd[1].toUpperCase(Locale.ROOT);

                    Employee employee = bank.findEmployee(str);
//                    Employee employee = bank.employeeHashMap.get(str);
//                    System.out.println(bank.findEmployee("o1"));
                    if(employee instanceof LoanApprover) {
                        System.out.println("Pending loan requests - ");
                        int i = 0;
                        for (Loan loan:
                             bank.getAllLoanReqs()) {
                            System.out.println(""+(i++)+loan);
                        }
                    }
                } else {
                    Account account = bank.findAccount(cmd[1].toUpperCase(Locale.ROOT));
                    if(account == null) {
                        System.err.println("Invalid operation. Open appropriate user first");
                        continue;
                    }
                    handler = Handler.ACCOUNT;
                    str = cmd[1].toUpperCase(Locale.ROOT);
                    System.out.println("Welcome back, "+cmd[1]);
                }
            } else if (cmd[0].equalsIgnoreCase("Approve")) {
                Employee employee = bank.findEmployee(str);
                if(employee == null) {
                    System.err.println("Invalid operation. Open appropriate user first");
                    continue;
                }
                if(!(employee instanceof LoanApprover)) {
                    System.err.println("You don’t have permission for this operation");
                    continue;
                }
                Loan chosen_loan = bank.getAllLoanReqs().get(Integer.parseInt(cmd[2]));
                if(((LoanApprover) employee).approveLoan(chosen_loan))
                    System.out.println("Approved "+chosen_loan);
                else
                    System.err.println("Cannot approve the loan request");
            } else if (cmd[0].equalsIgnoreCase("Change")) {
                Employee employee = bank.findEmployee(str);
                if(employee == null) {
                    System.err.println("Invalid operation. Open appropriate user first");
                    continue;
                }
                if(!(employee instanceof ManagingDirector)) {
                    System.err.println("You don’t have permission for this operation");
                    continue;
                }
                Bank.AccountTypes accountTypes;
                if(cmd[1].equalsIgnoreCase("SAVINGS")) accountTypes = Bank.AccountTypes.SAVINGS;
                else if(cmd[1].equalsIgnoreCase("STUDENT")) accountTypes = Bank.AccountTypes.STUDENT;
                else if(cmd[1].equalsIgnoreCase("FIXED_DEPOSIT")) accountTypes = Bank.AccountTypes.FIXED_DEPOSIT;
                else if(cmd[1].equalsIgnoreCase("LOAN")) accountTypes = Bank.AccountTypes.LOAN;
                else {
                    System.err.println("Type not found");
                    continue;
                }
                ((ManagingDirector) employee).changeDepositInterestRate(accountTypes, Double.parseDouble(cmd[2])/100);
                System.out.println("Interest rate for "+cmd[1].toUpperCase(Locale.ROOT)+" account changed to "+cmd[2]);
            } else if (cmd[0].equalsIgnoreCase("Lookup")) {
                Employee employee = bank.findEmployee(str);
                if(employee == null) {
                    System.err.println("Invalid operation. Open appropriate user first");
                    continue;
                }
                double curbal = employee.lookup(bank.findAccount(cmd[1].toUpperCase(Locale.ROOT)));
                if(curbal == Double.NEGATIVE_INFINITY) {
                    System.err.println("Account not found");
                    continue;
                }
                System.out.println(cmd[1]+"'s current balance is $"+curbal);
            } else if (cmd[0].equalsIgnoreCase("See")) {
                Employee employee = bank.findEmployee(str);
                if(employee == null) {
                    System.err.println("Invalid operation. Open appropriate user first");
                    continue;
                }
                if(!(employee instanceof ManagingDirector)) {
                    System.err.println("You don’t have permission for this operation");
                    continue;
                }
                double int_fund = ((ManagingDirector) employee).getInternalFund();
                System.out.println("The internal fund is $"+int_fund);
            } else if (cmd[0].equalsIgnoreCase("INC")) {
                bank.incrementYear();
                System.out.println("1 year passed");
            } else if (cmd[0].equalsIgnoreCase("Show_all_loans")) {
                Employee employee = bank.findEmployee(str);

                if(employee instanceof LoanApprover) {
                    System.out.println("Pending loan requests - ");
                    int i = 0;
                    for (Loan loan:
                            bank.getAllLoanReqs()) {
                        System.out.println(""+(i++)+loan);
                    }
                }
            } else if (cmd[0].equalsIgnoreCase("whoami")) {
                if (str == null) {
                    System.out.println("not a user");
                    continue;
                }
                Employee employee = bank.findEmployee(str.toUpperCase(Locale.ROOT));

                if(employee != null) {
                    System.out.println(employee);
                    continue;
                }

                Account ac = bank.findAccount(str.toUpperCase(Locale.ROOT));

                if(ac != null) {
                    System.out.println(ac);

                }


            }
            else {
                System.err.println("Command not found");
            }
        }
    }
}
