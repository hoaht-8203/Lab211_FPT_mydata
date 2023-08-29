
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoaht
 */
public class StudentList extends ArrayList<Student>{

    public StudentList() {
    }
    
    public void add_student_withRange(int min, String[] listCourses) {
        boolean checkContinue = true;
        
        while (checkContinue) {
            add(listCourses);
            
            if (min != 0) --min;
            if (min == 0) {
                checkContinue = Input.input_boolean("Do you want to continue");
            }
        }
    }
    
    public int searchId(String studentId) {
        for (Student s : this) {
            if (s.getStudentId().equalsIgnoreCase(studentId.trim())) {
                return this.indexOf(s);
            }
        }
        
        return -1;
    }
    
    public List<Student> searchName(String studentName) {
        List<Student> listStudents = new ArrayList<>();
        for (Student s : this) {
            if (s.getStudentName().contains(studentName)) {
                listStudents.add(s);
            }
        }
        
        return listStudents;
    }
    
    public void add(String[] listCourses) {
        String studentId = Input.input_nonBlankStr("Enter student ID: ");
        String studentName = Input.input_nonBlankStr("Enter student name: ");
        int semester = Input.input_int_withRange("Enter semester: ", 0);
        String courseName = Input.input_str_withOptions("Enter course name ", listCourses);
        Student s = new Student(studentId, studentName, semester, courseName);
        this.add(s);
        System.out.println("Add student " + studentId + " success!");
    }
    
    public void findAndSort() {
        if (this.isEmpty()) {
            System.out.println("List student is empty. Cannot find!");
        } else {
            String studentName = Input.input_str("Enter student name to search: ");
            List<Student> listStudents = searchName(studentName);
            
            if (listStudents.isEmpty()) {
                System.out.println("Student " + studentName + " is not exist!");
            } else {
                Collections.sort(listStudents);
                System.out.println("List student contain " + studentName + " in name is: ");
                System.out.printf("%-5s %-20s %-8s %-5s\n", "ID", "Student name", "Course", "Semester");
                for (Student s : listStudents) {
                    s.printMenu();
                }
            }
        }
    }
    
    public void updateOrDelete(String[] listCourses) {
        if (this.isEmpty()) {
            System.out.println("List student is empty. Cannot find!");
        } else {
            String studentId = Input.input_str("Enter student ID: ");
            int index = searchId(studentId);
            
            if (index < 0) {
                System.out.println("This student ID is not exist!");
            } else {
                Student s = this.get(index);
                boolean choose = Input.input_boolean_withOptions("Do you want to update (U) or delete (D) student", "U", "D");
                
                if (choose) {
                    String studentNameNew = Input.input_nonBlankStr("Old name: " + s.getStudentName() + "Enter new student name: ");
                    int semesterNew = Input.input_int_withRange("Old semester: " + s.getSemester() + "Enter new semester: ", 0);
                    String courseNameNew = Input.input_str_withOptions("Old course: " + s.getCourseName() + "Enter new course name ", listCourses);
                    s.setStudentName(studentNameNew);
                    s.setSemester(semesterNew);
                    s.setCourseName(courseNameNew);
                    System.out.println("Update " + studentId + " student success!");
                } else {
                    boolean confirmDelete = Input.input_boolean("Are you sure to delete this student: ");
                    
                    if (confirmDelete) this.remove(s);
                }
            }
        }
    }
    
    public void report() {
        if (this.isEmpty()) {
            System.out.println("List student is empty. Cannot prinf report!");
        } else {
            List<Report> listReports = new ArrayList<>();
            
            for (Student s1 : this) {
                int count = 0;
                
                boolean checkExit = false;
                for (Report report : listReports) {
                    if (report.getCourseName().equalsIgnoreCase(s1.getCourseName()) && report.getStudentName().equalsIgnoreCase(s1.getStudentName())){
                        checkExit = true;
                        break;
                    }
                }
                
                if (checkExit == false) {
                    for (Student s2 : this) {
                        if (s1.getStudentId().equalsIgnoreCase(s2.getStudentId()) && s1.getCourseName().equalsIgnoreCase(s2.getCourseName())) {
                            count++;
                        }
                    }
                    
                    Report report = new Report(s1.getStudentName(), s1.getCourseName(), count);
                    listReports.add(report);
                }
            }
            
            for (Report report : listReports) {
                System.out.println(report.getStudentName()+ " | " + report.getCourseName() + " | " + report.getTotal());
            }
        }
    }
}
