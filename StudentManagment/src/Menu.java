
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoaht
 */
public class Menu {
    public static Scanner sc = new Scanner(System.in);
    
    public static void printMenu(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i+1) + ". " + options[i]);
        }
    }
    
    public static int getChoiceFromMenu(String[] options) {
        int choice = 0;
        do {
            try {
                System.out.print("Enter your choice [1-" + options.length + "]: ");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("This value is not format!");
            }
        } while (choice < 1 || choice > options.length);
        
        return choice;
    }
}
