/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoaht
 */
public class DemoApp {
    public static void main(String[] args) {
        DoctorListHashMap doctorListHashMap = new DoctorListHashMap();  // Use hash map to manage list doctors
        doctorListHashMap.test();  // Test add some information to hash map
//        DoctorList doctorList = new DoctorList();  // User List to manage list doctors
//        doctorList.test();
        
        String[] options = {"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"};
        
        while (true) {
            System.out.println("======================= Menu =======================");
            Menu.printMenu(options);
            System.out.println("====================================================");
            
            int choice = Menu.getChoiceFromMenu(options);
            
            switch (choice) {
                case 1: doctorListHashMap.addDoctor(); break;
                case 2: doctorListHashMap.updateDoctor(); break;
                case 3: doctorListHashMap.deleteDoctor(); break;
                case 4: doctorListHashMap.searchDoctor(); break;
                case 5: System.exit(0); break;
            }
        }
    }
}
