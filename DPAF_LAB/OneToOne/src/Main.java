
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yash
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student s1=new Student();
        s1.setStudent_name("ABC");
        StudentDetails sd1 = new StudentDetails();
        sd1.setStudent_address("XYZ");
        sd1.setStudent(s1);
        
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(sd1);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
    
}
