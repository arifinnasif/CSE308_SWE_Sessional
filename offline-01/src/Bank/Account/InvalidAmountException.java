package Bank.Account;

public class InvalidAmountException extends Exception{
    String msg;
    InvalidAmountException(String msg) {
        this.msg = msg;
    }
    @Override
    public String toString() {
        return this.msg;
    }
}
