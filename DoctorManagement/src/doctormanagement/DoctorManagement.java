/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormanagement;

/**
 *
 * @author hoaht
 */
public class DoctorManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoctorList doctorList = new DoctorList();
        
        String[] menuOptions = {"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"};
        while (true) {
            System.out.println("========= Doctor Management ==========");
            Menu.printMenu(menuOptions);
            int choice = Menu.getChoiceFromMenu(menuOptions);
            
            switch (choice) {
                case 1: doctorList.addDoctor(); break;
                case 2: doctorList.updateDoctor(); break;
                case 3: doctorList.deleteDoctor(); break;
                case 4: doctorList.searchDoctor(); break;
                case 5: System.exit(0);
            }
        }
    }
    
}
