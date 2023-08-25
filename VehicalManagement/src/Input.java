
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
public class Input {
    public static Scanner sc = new Scanner(System.in);
    
    public static String input_str(String msg) {
        System.out.print(msg);
        String data = sc.nextLine();
            
        
        return data.trim();
    }
    
    public static String input_pattern(String msg, String pattern) {
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine();
            
            if (!data.matches(pattern)) System.out.println("This value is not matches!");
        } while (!data.matches(pattern));
            
        
        return data.trim();
    }
    
    public static String input_nonBlankStr(String msg) {
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine();
            
            if (data.length() == 0) System.out.println("This value cannot empty!");
        } while (data.length() == 0);
        
        return data.trim();
    }
    
    public static int input_rangeNumber(String msg, int min, int max) {
        int data = min - 1;
        do {
            try {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine());
                
                if (data < min || data > max) {
                    System.out.printf("This value must be from %d to %d!\n",  min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("This number is not valid!");
            }
        } while (data < min || data > max);
        
        return data;
    }
    
    public static double input_rangeNumber(String msg, double min, double max) {
        double data = min - 1;
        do {
            try {
                System.out.print(msg);
                data = Double.parseDouble(sc.nextLine());
                
                if (data < min || data > max) {
                    System.out.printf("This value must be from %2f to %2f!\n",  min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("This number is not valid!");
            }
        } while (data < min || data > max);
        
        return data;
    }
    
    public static double input_rangeNumber(String msg, double min) {
        double data = min - 1;
        do {
            try {
                System.out.print(msg);
                data = Double.parseDouble(sc.nextLine());
                
                if (data < min) {
                    System.out.printf("This value must be greater than %.1f!\n",  min);
                }
            } catch (NumberFormatException e) {
                System.out.println("This number is not valid!");
            }
        } while (data < min);
        
        return data;
    }
    
    public static boolean input_boolean(String msg, String type1, String type2) {
        String data = "";
        do {
            System.out.print(msg + "["+type1+", "+type2+"]: ");
            data = sc.nextLine();
            
            if (data.length() == 0) System.out.println("This value cannot empty!");
            if (!data.equalsIgnoreCase(type1) && !data.equalsIgnoreCase(type2)) {
                System.out.println("You need to enter " + type1 + " or " + type2 + "!");
            }
        } while (data.length() == 0 || (!data.equalsIgnoreCase(type1) && !data.equalsIgnoreCase(type2)));
        
        if (data.equalsIgnoreCase(type1)) return true;
        else return false;
    }
}
