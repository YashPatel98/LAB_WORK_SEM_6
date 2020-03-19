
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yash
 */
public class BankServer {

    public static void main(String[] args) {
        try {
            BankI b = new BankImpl();
           // Naming.rebind("rmi://127.0.0.1:1088/Test", b);
            Registry reg = LocateRegistry.createRegistry(9999);
            reg.rebind("server", b);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
