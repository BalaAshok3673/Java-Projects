import java.util.Currency;

public class BankAccount {
    private String accNo;
    protected double balance;

    public BankAccount(String accNo , double balance){
        this.accNo=accNo;
        this.balance=balance;
    }

    public void setaccNo(String accNo){
        this.accNo=accNo;
    }

    public void setBalance(int balance){
        this.balance=balance;
    }

    public String getAccNo(){
        return accNo;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if (amount>0){
            balance+=amount;
        }else {
            System.out.println("enter correct amount");
        }

        System.out.println("Deposited amount is : " + amount + " and the remaining balance is : " + balance);
    }

    public void withdraw(double amount){
        if (amount<balance){
            balance-=amount;
            System.out.println("withdraw amount :" + amount + " and the balace is : " + balance);
        }
        else {
            System.out.println("In sufficient balance");
        }

    }
}

class SavingsAccount extends BankAccount{

    private double intrestRate;

    public SavingsAccount(String accno , double balance , double intrestRate){
        super(accno , balance);
        this.intrestRate=intrestRate;
    }

    public void addInterest(){
        double interest = balance / intrestRate * 100;
        balance += interest;
        System.out.println("Interest amount is : " + interest + " Total would be : " + balance);
    }
}


class CurrectAccount extends BankAccount{
    private double overdraft;

    public  CurrectAccount(String accNo , double balance  , double overdraft){
        super(accNo , balance);
        this.overdraft=overdraft;
    }

    @Override
    public void withdraw(double amount){
        if (amount>0 || amount<=balance + overdraft){
            balance-=amount;
        }else{
            System.out.println("Overdraft amount is exceeded");
        }
    }
}


class Main{
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("10001" , 0);
        SavingsAccount s1= new SavingsAccount("10002" ,0,5);
        CurrectAccount c1 = new CurrectAccount("4000" ,5000,3000);
        s1.deposit(4000);
        s1.withdraw(500);
    }
}
