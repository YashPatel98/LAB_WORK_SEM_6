/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.user;

import hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Yash
 */
public class Main {

    public static void main(String[] args) {
        Student st1 = new Student("Harshad", "Prajapati", 6);
        Student st2 = new Student("Yash", "Patel", 6);
        Student st3 = new Student("ABC", "XYZ", 6);
        //Build session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        //Create a session
        Session session = sessionFactory.openSession();
        //Create a transaction to start interaction
        session.beginTransaction();
        session.save(st1);
        session.save(st2);
        session.save(st3);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
