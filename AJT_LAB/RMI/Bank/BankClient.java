import java.rmi.*;
public class BankClient
{
	public static void main(String[] args)
	{
		try{
			System.setSecurityManager(new RMISecurityManager());
			BankI tsi = (BankI) Naming.lookup("rmi://127.0.0.1:1099/Test");
                        System.out.println("Result = "+tsi.showBalance(101));
                        System.out.println("Result = "+tsi.showBalance(102));
			System.out.println("Result = "+tsi.Deposit(101,30));
                        //System.out.println("Result = "+tsi.Withdraw(102,20));
                        System.out.println("Result = "+tsi.showBalance(101));
                        //System.out.println("Result = "+tsi.showBalance(102));
		}catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
	}
}

