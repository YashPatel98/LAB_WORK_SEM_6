import java.rmi.*;
public interface BankI extends Remote{
    public String Deposit(int accno,double amt)throws RemoteException;
    public String Withdraw(int accno,double amt) throws RemoteException;
    public String showBalance(int accno)throws RemoteException;           
}
