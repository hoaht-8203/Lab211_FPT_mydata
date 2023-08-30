/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package doctormanagement;

import java.util.Scanner;

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
            
            if (data.length() == 0) System.out.println("Data cannot blank!");
        } while (data.length() == 0);
        return data;
    }
    
    public static int input_int(String msg, int min) {
        int data = min - 1;
        do {
            try {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine().trim());

                if (data < min) System.out.println("Data must be greater than " + min + "!");
            } catch (NumberFormatException e) {
                System.out.println("Data must be int!");
            }
        } while (data < min);
        return data;
    }
    
    public static String input_str(String msg) {
        System.out.print(msg);
        String data = sc.nextLine().trim();
        
        return data;
    }
}
