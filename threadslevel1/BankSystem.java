package threadslevel1;

class BankAccount{
    private double balance;
    public BankAccount(double initialBalane){
        this.balance=initialBalane;
    }
    public synchronized void withdraw(double amount){
        if(balance>=amount){
            System.out.println(Thread.currentThread().getName()+" is withdrawing "+amount);
            balance-=amount;
            System.out.println("Withdrawal completed , current balance : "+balance);
        }else {
            System.out.println(Thread.currentThread().getName()+" attempted to withdraw "+amount+" but insufficient balance : "+balance);
        }
    }
    public double getBalance(){
        return balance;
    }
}
class UserBankAccount extends Thread{

    private BankAccount bankAccount;
    String name;
    String account_no;
    double amount;
    UserBankAccount(BankAccount bankAccount,String name,String account_no,double amount){
        this.name=name;
        this.amount=amount;
        this.account_no=account_no;
        this.bankAccount=bankAccount;
    }

    @Override
    public String toString() {
        return  "Name : "+name+"\n"+"Account No : "+account_no+"\n"+"Bank Amount : "+bankAccount.getBalance()+"\n";
    }

    @Override
    public void run(){
        System.out.println(currentThread());
        bankAccount.withdraw(amount);
    }



}
public class BankSystem {
    public static void main(String[] args) {
        BankAccount bankAccount=new BankAccount(100000.0);
        Thread account_holder1=new UserBankAccount(bankAccount,"Unnimaya","200633",500.0);
        Thread account_holder2=new UserBankAccount(bankAccount,"Sandra","200634",12000.0);
        account_holder1.start();
        account_holder2.start();
    }
}
//BankAccountThreadSynchronization:
//Create a BankAccount class with a withdraw method that is synchronized.
//Create multiple threads representing different account holders attempting to withdraw funds.
//Use synchronization to prevent concurrent access to the withdraw method and ensure thread safety.