
import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yash
 */
public class BankImpl extends UnicastRemoteObject implements BankI {

    String url = "jdbc:derby://localhost:1527/bank";
    String driver = "org.apache.derby.jdbc.ClientDriver";
    Connection cn = null;
    PreparedStatement pstat = null;
    ResultSet rs = null;

    public BankImpl() throws RemoteException {
        try {
            Class.forName(driver);
            cn = DriverManager.getConnection(url, "it88", "yash");
        } catch (ClassNotFoundException e) {
            System.out.println("Exception: " + e.toString());
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex);
        }
    }

    @Override
    public String Deposit(int accno, double amt) throws RemoteException {
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
        String query = "UPDATE Bank set Balance=? where AccountNo=?";
        try {
            pstat = cn.prepareStatement(query);
            pstat.setDouble(1, (bal + amt));
            pstat.setInt(2, accno);
            pstat.executeUpdate();
            System.out.println("Deposit:"+amt+"\tAccount No: " +accno +"\tBalance: "+bal);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return "Deposit successful!";
    }

    @Override
    public String Withdraw(int accno, double amt) throws RemoteException {
        String getbal = "Select Balance from Bank where AccountNo=?";
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
            String query = "UPDATE Bank set Balance=? where AccountNo=?";
            try {
                pstat = cn.prepareStatement(query);
                pstat.setDouble(1, (bal - amt));
                pstat.setInt(2, accno);
                pstat.executeUpdate();
                System.out.println("Withdraw:"+amt+"\tAccount No: " +accno +"\tBalance: "+bal);
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
            return "Withdraw successful!";
        } else {
            return "Insufficient balance";
        }
    }

    @Override
    public String showBalance(int accno) throws RemoteException {
        String getbal = "Select Balance from Bank where AccountNo=?";
        double bal = 0;
        try {
            pstat = cn.prepareStatement(getbal);
            pstat.setInt(1, accno);
            rs = pstat.executeQuery();
         
            while (rs.next()) {
                bal = rs.getDouble(1);
            }
            System.out.println("Account No: " +accno +"\tBalance: "+bal);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return "Your Balance is " + bal;
    }
}
