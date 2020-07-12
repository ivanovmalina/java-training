package code._4_student_effort._2_bank_trans;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount momAccount = new BankAccount("mom", 100_000);
        BankAccount myAccount = new BankAccount("me", 100);

        System.out.println("before:");
        System.out.println(momAccount);
        System.out.println(myAccount);

        TransactionThread t1 = new TransactionThread("T1", momAccount, myAccount, 10);
        TransactionThread t2 = new TransactionThread("T2", momAccount, myAccount, 100);

        //start transacting
        t1.start();
        t2.start();

        //wait for transfers to be completed
        t1.join();
        t2.join();

        System.out.println("after:");
        System.out.println(momAccount);
        System.out.println(myAccount);
    }
}
