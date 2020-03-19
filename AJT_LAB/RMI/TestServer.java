import java.rmi.*;
import java.rmi.server.*;
public class TestServer extends UnicastRemoteObject implements TestI
{
	public TestServer() throws RemoteException
	{
	}
	public String hello(String msg)
	{
		return "Server says: "+msg;
	}
	public static void main(String[] args)
	{
		try{
			TestServer tso = new TestServer();
			Naming.rebind("rmi://127.0.0.1:1099/Test",tso);
		}catch(Exception e)
		{
			System.out.println("Exception: "+e);
		}
	}
}