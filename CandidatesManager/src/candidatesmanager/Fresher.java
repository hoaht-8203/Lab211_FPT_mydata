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
public class Fresher extends Candidate{
    private int graduation_date;
    private String graduation_rank;
    private String education;

    public Fresher() {
        super();
    }

    public Fresher(String candidateId, String firstName, String lastName, int birthDate, String address, String phone, String email, int candidateType, int graduation_date, String graduation_rank, String education) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.graduation_date = graduation_date;
        this.graduation_rank = graduation_rank.trim();
        this.education = education.trim();
    }

    public int getGraduation_date() {
        return graduation_date;
    }

    public void setGraduation_date(int graduation_date) {
        this.graduation_date = graduation_date;
    }

    public String getGraduation_rank() {
        return graduation_rank;
    }

    public void setGraduation_rank(String graduation_rank) {
        this.graduation_rank = graduation_rank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return super.toString() + " | Graduation date: " + graduation_date + " | Graduation rank: " + graduation_rank + " | Education: " + education;
    }
}
