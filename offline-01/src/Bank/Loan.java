package Bank;

import Bank.Account.Account;



public class Loan {
    enum RequestState {
        WAITING,
        APPROVED,
        REJECTED,
        PAID
    }

    final static private double loanInterestRate = 0.1;
    private double initialAmount;
//    private double amount;
    private Account account;
    private RequestState requestState;
//    private int startTime;

    public Loan(double amount, Account account) {
//        this.amount = amount;
        this.initialAmount = amount;
        this.account = account;
        this.requestState = RequestState.WAITING;
    }

//    public double getAmount() {
//        return amount;
//    }

    public double getInitialAmount() {
        return initialAmount;
    }

    public Account getAccount() {
        return account;
    }

    public RequestState getRequestState() {
        return requestState;
    }

    public void setRequestState(RequestState requestState) {
        this.requestState = requestState;
    }

//    public void setStartTime(int startTime) {
//        this.startTime = startTime;
//    }

//    public void incrementYear() {
//        if(requestState != RequestState.APPROVED) return;
//        this.amount = amount*(1+loanInterestRate);
//    }

    void approve() {
        this.requestState = RequestState.APPROVED;
        account.increaseTotalApprovedLoans(initialAmount);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "initialAmount=" + initialAmount +
                ", account=" + account +
                '}';
    }
}
