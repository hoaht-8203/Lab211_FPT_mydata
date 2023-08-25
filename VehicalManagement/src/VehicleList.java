
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
public class VehicleList extends ArrayList<Vehicle>{
    
    public VehicleList() {
    }
    
    public void loadFromFile(String fileName) {
        boolean checkLoad = true;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while(true) {
                line = br.readLine();
                
                if(line == null){
                    break;
                }
                
                try {
                    String data[] = line.split("[:,]");
                
                    String id = data[1];
                    
                    if (checkDuplicateId(id) == false) {
                        String name = data[2]; 
                        String color = data[3];
                        String brand = data[4];
                        double price = Double.parseDouble(data[5]);

                        String typeVehicle = data[0];
                        if (typeVehicle.equalsIgnoreCase("Car")) {
                            String type = data[6];
                            int yearOfManufacture = Integer.parseInt(data[7]);

                            Vehicle car = new Car(id, name, color, brand, price, type, yearOfManufacture);
                            this.add(car);
                        }else {
                            double speed = Double.parseDouble(data[6]);
                            boolean license = Boolean.parseBoolean(data[7]);

                            Vehicle motor = new Motorbike(id, name, color, brand, price, speed, license);
                            this.add(motor);
                        }
                    }
                } catch (NumberFormatException e) {
                    checkLoad = false;
                }
            }   
        } catch (IOException | NumberFormatException e) {
           checkLoad = false;
        }
        
