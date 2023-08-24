
import java.math.BigInteger;
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
    
    public static String input_decimal(String msg) {
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine();
            
            if(data.length() == 0) System.out.println("This value cannot empty!");
            if(!data.matches("[0-9]*")) System.out.println("This value must be through 0-9!");
        } while (data.length() == 0 || !data.matches("[0-9]*"));
        
        return data;
    }
    
    public static String input_binary(String msg) {
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine();
            
            if(data.length() == 0) System.out.println("This value cannot empty!");
            if(!data.matches("[0-1]*")) System.out.println("This value must be through 0-1!");
        } while (data.length() == 0 || !data.matches("[0-1]*"));
        
        return data;
    }
    
    public static String input_hexa(String msg) {
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine();
            
            if(data.length() == 0) System.out.println("This value cannot empty!");
            if(!data.matches("[0-9A-Fa-f]*")) System.out.println("This value must be through 0-9 and A-F!");
        } while (data.length() == 0 || !data.matches("[0-9A-Fa-f]*"));
        
        return data;
    }
    
    public static int input_withRange(int min, int max, String msg) {
        int data = min - 1;
        boolean b = false;
        do {
            try {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine());
                b = true;
                
                if(data < min || data > max) System.out.println("This value must be through " + min + " to " + max + "!");
            } catch (NumberFormatException e) {
                System.out.println("This number is not valid!");
            }
        } while (b == false || data < min || data > max);
        
        return data;
    }
    
}
