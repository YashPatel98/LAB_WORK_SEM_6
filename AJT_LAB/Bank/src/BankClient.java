
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yash
 */
public class BankClient {

    public static void main(String[] args) {
        try {
            //System.setSecurityManager(new RMISecurityManager());
            // BankI bi = (BankI) Naming.lookup("rmi://127.0.0.1:1088/Test");
            Registry reg = LocateRegistry.getRegistry("localhost", 9999);
            BankI bi = (BankI) reg.lookup("server");
            Scanner sc = new Scanner(System.in);
            char c = 0;
            System.out.print("\nEnter Accoount No.: ");
            int an = sc.nextInt();
            do {
                System.out.println("\n1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Show Balance");
                System.out.println("4. Other Account Transaction");
                System.out.println("Enter Your Choice: ");
                int x = sc.nextInt();
                double a = 0;
                switch (x) {
                    case 1:
                        System.out.println("Enter Amount to be deposited: ");
                        a = sc.nextDouble();
                        System.out.println(bi.Deposit(an, a));
                        break;
                    case 2:
                        System.out.println("Enter Amount to be Withdrawn: ");
                        a = sc.nextDouble();
                        System.out.println(bi.Withdraw(an, a));
                        break;
                    case 3:
                        System.out.println(bi.showBalance(an));
                        break;
                    case 4:
                        System.out.print("\nEnter Accoount No.: ");
                        an = sc.nextInt();
                        break;
                        
                }
                System.out.print("\nMore Transaction?(y/n): ");
                c = sc.next().charAt(0);
            } while (c == 'y');
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
