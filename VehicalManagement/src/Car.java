/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoaht
 */
public class Car extends Vehicle{
    private String type;
    private int yearOfManufacture;

    public Car() {
    }

    public Car(String id, String name, String color, String brand, double price, String type, int yearOfManufacture) {
        super(id, name, color, brand, price);
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public String toString() {
        return "Car:" + super.toString() + "," + type + "," + yearOfManufacture; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String printMenu() {
        return super.printMenu() + ", Type: " + type + ", Year of manufacture: " + yearOfManufacture; //To change body of generated methods, choose Tools | Templates.
    }

    public void update(String newName, String newColor, String newBrand, double newPrice, String newType, int newYearOfManufacture) {
        super.update(newName, newColor, newBrand, newPrice); //To change body of generated methods, choose Tools | Templates.
        this.type = newType;
        this.yearOfManufacture = newYearOfManufacture;
    }
    
    
}
