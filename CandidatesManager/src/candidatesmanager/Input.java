/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package candidatesmanager;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author hoaht
 */
public class Input {
    public static Scanner sc = new Scanner(System.in);
    
    public static int get_int_withRange(String msg, int min, int max) {
        int data = min - 1;
        do {
            try {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine().trim());

                if (data < min || data > max) {
                    System.out.println("This value must be from " + min + " to " + max + "!");
                }
            } catch (NumberFormatException e) {
                System.out.println("This value is not format!");
            }
        } while (data < min || data > max);
        
        return data;
    }
    
    public static String get_str_nonBlank(String msg) {
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
            
            if (data.length() == 0) System.out.println("This value cannot blank!");
        } while (data.length() == 0);
        
        return data;
    }
    
    public static String get_str_inRange(String msg, String[] options) {
        String data = "";
        boolean isInOption = false;
        do {
            System.out.print(msg + Arrays.toString(options));
            data = get_str_nonBlank(msg);
            
            for (String option : options) {
                if (option.equalsIgnoreCase(data)) isInOption = true;
            }
        } while (isInOption == false);
        
        return data;
    }
    
    public static String get_phoneNumber(String msg) {
        String pattern = "^0\\d{9}$";
        String data = "";
        do {
            data = get_str_nonBlank(msg);
            
            if (!data.matches(pattern)) System.out.println("This phone number is not matches!");
        } while (!data.matches(pattern));
        
        return data;
    }
    
    public static String get_email(String msg) {
        String pattern = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        String data = "";
        do {
            data = get_str_nonBlank(msg);
            
            if (!data.matches(pattern)) System.out.println("This email is not matches!");
        } while (!data.matches(pattern));
        
        return data;
    }
    
    public static boolean input_boolean(String msg) {
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
        } while (!data.equalsIgnoreCase("Y") && !data.equalsIgnoreCase("N"));
        
        return data.equalsIgnoreCase("Y");
    }
    
    public static String get_str(String msg) {
        System.out.print(msg);
        String data = sc.nextLine().trim();
        
        return data;
    }
    
    public static int get_int(String msg) {
        int data = 0;
        try {
            System.out.println(msg);
            data = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("This value must be number!");
        }
        
        return data;
    }
}
