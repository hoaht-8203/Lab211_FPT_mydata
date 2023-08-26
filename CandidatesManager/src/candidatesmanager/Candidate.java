/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package candidatesmanager;

/**
 *
 * @author hoaht
 */
public class Candidate {
    private String candidateId;
    private String firstName;
    private String lastName;
    private int birthDate;
    private String address;
    private String phone;
    private String email;
    private int candidateType;

    public Candidate() {
    }

    public Candidate(String candidateId, String firstName, String lastName, int birthDate, String address, String phone, String email, int candidateType) {
        this.candidateId = candidateId.trim();
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.birthDate = birthDate;
        this.address = address.trim();
        this.phone = phone.trim();
        this.email = email.trim();
        this.candidateType = candidateType;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    @Override
    public String toString() {
        String candidateTypeStr = "";
        switch (candidateType) {
            case 0:
                candidateTypeStr = "Experience";
                break;
            case 1:
                candidateTypeStr = "Fresher";
                break;
            case 2:
                candidateTypeStr = "Intern";
                break;
            default:
                candidateTypeStr = "Empty";
                break;
        }
        
        return "Candidate ID: " + candidateId + " | First Name=" + firstName + " | Last Name: " + lastName + " | Birth Date: " + birthDate + " | Address: " + address + " | Phone: " + phone + " | Email: " + email + "| Candidate Type: " + candidateTypeStr;
    }
    
    public void printCandidateSearch(){
        System.out.println(firstName + " " + lastName + " | " + birthDate + " | " + address + " | " + phone + " | " + email + " | " + candidateType);
    }
}
