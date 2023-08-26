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
public class Intern extends Candidate{
    private String majors;
    private String semester;
    private String universityName;

    public Intern() {
    }

    public Intern(String candidateId, String firstName, String lastName, int birthDate, String address, String phone, String email, int candidateType, String majors, String semester, String universityName) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.majors = majors.trim();
        this.semester = semester.trim();
        this.universityName = universityName.trim();
    }

    

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return super.toString() + " | Major: " + majors + " | Semester: " + semester + " | University name: " + universityName;
    }
}
