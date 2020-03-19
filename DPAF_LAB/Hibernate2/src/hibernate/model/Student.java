/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Yash
 */
@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue
    private int studentId;
    private String studentName;

    public Student() {
    }

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<StudentCertification> studentCertification = new HashSet<StudentCertification>(0);

    public Set<StudentCertification> getStudentCertification() {
        return studentCertification;
    }

    public void setStudentCertification(Set<StudentCertification> studentCertification) {
        this.studentCertification = studentCertification;
    }

}
