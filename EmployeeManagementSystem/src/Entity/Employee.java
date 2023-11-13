/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.awt.List;
import java.util.Date;

/**
 *
 * @author hoaht
 */
public class Employee {
    private String eId;
    private String eFirstName;
    private String eLastName;
    private String ePhone;
    private String eEmail;
    private String eAddress;
    private Date eDob;
    private boolean sex;
    private float salary;
    private String agency;

    public Employee() {
    }

    public Employee(String eId, String eFirstName, String eLastName, String ePhone, String eEmail, String eAddress, Date eDob, boolean sex, float salary, String agency) {
        this.eId = eId;
        this.eFirstName = eFirstName;
        this.eLastName = eLastName;
        this.ePhone = ePhone;
        this.eEmail = eEmail;
        this.eAddress = eAddress;
        this.eDob = eDob;
        this.sex = sex;
        this.salary = salary;
        this.agency = agency;
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteFirstName() {
        return eFirstName;
    }

    public void seteFirstName(String eFirstName) {
        this.eFirstName = eFirstName;
    }

    public String geteLastName() {
        return eLastName;
    }

    public void seteLastName(String eLastName) {
        this.eLastName = eLastName;
    }

    public String getePhone() {
        return ePhone;
    }

    public void setePhone(String ePhone) {
        this.ePhone = ePhone;
    }

    public String geteEmail() {
        return eEmail;
    }

    public void seteEmail(String eEmail) {
        this.eEmail = eEmail;
    }

    public String geteAddress() {
        return eAddress;
    }

    public void seteAddress(String eAddress) {
        this.eAddress = eAddress;
    }

    public Date geteDob() {
        return eDob;
    }

    public void seteDob(Date eDob) {
        this.eDob = eDob;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }
    
    
}
