package Bank.Application;

import java.util.Objects;
import java.util.UUID;

public class HDFCBank implements BankInterface{

    private int balance;
    private String accountNo;
    private String password;
    public String name;
    public static double rateOfInterest;

    public HDFCBank(int balance, String password, String name) {
        this.accountNo = UUID.randomUUID().toString();
        this.balance = balance;
        this.password = password;
        this.name = name;
    }


    @Override
    public int checkBalance(String password) {
        if(password.equals(this.password))
            return balance;

        return -1;
    }

    @Override
    public String addMoney(int money) {
        balance = balance+money;
        return money+" has been credited to your bank accout "+accountNo;
    }

    @Override
    public String withdrawMoney(int money, String password) {
        if(Objects.equals(password, this.password)){
            if(money>balance)
                return "Insufficient balance";
            else {
                balance = balance - money;
                return "Money has been withdrawn successfully";
            }
        }
        return "wrong password";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password .equals( oldPassword)){
            this.password = newPassword;
            return "Password has been changed successfully";
        }
        else{
            return "Wrong password";
        }
    }

    @Override
    public double calculateTotalInterest(int years) {
        return balance*rateOfInterest*years/100;
    }
}