        if (checkLoad) System.out.println("Load from file [" + fileName + "] success!"); 
        else System.out.println("Load from file [" + fileName + "] failed!");
    }
    
    public void saveToFile(String fileName) {
        boolean checkSave = true;
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Vehicle v : this) {
                bw.write(v.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            checkSave = false;
        }
        
        if (checkSave) System.out.println("Save to file [" + fileName + "] success!"); 
        else System.out.println("Save to file [" + fileName + "] failed!");
    }   
    
    public boolean checkDuplicateId(String id) {
        for (Vehicle v : this) {
            if (v.getId().equalsIgnoreCase(id.trim())) {
                return true;
            }
        }
        
        return false;
    }
    
    public int searchId(String id) {
        for (Vehicle v : this) {
            if (v.getId().equalsIgnoreCase(id.trim())) {
                return this.indexOf(v);
            }
        }
        
        return -1;
    }
    
    public List<Vehicle> searchName(String name) {
        List<Vehicle> listVehicle = new ArrayList<>();
        for (Vehicle v : this) {
            if (v.getName().toUpperCase().contains(name.trim().toUpperCase())) {
                listVehicle.add(v);
            }
        }
        
        return listVehicle;
    }

    public void addVehicle() {
        String vehicleOptions[] = {"Car", "Mortorbike"};
        boolean continueAdd;
        do {
            System.out.println("+---- Choose Vehicle ----+");
            Menu.printMenu(vehicleOptions);
            System.out.println("--------------------------");
            int choice = Input.input_rangeNumber("Enter your choice[1-2]:", 1, 2);

            String id;
            do {
                id = Input.input_nonBlankStr("Enter vehicle ID: ");

                if (checkDuplicateId(id)) System.out.println("ID cannot duplicate!");
            } while (checkDuplicateId(id) == true);

            String name = Input.input_nonBlankStr("Enter vehicle name: ");
            String color = Input.input_nonBlankStr("Enter vehicle color: ");
            String brand = Input.input_nonBlankStr("Enter vehicle brand: ");
            double price = Input.input_rangeNumber("Enter price: ", 0);

            if (choice == 1) {
                String type = Input.input_nonBlankStr("Enter type (sport, travel, etc.): ");
                int yearOfManufacture = Input.input_rangeNumber("Enter year of manufacture: ", 1885, 2023);

                Vehicle car = new Car(id, name, color, brand, price, type, yearOfManufacture);
                this.add(car);
                System.out.println("Add new Car success!");
            }else if (choice == 2) {
                double speed = Input.input_rangeNumber("Enter speed: ", 0);
                boolean license = Input.input_boolean("Enter license", "Y", "N");

                Vehicle motor = new Motorbike(id, name, color, brand, price, speed, license);
                this.add(motor);
                System.out.println("Add new Motor success!");
            }
            
            continueAdd = Input.input_boolean("Do you want to add more vehicle", "Y", "N");
        } while (continueAdd);
    }
    
    public void updateVehicle() {
        if (this.size() <= 0) {
            System.out.println("List Empty! cannot update");
        } else {
            String id = Input.input_str("Enter ID to update: ");
            int index = searchId(id);
            
            if (index < 0) {
                System.out.println("“Vehicle does not exist!");
            } else {
                Vehicle v = this.get(index);
                
                String newName = Input.input_str("Old name: " + v.getName() + ". Enter new name: ");
                if (newName.length() == 0) newName = v.getName();
                String newColor = Input.input_str("Old color: " + v.getColor() + ". Enter new color: ");
                if (newColor.length() == 0) newColor = v.getColor();
                String newBrand = Input.input_str("Old brand: " + v.getBrand() + ". Enter new brand: ");
                if (newBrand.length() == 0) newBrand = v.getBrand();
                double newPrice = Input.input_rangeNumber("Old price: " + v.getPrice() + ". Enter new price: ", 0);
                
                
                if (v instanceof Car) {
                    String newType = Input.input_str("Old type: " + ((Car) v).getType() + ". Enter new type (sport, travel, etc.): ");
                    if (newType.length() == 0) newType = ((Car) v).getType();
                    int newYearOfManufacture = Input.input_rangeNumber("Old Year of manufacture: " + ((Car) v).getYearOfManufacture() + ". Enter new year of manufacture: ", 1885, 2023);
                    
                    ((Car) v).update(newName, newColor, newBrand, newPrice, newType, newYearOfManufacture);
                    System.out.println("Update Car success. Your car now: ");
                }else if (v instanceof Motorbike) {
                    double newSpeed = Input.input_rangeNumber("Old speed: " + ((Motorbike) v).getSpeed() + ". Enter new speed: ", 0);
                    boolean newLicense = Input.input_boolean("Old license: " + ((Motorbike) v).isLicense() + ". Enter new license", "Y", "N");
                    
                    ((Motorbike) v).update(newName, newColor, newBrand, newPrice, newSpeed, newLicense);
                    System.out.println("Update Motorbike success. Your motor now: ");
                }
                System.out.println(v.printMenu());
            }
        }
    }
    
    public void searchVehicleById() {
        if (this.size() <= 0) {
            System.out.println("List Empty! cannot search");
        } else {
            String id = Input.input_str("Enter ID to search: ");
            int index = searchId(id);
            
            if (index < 0) {
                System.out.println("This ID is not exist!");
            } else {
                Vehicle v = this.get(index);
                System.out.println("Your Vehicle: ");
                System.out.println(v.printMenu());
            }
        }
    }
    
    public void searchVehicleByName() {
        if (this.size() <= 0) {
            System.out.println("List Empty! cannot search");
        } else {
            String nameVehicle = Input.input_str("Enter vehicle name to search: ");
            List<Vehicle> listVehicleByName = searchName(nameVehicle);
            
            if (listVehicleByName.isEmpty()) {
                System.out.println("This name vehicle is not exist!");
            } else {
                System.out.println("List vehicle contain " + nameVehicle + " in name is: ");
                
                for (Vehicle vehicle : listVehicleByName) {
                    System.out.println(vehicle.printMenu());
                }
            }
        }
    }
    
    public void listVehicle() {
        System.out.println("------------------ List Vehicle ------------------");
        if (this.size() <= 0) {
            System.out.println("List Empty!");
        } else {
            for (Vehicle v : this) {
                System.out.println(v.printMenu());
            }
        }
        System.out.println("--------------------------------------------------");
    }
    
    public void listVehiclePriceDesc() {
        System.out.println("------------------ List Vehicle ------------------");
        if (this.size() <= 0) {
            System.out.println("List Empty!");
        } else {
            Collections.sort(this, new Comparator<Vehicle>() {
                @Override
                public int compare(Vehicle v1, Vehicle v2) {
                    return (int) (v2.getPrice() - v1.getPrice());
                }
            });
            
            for (Vehicle v : this) {
                if (v instanceof Motorbike) {
                    ((Motorbike) v).makeSound();
                }
                
                System.out.println(v.printMenu());
            }
        }
        System.out.println("--------------------------------------------------");
    }
    
    public void deleteVehicle() {
        if (this.size() <= 0) {
            System.out.println("List Empty! cannot delete");
        } else {
            String id = Input.input_str("Enter ID to delete: ");
            int index = searchId(id);
            
            if (index < 0) {
                System.out.println("This ID is not exist!");
            } else {
                boolean confirmDelete = Input.input_boolean("Are you sure to delete this vehivle", "Y", "N");
                
                if (confirmDelete) {
                    boolean remove = this.remove(this.get(index));
                    if (remove) System.out.println("Delete success!");
                    else System.out.println("Delete failed!");
                }
            }
        }
    }
}
