/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoaht
 */
public class VehicleManagment {
    public static void main(String[] args) {
        VehicleList vhl = new VehicleList();
        
        String[] options = {"Load data from file","Add new vehicle", "Update vehicle by ID", "Delete vehicle by ID", 
                            "Search vehicle", "Show vehicle list", "Store data to file", "Exit"};
        
        while (true) {
            System.out.println("------------- Vehicle Management -------------");
            Menu.printMenu(options);
            System.out.println("----------------------------------------------");
            int choice = Input.input_rangeNumber("Enter your choice[1-8]: ", 1, 8);
            
            switch (choice) {
                case 1:
                    vhl.loadFromFile("myvehicle.txt");
                    break;
                case 2:
                    vhl.addVehicle();
                    break;
                case 3:
                    vhl.updateVehicle();
                    break;
                case 4:
                    vhl.deleteVehicle();
                    break;
                case 5:
                    String searchOptions[] = {"Search by Name", "Search by id"};
                    Menu.printMenu(searchOptions);
                    int searchChoice = Input.input_rangeNumber("Enter your choice[1-2]: ", 1, 2);
                    
                    if (searchChoice == 1) {
                        vhl.searchVehicleByName();
                    } else if (searchChoice == 2) {
                        vhl.searchVehicleById();
                    }
                    
                    break;
                case 6:
                    String listOptions[] = {"Show all", "Show all (descending by price"};
                    Menu.printMenu(listOptions);
                    int listChoices = Input.input_rangeNumber("Enter your choice[1-2]: ", 1, 2);
                    
                    if (listChoices == 1) {
                        vhl.listVehicle();
                    } else if (listChoices == 2) {
                        vhl.listVehiclePriceDesc();
                    }
                    break;
                case 7:
                    vhl.saveToFile("myvehicle.txt");
                    break;
                case 8:
                    vhl.saveToFile("myvehicle.txt");
                    System.exit(0);
            }
        }
    }
}
