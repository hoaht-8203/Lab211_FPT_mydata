/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoaht
 */
public class Student implements Comparable<Student>{
    private String studentId;
    private String studentName;
    private int semester;
    private String courseName;

    public Student() {
    }

    public Student(String studentId, String studentName, int semester, String courseName) {
        this.studentId = studentId.trim().toUpperCase();
        this.studentName = studentName.trim();
        this.semester = semester;
        this.courseName = courseName.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public int compareTo(Student s) {
        return this.getStudentName().compareTo(s.getStudentName());
    }
    
    public void printMenu() {
        System.out.printf("%-5s %-20s %-8s %-5d\n", studentId, studentName, courseName, semester);
    }
}
