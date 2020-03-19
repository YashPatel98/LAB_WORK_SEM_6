/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it88;

import java.sql.*;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user1
 */
public class Registration extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        String cpass = request.getParameter("cpass");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String sem = request.getParameter("sem");
        String rollNo = request.getParameter("rollNo");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        if(pass.equals(cpass))
        {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Register","it88","yash");
            PreparedStatement ps1 = con.prepareStatement("select username from Register where username = ?");
            
            ResultSet rs = ps1.executeQuery();
            if(!rs.next()){
                PreparedStatement ps = con.prepareStatement("insert into register Values(?,?,?,?,?,?,?,?)");
                ps.setString(1,uname);
                ps.setString(2,pass);
                ps.setString(3,fname);
                ps.setString(4,lname);
                ps.setString(5,sem);
                ps.setString(6,rollNo);
                ps.setString(7,email);
                ps.setString(8,contact);
                int i = ps.executeUpdate();
                if(i>0)
                {
                    out.println("You have successfully registered...");
                    RequestDispatcher rd = request.getRequestDispatcher("index.html");
                    rd.include(request, response);
                }
            }
        }
        catch(Exception e2)
        {
            System.out.println(e2);
        }
        }
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("register.html");
            rd.include(request, response);
            out.println("Password not matching");
        }
     
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
