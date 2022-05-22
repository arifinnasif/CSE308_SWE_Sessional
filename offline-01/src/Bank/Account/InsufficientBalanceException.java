package Bank.Account;

public class InsufficientBalanceException extends Exception{


    @Override
    public String toString() {
        return "Not enough balance";
    }
}
