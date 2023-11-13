
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoaht
 */
public class DoctorList extends ArrayList<Doctor>{

    public DoctorList() {
    }
    
    public boolean isDuplicateCode(String code) {
        boolean bCoTrungLap = false;
        for (Doctor objDoctor : this) {
            if (objDoctor.getCode().equalsIgnoreCase(code.trim())) {
                bCoTrungLap = true;
                break;
            }
        }
        
        return bCoTrungLap;
    }
    
    public int searchDoctorByCode(String code) {
        int iDoctorIndex = -1; // -1 nghia la khong tim thay
        for (Doctor d : this) {
            if (d.getCode().equalsIgnoreCase(code.trim())) {
                iDoctorIndex = this.indexOf(d);
            }
        }
        
        return iDoctorIndex;
    }
    
    public void displayAll() {
        System.out.printf("%-10s %-15s %-15s %-15s\n", "Code", "Name", "Specialization", "Availability");
        for (Doctor d : this) {
            System.out.printf("%-10s %-15s %-15s %-15d\n", d.getCode(), d.getName(), d.getSpecialization(), d.getAvailability());
        }
    }
    
    public void displayListDoctor(Doctor[] doctors) {
        System.out.printf("%-10s %-15s %-15s %-15s\n", "Code", "Name", "Specialization", "Availability");
        for (Doctor d : doctors) {
            System.out.printf("%-10s %-15s %-15s %-15d\n", d.getCode(), d.getName(), d.getSpecialization(), d.getAvailability());
        }
    }
    
    public void addDoctor() {
        String code = "";
        do {
            code = Enter.enter_str_nonBlank("Enter Code: ");
            
            if (isDuplicateCode(code)) System.out.println("Doctor code is exist!");
        } while (isDuplicateCode(code));
        String name = Enter.enter_str_nonBlank("Enter Name: ");
        String specialization = Enter.enter_str_nonBlank("Enter Specialization: ");
        int availability = Enter.enter_int("Enter Availability: ", 0);
        Doctor doctor = new Doctor(code, name, specialization, availability);
        this.add(doctor);
        System.out.println("Add doctor " + doctor.getCode() + " success!");
    }
    
    public void updateDoctor() {
        if (this.isEmpty()) {
            System.out.println("Doctor list is empty cannot update!");
        } else {
            String codeUpdate = Enter.enter_str("Enter doctor code to update: ");
            int index = searchDoctorByCode(codeUpdate);

            if (index == -1) System.out.println("This code is not exist cannot update!");
            else {
                Doctor doctor = this.get(index);
                
                System.out.println("-------- Doctor Information --------");
                displayDoctorInfor(doctor);
                System.out.println("------------------------------------");
                System.out.println("<Please update doctor>");
                
                String newCode = "";
                do {
                    newCode = Enter.enter_str("Enter new code: ");
                
                    if (newCode.equalsIgnoreCase(doctor.getCode())) {
                        break;
                    }
                    
                    if (isDuplicateCode(newCode)) System.out.println("Doctor code is exist!");
                } while (isDuplicateCode(newCode));
                if (newCode.length() == 0) newCode = doctor.getCode();
                
                String newName = Enter.enter_str("Enter new name: ");
                if (newName.length() == 0) newName = doctor.getName();
                
                String newSpecialization = Enter.enter_str("Enter new specialization: ");
                if (newSpecialization.length() == 0) newSpecialization = doctor.getSpecialization();
                
                int newAvailability = Enter.enter_int_withSpace("Enter new availability: ", doctor.getAvailability(), 0);
                
                doctor.setCode(newCode.toUpperCase());
                doctor.setName(newName);
                doctor.setSpecialization(newSpecialization);
                doctor.setAvailability(newAvailability);
                
                System.out.println("---- Doctor infor after update ----");
                displayDoctorInfor(doctor);
                System.out.println("-----------------------------------");
                
                System.out.println("Update doctor success!");
            }
        }
    }
    
    public void deleteDoctor() {
        if (this.isEmpty()) {
            System.out.println("Doctor list is empty cannot delete!");
        } else {
            String doctorCode = Enter.enter_str("Enter doctor code to delete: ");
            int index = searchDoctorByCode(doctorCode);
            
            if (index == -1) System.out.println("This doctor is not exist cannot delete!");
            else {
                boolean isDelete = Enter.enter_boolean("Are you sure to delete this doctor[Y-N]: ");
                
                if (isDelete) {
                    this.remove(index);
                }
            }
        }
    }
    
    public void searchDoctor() {
        if (this.isEmpty()) System.out.println("Doctor list is empty cannot search!");
        else {
            String searchDoctor = Enter.enter_str("Enter doctor name to search: ");
            Doctor[] doctors = searchDoctorByName(searchDoctor);
            
            if (doctors == null) System.out.println("This doctor is not exsit!");
            else {
                System.out.println("---------------------- List doctor ----------------------");
                displayListDoctor(doctors);
                System.out.println("---------------------------------------------------------");
            }
        }
    }
    
    public int countDoctorContainName(String name) {
        int count = 0;
        for (Doctor d : this) {
            if (d.getName().toUpperCase().contains(name.toUpperCase().trim())) {
                count++;
            }
        }
        
        return count;
    }
    
    public Doctor[] searchDoctorByName(String name) {
        int totalDoctor = countDoctorContainName(name.trim());
        if (totalDoctor == 0) return null;
        else {
            Doctor[] listDoctor = new Doctor[totalDoctor];
            int index = 0;
            for (Doctor doctor : this) {
                if (doctor.getName().toUpperCase().contains(name.toUpperCase().trim())) {
                    listDoctor[index] = doctor;
                    index++;
                }
            }
            
            return listDoctor;
        }
    }
    
    public void displayDoctorInfor(Doctor d) {
        System.out.println("Code: " + d.getCode());
        System.out.println("Name: " + d.getName());
        System.out.println("Specialization: " + d.getSpecialization());
        System.out.println("Availability: " + d.getAvailability());
    }
    
    public void test() {
        this.add(new Doctor("DOC 1", "Nghia", "Orthopedics", 3));
        this.add(new Doctor("DOC 2", "Phuong", "Obstetrics", 2));
        this.add(new Doctor("DOC 3", "Lien", "Orthodontic", 1));
    } 
}
