/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package candidatesmanager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hoaht
 */
public class CandidateList extends ArrayList<Candidate>{

    public CandidateList() {
    }
    
    public void addExperience(Candidate candidate) {
        int expInYear = Input.get_int_withRange("Enter year of experience: ", 0, 100);
        String proSkill = Input.get_str_nonBlank("Enter professional skill: ");
        
        Candidate exp = new Experience(candidate.getCandidateId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), 0, expInYear, proSkill);
        this.add(exp);
        System.out.println("Add new experience candidate success!");
    }
    
    public void addFresher(Candidate candidate) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy");
        int currentYear = Integer.parseInt(sf.format(date));
        String[] graduation_rank_options = {"Excellence", "Good", "Fair", "Poor"};
        
        int graduation_date = Input.get_int_withRange("Enter graduation date: ", candidate.getBirthDate(), currentYear);
        String graduation_rank = Input.get_str_inRange("Enter graduation rank: ", graduation_rank_options);
        String education = Input.get_str_nonBlank("Enter education: ");
        
        Candidate fresher = new Fresher(candidate.getCandidateId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), 1, graduation_date, graduation_rank, education);
        this.add(fresher);
        System.out.println("Add new fresher candidate success!");
    }
    
    public void addIntern(Candidate candidate) {
        String[] semesterOptions = {"Spring", "Summer", "Fall"};
        
        String majors = Input.get_str_nonBlank("Enter majors: ");
        String semester = Input.get_str_inRange("Enter semester: ", semesterOptions);
        String universityName = Input.get_str_nonBlank("Enter university name: ");
        
        Candidate fresher = new Intern(candidate.getCandidateId(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate(), candidate.getAddress(), candidate.getPhone(), candidate.getEmail(), 2, majors, semester, universityName);
        this.add(fresher);
        System.out.println("Add new internship candidate success!");
    }
    
    public void addCandidate(int optionCandidate) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy");
        int currentYear = Integer.parseInt(sf.format(date));
        
        boolean isContinue = true;
        while (isContinue) {
            String candidateId;
            do {
                candidateId = Input.get_str_nonBlank("Enter candidate ID: ");
            } while (checkDuplicateId(candidateId));
            String firstName = Input.get_str_nonBlank("Enter first name: ");
            String lastName = Input.get_str_nonBlank("Enter last name: ");
            int birthDate = Input.get_int_withRange("Enter birth date: ", 1900, currentYear);
            String address = Input.get_str_nonBlank("Enter address: ");
            String phone = Input.get_phoneNumber("Enter phone: ");
            String email = Input.get_email("Enter email: ");
            
            Candidate candidate = new Candidate(candidateId, firstName, lastName, birthDate, address, phone, email, 0);
            switch (optionCandidate) {
                case 0: 
                    addExperience(candidate);
                    break;
                case 1:
                    addFresher(candidate);
                    break;
                case 2:
                    addIntern(candidate);
                    break;
                default:
                    break;
            }
            
            isContinue = Input.input_boolean("Do you want to continue (Y/N): ");
        }
        System.out.println("----- List candidates who are created ----");
        displayCandidate();
        System.out.println("------------------------------------------");
    }
    
    public void searchCandidate() {
        List<Candidate> listCandidates = new ArrayList<>();
        
        String q = Input.get_str("Enter Candidate name (First name or Last name): ");
        int i = Input.get_int("Enter type of candidate: ");
        
        for (Candidate candidate  : this) {
            if (candidate.getCandidateType() == i) {
                if (candidate.getFirstName().toUpperCase().contains(q.toUpperCase()) || candidate.getLastName().toUpperCase().contains(q.toUpperCase())) {
                    listCandidates.add(candidate);
                }
            }
        }
        
        for (Candidate candidate : listCandidates) {
            candidate.printCandidateSearch();
        }
    }
    
    public boolean checkDuplicateId(String id) {
        for (Candidate c : this) {
            if (c.getCandidateId().equalsIgnoreCase(id.trim())) {
                return true;
            }
        }
        
        return false;
    }
    
    public void displayCandidate() {
        for (Candidate can : this) {
            System.out.println(can.toString());
        }
    }
}
