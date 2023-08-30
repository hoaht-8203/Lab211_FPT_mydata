/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doctormanagement;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoaht
 */
public class DoctorList extends ArrayList<Doctor>{

    public DoctorList() {
    }
    
    public boolean isDuplicateId(String id) {
        for (Doctor d : this) {
            if (d.getCode().equalsIgnoreCase(id)) return true;
        }
        
        return false;
    }
    
    public void addDoctor() {
        System.out.println("--------- Add Doctor ----------");
        String code;
        do {
            code = Input.input_nonBlankStr("Enter code: ");
        } while (isDuplicateId(code));
        String name = Input.input_nonBlankStr("Enter name: ");
        String specialization = Input.input_nonBlankStr("Enter specialization: ");
        int availability = Input.input_int("Enter availability: ", 1);
        
        Doctor d = new Doctor(code, name, specialization, availability);
        this.add(d);
        System.out.println("Add new doctor success!");
    }
    
    public int searchDoctorbyId(String id) {
        for (Doctor d : this) {
            if (d.getCode().equalsIgnoreCase(id)) {
                return this.indexOf(d);
            }
        }
        
        return -1;
    }
    
    public List<Doctor> searchDoctorByName(String name) {
        List<Doctor> listDoctors = new ArrayList<>();
        for (Doctor d : this) {
            if (d.getName().toLowerCase().contains(name.toLowerCase())) {
                listDoctors.add(d);
            }
        }
        
        return listDoctors;
    }
    
    public void updateDoctor() {
        System.out.println("--------- Update Doctor -------");
        String code = Input.input_str("Enter code to update: ");
        int index = searchDoctorbyId(code);
        if (index == -1) {
            System.out.println("This docter is not exits!"); 
        } else {
            Doctor doctor = this.get(index);
            String newName = Input.input_str("Old name: " + doctor.getName() + ". Enter new name: ");
            if (newName.length() == 0) newName = doctor.getName();
            String newSpecialization = Input.input_str("Old specialization: " + doctor.getSpecialization()+ ". Enter new specialization: ");
            if (newSpecialization.length() == 0) newSpecialization = doctor.getSpecialization();
            int newAvailability = Input.input_int("Old availability: " + doctor.getAvailability()+ ". Enter new availability: ", 1);
            
            doctor.setName(newName);
            doctor.setSpecialization(newSpecialization);
            doctor.setAvailability(newAvailability);
            System.out.println("Update doctor success!");
        }
    }
    
    public void deleteDoctor() {
        System.out.println("--------- Delete Doctor -------");
        String code = Input.input_str("Enter code to delete: ");
        int index = searchDoctorbyId(code);
        if (index == -1) {
            System.out.println("This docter is not exits!"); 
        } else {
            this.remove(this.get(index));
            System.out.println("Delete doctor success!");
        }
    }
    
    public void searchDoctor() {
        String name = Input.input_str("Enter name doctor to search: ");
        
        List<Doctor> listDoctors = searchDoctorByName(name);
        if (listDoctors.isEmpty()) {
            System.out.println("Dont has any doctor with name is " + name);
        } else {
            System.out.println("--------- Result ------------");
            System.out.printf("%-10s %-15s %-15s %-10s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor d : listDoctors) {
                d.diplay();
            }
        }
    } 
}
