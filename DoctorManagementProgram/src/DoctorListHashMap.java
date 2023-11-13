
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoaht
 */
public class DoctorListHashMap extends HashMap<String, Doctor>{

    public DoctorListHashMap() {
    }
    
    public void addDoctor() {
        String code = "";
        do {
            code = Enter.enter_str_nonBlank("Enter doctor code: ");
            
            if (this.containsKey(code.toUpperCase())) System.out.println("This doctor code is exist!");
        } while (this.containsKey(code.toUpperCase()));
        
        String doctorName = Enter.enter_str_nonBlank("Enter doctor name: ");
        String doctorSpecialization = Enter.enter_str_nonBlank("Enter doctor specilization: ");
        int doctorAvailability = Enter.enter_int("Enter doctor availability: ", 0);
        Doctor newDoctor = new Doctor(code, doctorName, doctorSpecialization, doctorAvailability);
        this.put(code.toUpperCase(), newDoctor);
        System.out.println("Add doctor " + code.toUpperCase() + " success!");
    }
    
    public void updateDoctor() {
        if (this.isEmpty()) System.out.println("Doctor list is empty cannot update!");
        else {
            String codeDoctor = Enter.enter_str("Enter doctor code to update: ");
            
            if (!this.containsKey(codeDoctor.toUpperCase())) {
                System.out.println("Doctor with code " + codeDoctor + " is not exsit!");
            } else {
                Doctor doctorUpdate = this.get(codeDoctor.toUpperCase());
                System.out.println("------ Doctor information ------");
                doctorUpdate.displatInformation();
                System.out.println("--------------------------------");
                System.out.println("<Please update doctor>");
                
                String newCode;
                do {
                    newCode = Enter.enter_str("Enter new doctor code: ");
                    
                    if (newCode.equalsIgnoreCase(doctorUpdate.getCode())) {
                        newCode = doctorUpdate.getCode();
                        break;
                    }
                    
                    if (this.containsKey(newCode.toUpperCase())) System.out.println("This doctor code is exist!");
                } while (this.containsKey(newCode.toUpperCase()));
                
                if (newCode.length() == 0) newCode = doctorUpdate.getCode();
                
                String newName = Enter.enter_str("Enter new doctor name: ");
                if (newName.length() == 0) newName = doctorUpdate.getName();
                
                String newSpecilization = Enter.enter_str("Enter new doctor specilization: ");
                if (newSpecilization.length() == 0) newSpecilization = doctorUpdate.getSpecialization();
                
                int newAvailability = Enter.enter_int_withSpace("Enter new doctor availability: ", doctorUpdate.getAvailability(), 0);
                
                doctorUpdate.setCode(newCode);
                doctorUpdate.setName(newName);
                doctorUpdate.setSpecialization(newSpecilization);
                doctorUpdate.setAvailability(newAvailability);
                System.out.println("Update doctor success!");
            }
        }
    }
    
    public void deleteDoctor() {
        if (this.isEmpty()) System.out.println("Doctor list is empty cannot delete!");
        else {
            String codeDoctor = Enter.enter_str("Enter doctor code to delete: ");
            
            if (!this.containsKey(codeDoctor.toUpperCase())) {
                System.out.println("Doctor with code " + codeDoctor + " is not exsit!");
            } else {
                Boolean isDelete = Enter.enter_boolean("Are you sure do delete this doctor [Y-N]: ");
                
                if (isDelete) {
                    this.remove(codeDoctor.toUpperCase());
                    System.out.println("Remove doctor success!");
                }
            }
        }
    }
    
    public void displayListDoctor(HashMap<String, Doctor> listDocHashMap) {
        System.out.printf("%-10s %-15s %-15s %-15s\n", "Code", "Name", "Specialization", "Availability");
        listDocHashMap.forEach((code, objDoctor) -> {
            System.out.printf("%-10s %-15s %-15s %-15d\n", objDoctor.getCode(), objDoctor.getName(), objDoctor.getSpecialization(), objDoctor.getAvailability());
        });
    }
    
    public void searchDoctor() {
        if (this.isEmpty()) System.out.println("Doctor list is empty cannot search!");
        else {
            String doctorName = Enter.enter_str("Enter doctor name to search: ");
            
            HashMap<String, Doctor> listDoctorSearch = new HashMap<>();
            this.forEach((code, objDoctor) -> {
                if (objDoctor.getName().toUpperCase().contains(doctorName.toUpperCase().trim())) {
                    listDoctorSearch.put(code, objDoctor);
                }
            });
            
            if (listDoctorSearch.isEmpty()) System.out.println("There are no doctors that contain " + doctorName + " in their names");
            else {
                System.out.println("---------------------- List doctor ----------------------");
                displayListDoctor(listDoctorSearch);
                System.out.println("Total: " + listDoctorSearch.size());
                System.out.println("----------------------------------------------------------");
            }
        }
    }
    
    public void test() {
        this.put("D01", new Doctor("D01", "Hoa", "Hear", 1));
        this.put("D02", new Doctor("D02", "Hung", "Head", 2));
        this.put("D03", new Doctor("D03", "Dung", "Leg", 0));
        this.put("D04", new Doctor("D04", "Ha", "Body", -1));
    }
}
