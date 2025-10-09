abstract class BankAccount{
    private String accNo;
    protected double balance;

    public BankAccount(String accNo , double balance){
        this.accNo=accNo;
        this.balance=balance;
    }

    public String getaccNo(){
        return accNo;
    }

    public double getBalance(){
        return balance;
    }

    public void setaccNo(String accNo){
        this.accNo=accNo;
    }

    public void setBalance(double balance){
        this.balance=balance;
    }

    public void deposit(double amount){
        if (amount>=0){
            balance += amount;
        }else {
            System.out.println("Incorrect value");
        }
        System.out.println("Deposited amount is : " + amount);
    }

    abstract void withdraw(double amount);
}
class SavingAccount extends BankAccount{
    private double interestRate;

    public SavingAccount(String accNo , double balance , double interestRate){
            super(accNo , balance);
            this.interestRate=interestRate;
    }

    public void withdraw(double amount){
        if (amount>=balance){
            System.out.println("Amount withdraw from saving account is  : " + amount + " And the remaining balance is : " + balance);
        }else {
            System.out.println("Insufficient funds , Please check the balance and Try again");
        }
    }

    public void addInterest(double amount){
        interestRate = amount * 5 / 100;
        balance +=interestRate;
        System.out.println("Interest amount is " + interestRate + " and after the intrest is : " + balance);
    }
}

class CurrentAccount extends BankAccount{
    private double overDraft;

        public  CurrentAccount(String accNo , double balance ,double overDraft){
            super(accNo, balance);
            this.overDraft=overDraft;
        }

    void withdraw(double amount){
        if (amount <= balance + overDraft){
            balance -= amount;
        }else {
            System.out.println("Overdraft limit crossed");
        }
    }

    void setOverDraft(double overDraft){
        this.overDraft=overDraft;
    }
}


