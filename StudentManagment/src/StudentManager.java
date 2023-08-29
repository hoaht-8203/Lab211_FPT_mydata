/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoaht
 */
public class StudentManager {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        
        String[] options = {"Create", "Find and Sort", "Update/Delete", "Report", "Exit"};
        String[] listCourses = {"Java", ".Net", "C/C++"};
        
        while (true) {
            System.out.println("------- Student Manager -------");
            Menu.printMenu(options);
            System.out.println("-------------------------------");
            int choice = Menu.getChoiceFromMenu(options);
            
            switch (choice) {
                case 1: 
                    studentList.add_student_withRange(5, listCourses);
                    break;
                case 2: 
                    studentList.findAndSort();
                    break;
                case 3: 
                    studentList.updateOrDelete(listCourses);
                    break;
                case 4: 
                    studentList.report();
                    break;
                case 5: 
                    System.exit(0);
                    break;
            }
        }
    }
}
