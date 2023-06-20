package Bank.Application;


public class Main {
    public static void main(String[] args) {

        SBI.rateOfInterest = 7;
        HDFCBank.rateOfInterest = 8;

    SBI account1 = new SBI(100000,"123","Vindhya");
    SBI account2 = new SBI(200000,"456","Adithya");

    HDFCBank account3 = new HDFCBank(150000,"789","Lowkya");

    //wrong password
    int balance = account1.checkBalance("124");
    System.out.println("The balance of account1 is "+balance);

    // right password check balance
    int balanceCheck  = account1.checkBalance("123");
    System.out.println("The balance of account1 is "+balanceCheck);

    //add money
    String bankMessage = account2.addMoney(50000);
    System.out.println(bankMessage);


    String message = account3.withdrawMoney(10000,"1523");
    System.out.println(message);

    String message1 = account3.withdrawMoney(10000,"789");
    System.out.println(message1);

    double interest = account1.calculateTotalInterest(20);
    System.out.println("The total interest you get is "+interest);

    double interest1 = account3.calculateTotalInterest(20);
        System.out.println("The total interest you get is "+interest1);
    }
}