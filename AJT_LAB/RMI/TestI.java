import java.rmi.*;
public interface TestI extends Remote
{
	public String hello(String hello) throws RemoteException;
}