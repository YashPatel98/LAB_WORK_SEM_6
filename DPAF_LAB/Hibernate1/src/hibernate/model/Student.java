/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.model;

/**
 *
 * @author Yash
 */
public class Student {

    private int studentId;
    private String studentFirstName;
    private String studentLastName;
    private int studentSemester;

    public Student() {
    }

    public Student(String studentFirstName, String studentLastName, int studentSemester) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentSemester = studentSemester;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    
    public int getStudentId() {
        return studentId;
    }
    
    
    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public int getStudentSemester() {
        return studentSemester;
    }

    public void setStudentSemester(int studentSemester) {
        this.studentSemester = studentSemester;
    }
    
    
}
