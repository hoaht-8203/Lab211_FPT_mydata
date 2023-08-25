/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoaht
 */
public class Motorbike extends Vehicle{
    private double speed;
    private boolean license;
    private final String sound = "Tin tin tin";

    public Motorbike() {
    }

    public Motorbike(String id, String name, String color, String brand, double price, double speed, boolean license) {
        super(id, name, color, brand, price);
        this.speed = speed;
        this.license = license;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isLicense() {
        return license;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "Motorbike:" + super.toString() + "," + speed + "," + license; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String printMenu() {
        return super.printMenu() + ", Speed: " + speed + ", license: " + license; //To change body of generated methods, choose Tools | Templates.
    }

    public void update(String newName, String newColor, String newBrand, double newPrice, double newSpeed, boolean newLicense) {
        super.update(newName, newColor, newBrand, newPrice); //To change body of generated methods, choose Tools | Templates.
        this.speed = newSpeed;
        this.license = newLicense;
    }
    
    public void makeSound() {
        System.out.print("("+sound+")");
    }
}
