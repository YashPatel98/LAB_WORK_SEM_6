/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exp1;

/**
 *
 * @author user1
 */
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class TelephoneDirectory extends Frame implements ItemListener,ActionListener
{
    Panel pTop=new Panel();
    TextField tf1=new TextField(20);
    TextArea ta1=new TextArea(10, 100);
    Choice c1=new Choice();
    Choice c2=new Choice();
    Button srchbtn=new Button("Search");
    //Button newRec=new Button("Insert Record");
    Label status=new Label("Records Found = 0");
    String query=null;
    Connection cn=null;
    PreparedStatement pstat=null;
    ResultSet rs=null;
    public TelephoneDirectory()
    {
        super("My Telephone Directory");
        setVisible(true);
        setSize(800,400);
        c1.add("Telephone No");
        c1.add("Name");
        c1.add("Address");
        c1.addItemListener(this);
        srchbtn.addActionListener(this);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
                dispose();
            }
        });
        setLayout(new BorderLayout());
        pTop.setLayout(new GridLayout(4, 2));
        pTop.add(new Label("Search Option 1 : "));
        pTop.add(c1);
        pTop.add(new Label("Search Option 2 : "));
        pTop.add(c2);
        c2.setVisible(false);
        pTop.add(new Label("Enter Text : "));
        pTop.add(tf1);
        pTop.add(new Label(""));
        pTop.add(srchbtn);
       // pTop.add(newRec);
        add("North",pTop);
        add("Center",ta1);
        add("South",status);
        ta1.setEditable(false);
        // Initialization of Connection Object
        String url="jdbc:derby://localhost:1527/TELEDIR";
        String driver="org.apache.derby.jdbc.ClientDriver";
        try{
                Class.forName(driver);
                cn=DriverManager.getConnection(url, "it88", "yash");
                Statement cstmt = cn.createStatement();
               // cstmt.executeUpdate("insert into IT88.TELEDIR(Number,First_Name,Middle_Name,Last_Name,Area,City)Values(8596048693,'ABC','XYZ','CDE','HFKJS','FEDF')");
               // cstmt.executeUpdate("delete from IT88.TELEDIR where Number=8596048693");
            }
        catch(ClassNotFoundException e)
        {
            System.out.println(""+e.toString());
        }
        catch(SQLException se)
        {
            while(se!=null)
            {
                System.out.println(""+se.toString());
                se=se.getNextException();
            }
        }
    }
    public void itemStateChanged(ItemEvent ee)
    {
        String arg=ee.getItem().toString();
        if(arg.equals("Telephone No"))
        {
            c2.setVisible(false);
        }
        else if(arg.equals("Name"))
        {
            c2.removeAll();
            c2.add("First Name");
            c2.add("Middle Name");
            c2.add("Last Name");
            c2.setVisible(true);
        }
        else if(arg.equals("Address"))
        {
            c2.removeAll();
            c2.add("Area");
            c2.add("City");
            c2.setVisible(true);
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        ta1.setText("Refreshed");
        query=new String("SELECT * FROM IT88.TELEDIR");
        int len=0;
        len=tf1.getText().toString().trim().length();
        try
        {
            if(c1.getSelectedItem().equals(("Telephone No")) && len>0)
            {
                query+=" where Number=?";
                pstat=cn.prepareStatement(query);
                pstat.setString(1, tf1.getText().toString().trim());
            }
            else if(c1.getSelectedItem().equals(("Name")) && len>0)
            {
                if(c2.getSelectedItem().equals(("First Name")))
                    query += " where First_Name=?";
                else if(c2.getSelectedItem().equals(("Middle Name")))
                    query += " where Middle_Name=?";
                else if(c2.getSelectedItem().equals(("Last Name")))
                    query += " where Last_Name=?";
                pstat=cn.prepareStatement(query);
                pstat.setString(1, tf1.getText().toString().trim());
            }
            else if(c1.getSelectedItem().equals(("Address")) && len>0)
            {   
                if(c2.getSelectedItem().equals(("Area")))
                    query += " where Area=?";
                else if(c2.getSelectedItem().equals(("City")))
                    query += " where City=?";
                pstat=cn.prepareStatement(query);
                pstat.setString(1, tf1.getText().toString().trim());
            }
            else
            {
                pstat=cn.prepareStatement(query);
            }
            try
            {
                System.out.println(query);
                rs=pstat.executeQuery();
            }catch(NullPointerException ne)
            {
                System.out.println("Text Null3");
                ta1.setText("No Records Found.");
                status.setText("Records Found = 0");
            }
            if(rs!=null)
            ta1.setText("Number\t\tFName\t\tMName\t\tLNAME\t\tArea\t\tCity\n");
            int count=0;
            while(rs.next())
            {
                ta1.append("" + rs.getString(1) + "\t\t");
                ta1.append("" + rs.getString(2) + "\t\t");
                ta1.append("" + rs.getString(3) + "\t\t");
                ta1.append("" + rs.getString(4) + "\t");
                ta1.append("" + rs.getString(5) + "\t\t");
                ta1.append("" + rs.getString(6) + "\t\n");
                count++;
            }
            status.setText("Records Found = " + count);
        }
        catch(Exception ee){
            System.out.println("Exception " + ee);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
    Frame dir=new TelephoneDirectory();
    }
}
