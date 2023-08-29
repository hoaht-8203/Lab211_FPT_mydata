
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
    
    public static String input_nonBlankStr(String msg) {
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
            
            if (data.length() == 0) System.out.println("This value cannot blank!");
        } while (data.length() == 0);
        
        return data;
    }
    
    public static int input_int_withRange(String msg, int min) {
        int data = min - 1;
        do {
            try {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine().trim());
                if (data < min) System.out.println("This value must be greater than " + min);
            } catch (NumberFormatException e) {
                System.out.println("This value is not format");
            }
        } while (data < min);
        
        return data;
    }
    
    public static String input_str_withOptions(String msg, String[] options) {
        String data = "";
        boolean checkInRange = false;
        while (!checkInRange) {
            do {
                System.out.print(msg);
                System.out.print("(");
                for (int i = 0; i < options.length; i++) {
                    if (i == options.length - 1) System.out.print(options[i]);
                    else System.out.print(options[i] + ", ");
                }
                System.out.print("): ");
                data = sc.nextLine().trim();

                if (data.length() == 0) System.out.println("This value cannot blank!");
            } while (data.length() == 0);
            
            for (String option : options) {
                if (data.equalsIgnoreCase(option)) {
                    checkInRange = true;
                    break;
                }
            }
            
            if (checkInRange == false) {
                System.out.print("This value must be in (");
                for (int i = 0; i < options.length; i++) {
                    if (i == options.length - 1) System.out.print(options[i]);
                    else System.out.print(options[i] + ", ");
                }
                System.out.println(")");
            }
        }
        
        return data;
    }
    
    public static boolean input_boolean(String msg) {
        String data = "";
        do {
            System.out.print(msg + "[Y-N]: ");
            data = sc.nextLine().trim();
            
            if (data.length() == 0) System.out.println("This value cannot blank!");
            if (!data.equalsIgnoreCase("Y") && !data.equalsIgnoreCase("N")) {
                System.out.println("This value must be N or Y");
            }
        } while (data.length() == 0 || (!data.equalsIgnoreCase("Y") && !data.equalsIgnoreCase("N")));
        
        if (data.equalsIgnoreCase("Y")) return true;
        return false;
    }
    
    public static boolean input_boolean_withOptions(String msg, String op1, String op2) {
        String data = "";
        do {
            System.out.print(msg + "[" + op1 + "-" + op2 + "]: ");
            data = sc.nextLine().trim();
            
            if (data.length() == 0) System.out.println("This value cannot blank!");
            if (!data.equalsIgnoreCase(op1) || !data.equalsIgnoreCase(op2)) {
                System.out.println("This value must be N or Y");
            }
        } while (data.length() == 0 || !data.equalsIgnoreCase(op1) || !data.equalsIgnoreCase(op2));
        
        if (data.equalsIgnoreCase(op1)) return true;
        return false;
    }
    
    public static String input_str(String msg) {
        System.out.print(msg);
        String data = sc.nextLine();
        
        return data.trim();
    }
}
