import java.rmi.*;
public class TestClient
{
	public static void main(String[] args)
	{
		try{
			System.setSecurityManager(new RMISecurityManager());
			TestI tsi = (TestI) Naming.lookup("rmi://127.0.0.1:1099/Test");
			System.out.println("Result = "+tsi.hello("How r u"));
		}catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
	}
}