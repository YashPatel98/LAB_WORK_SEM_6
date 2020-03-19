import java.rmi.*;
import java.rmi.server.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankServer extends UnicastRemoteObject implements BankI {

    String url = "jdbc:derby://localhost:1527/bank";
    String driver = "org.apache.derby.jdbc.ClientDriver";
    Connection cn = null;
    PreparedStatement pstat = null;
    ResultSet rs = null;

    public BankServer() throws RemoteException {
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url, "it88", "yash");
        } catch (ClassNotFoundException e) {
            System.out.println("" + e.toString());
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public String Deposit(int accno, double amt) throws RemoteException {
        String getbal = new String("Select Balance from Bank where AccountNo=?");
        double bal = 0;
        try {

			System.out.println("Account no. and Amount is"+accno+" "+amt);
		
            pstat = cn.prepareStatement(getbal);
            pstat.setInt(1, accno);
            rs = pstat.executeQuery();
			System.out.println("Resultset is:"+rs);
			
            while (rs.next()) {
                bal = rs.getDouble(1);
				System.out.println("Balance is:"+bal);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
		
		System.out.println("Before Update Query"+bal);
		
        String query = new String("UPDATE Bank set Balance=? where AccountNo=?");
		
		
        try {
            pstat = cn.prepareStatement(query);
            pstat.setDouble(1, (bal + amt));
            pstat.setInt(2, accno);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        System.out.println("The Update query is"+query);
		return "Deposit successful!";
    }

    public String Withdraw(int accno, double amt) throws RemoteException {
        String getbal = new String("Select Balance from Bank where AccountNo=?");
        double bal = 0;
        try {

            pstat = cn.prepareStatement(getbal);
            pstat.setInt(1, accno);
            rs = pstat.executeQuery();
            while (rs.next()) {
                bal = rs.getDouble(1);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        if (bal > amt) {
            String query = new String("UPDATE Bank set Balance=? where AccountNo=?");
            try {
                pstat = cn.prepareStatement(query);
                pstat.setDouble(1, (bal - amt));
                pstat.setInt(2, accno);
            } catch (Exception e) {
				System.out.println("Exception: " + e);
			}
            return "Withdraw successful!";
        } else {
            return "Insufficenet balance";
        }
    }

    public String showBalance(int accno) throws RemoteException {
        String getbal = new String("Select Balance from Bank where AccountNo=?");
        double bal = 0;
        try {

            pstat = cn.prepareStatement(getbal);
            pstat.setInt(1, accno);
            rs = pstat.executeQuery();
            while (rs.next()) {
                bal = rs.getDouble(1);
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return "Your Balance is " + bal;
    }

    public static void main(String[] args) {
        try {
            BankServer tso = new BankServer();
            Naming.rebind("rmi://127.0.0.1:1099/Test", tso);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
