/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.user;

import hibernate.model.Student;
import hibernate.model.StudentCertification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Yash
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentCertification sc1 = new StudentCertification();
        sc1.setCertificationName("Java");
        StudentCertification sc2 = new StudentCertification();
        sc2.setCertificationName("Design Patterns");
        StudentCertification sc3 = new StudentCertification();
        sc3.setCertificationName("C++");

        Student st1 = new Student();
        st1.setStudentName("Kamal");
        (st1.getStudentCertification()).add(sc2);
        (st1.getStudentCertification()).add(sc3);
        Student st2 = new Student();
        st2.setStudentName("Radha");
        (st2.getStudentCertification()).add(sc1);
        Student st3 = new Student();
        st3.setStudentName("Kisan");
        (st3.getStudentCertification()).add(sc3);
        
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(st1);
        session.save(st2);
        session.save(st3);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

}
