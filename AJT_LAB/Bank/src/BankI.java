
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yash
 */
public interface BankI extends Remote{

    public String Deposit(int accno, double amt) throws RemoteException;

    public String Withdraw(int accno, double amt) throws RemoteException;

    public String showBalance(int accno) throws RemoteException;
}
