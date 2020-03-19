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
        
        Student s1 = new Student(1,"a");
        Student s2 = new Student(2,"b");
        Student s3 = new Student(3,"c");
        
        Exam e1 = new Exam(1,"x");
        Exam e2 = new Exam(2,"y");
        Exam e3 = new Exam(3,"z");
        
        s1.addExam(e1);
        s1.addExam(e2);
        s1.addExam(e3);
        
        e2.addStudent(s2);
        e2.addStudent(s3);
        
        s3.addExam(e3);
        
        System.out.println("Student 1 appeared in:");
        s1.showExam();
        System.out.println("Student 2 appeared in:");
        s2.showExam();
        System.out.println("Student 3 appeared in:");
        s3.showExam();
        System.out.println("Exam 1 was taken by:");
        e1.showStudent();
        System.out.println("Exam 2 was taken by:");
        e2.showStudent();
        System.out.println("Exam 3 was taken by:");
        e3.showStudent();
    }
    
}
