
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yash
 */
public class Student {

    private int studentId;
    private String studentName;
    ArrayList<Exam> examList = new ArrayList<Exam>();

    public Student() {
    }

    public Student(int studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    

    public void addExam(Exam e) {
        int flag = 0;
        for (Exam ex : examList) {
            if (ex.getExamCode() == e.getExamCode()) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            examList.add(e);
            e.addStudent(this);
        }
    }

    public void showExam() {
        for (Exam e : examList) {
            System.out.println("\tExam Code: " + e.getExamCode() + "\tSubject Name: " + e.getSubjectName());
        }
    }
}
