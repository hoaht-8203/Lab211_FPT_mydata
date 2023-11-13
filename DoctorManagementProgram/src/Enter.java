
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
public class Enter {

    public static Scanner sc = new Scanner(System.in);

    public static String enter_str(String msg) {
        System.out.print(msg);
        String data = sc.nextLine();

        return data.trim();
    }

    public static String enter_str_nonBlank(String msg) {
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();

            if (data.length() == 0) {
                System.out.println("This value cannot empty!");
            }
        } while (data.length() == 0);

        return data;
    }

    public static int enter_int(String msg, int min) {
        int data = min - 1;
        boolean isDigit;
        do {
            try {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine().trim());

                if (data < min) {
                    System.out.println("Value must be greater or equal " + min);
                }

                isDigit = true;
            } catch (NumberFormatException e) {
                System.out.println("Value must be integer!");
                isDigit = false;
            }
        } while (data < min || !isDigit);

        return data;
    }

    public static int enter_int_withSpace(String msg, int draft, int min) {
        int data_int = min - 1;
        boolean isDigit;
        do {
            System.out.print(msg);
            String data = sc.nextLine().trim();

            if (data.length() == 0) {
                return draft;
            } else {
                try {
                    data_int = Integer.parseInt(data);
                    
                    if (data_int < min) {
                        System.out.println("Value must be greater or equal " + min);
                    }
                    isDigit = true;
                } catch (NumberFormatException e) {
                    System.out.println("Value must be digit!");
                    isDigit = false;
                }
            }
        } while (data_int < min || !isDigit);

        return data_int;
    }
    
    public static boolean enter_boolean(String msg) {
        String data = "";
        do {
            data = enter_str(msg);
            
            if (data.length() == 0) return false;
        } while (!data.equalsIgnoreCase("Y") && !data.equalsIgnoreCase("N"));
        
        return data.equalsIgnoreCase("Y");
    }
}
