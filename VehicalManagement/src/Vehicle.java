/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoaht
 */
public class Vehicle {
    private String id, name, color, brand;
    private double price;

    public Vehicle() {
    }

    public Vehicle(String id, String name, String color, String brand, double price) {
        this.id = id.trim().toUpperCase();
        this.name = name.trim();
        this.color = color.trim();
        this.brand = brand.trim();
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + color + "," + brand + "," + price;
    }
    
    public String printMenu() {
        return "ID: " + id + ", Name: " + name + ", Color: " + color + ", Brand: " + brand + ", Price = " + price;
    }
    
    public void update(String newName, String newColor, String newBrand, double newPrice) {
        this.name = newName;
        this.color = newColor;
        this.brand = newBrand;
        this.price = newPrice;
    }
}
