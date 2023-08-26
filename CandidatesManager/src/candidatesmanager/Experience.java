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
public class Experience extends Candidate{
    private int expInYear;
    private String proSkill;

    public Experience() {
        super();
    }

    public Experience(String candidateId, String firstName, String lastName, int birthDate, String address, String phone, String email, int candidateType, int expInYear, String proSkill) {
        super(candidateId, firstName, lastName, birthDate, address, phone, email, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill.trim();
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return super.toString() + " | Year of experience: " + expInYear + " | Professional skill: " + proSkill;
    }
}
