package bubbleSortProgram;

import java.util.Scanner;

public class Input {
    public static Scanner sc = new Scanner(System.in);
    public static int input_int(String msg) {
        int data = 0;
        boolean isDigit = true;
        do {
            try {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please input int number");
                isDigit = false;
            }
        } while (!isDigit);
        return data;
    }

    public static int input_int(String msg, int min_val) {
        int data = 0;
        boolean isDigit;
        do {
            try {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine());
                isDigit = true;

                if (data <= min_val) {
                    System.out.println("Please input number is greater than " + min_val);
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input number is greater than " + min_val);
                isDigit = false;
            }
        } while (!isDigit || data <= min_val);
        return data;
    }
}
