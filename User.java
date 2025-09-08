public class User {
    private int acc_no;
    private int pin;
    private double balance;

    public User(int accno, int pin, double balance) {
        this.acc_no = accno;
        this.pin = pin;
        this.balance = balance;
    }

    public int getAccno() {
        return acc_no;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
