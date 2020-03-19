
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yash
 */
@Entity
public class StudentDetails {
    @Id @GeneratedValue(generator = "newGenerator")
    @GenericGenerator(name="newGenerator" ,strategy = "foreign" ,parameters ={@Parameter(value="student",name="property")})
    private int student_id;
    private String student_address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_id")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    public int getStudent_id() {
        return student_id;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }
    
}
