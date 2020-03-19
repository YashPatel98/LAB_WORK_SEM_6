
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yash
 */
public class Exam {

    private int examCode;
    private String subjectName;
    ArrayList<Student> studentList = new ArrayList<Student>();

    public Exam() {
    }

    public Exam(int examCode, String subjectName) {
        this.examCode = examCode;
        this.subjectName = subjectName;
    }

    public int getExamCode() {
        return examCode;
    }

    public void setExamCode(int examCode) {
        this.examCode = examCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
   

    public void addStudent(Student s) { 
        int flag = 0;
        for (Student stu : studentList) {
            if (stu.getStudentId() == s.getStudentId()) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            studentList.add(s);
            s.addExam(this);
        }
    }

    public void showStudent() {
        for (Student s : studentList) {
            System.out.println("\tStudent Id: " + s.getStudentId() + "\tStudent Name: " + s.getStudentName());
        }
    }
}
