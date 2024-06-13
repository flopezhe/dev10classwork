public class BankAccount implements MoneyStorage{
   double balance;
   String description;

    public BankAccount(double balance,String description){
        this.balance = balance;
        this.description=description;
    }
    public double getBalance() {
        return balance;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean deposit(double amount) {
        if(amount <=0){
            return false;
        } else {
            balance+=amount;
            return true;
        }

    }

    @Override
    public double withdraw(double amount) {
        if (amount <= 0.0) {
            return balance;
        }
        double result =balance - amount;
        balance=result;
        return amount;

    }
}
