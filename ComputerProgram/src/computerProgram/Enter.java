package computerProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Enter {
    public static Scanner sc = new Scanner(System.in);

    public static double get_bmi(String msg) {
        double data = 0;
        boolean isDigit;
        do {
            try {
                System.out.print(msg);
                data = Double.parseDouble(sc.nextLine().trim());
                isDigit = true;

                if (data < 0) System.out.println("BMI is greater than 0!");
            } catch (NumberFormatException e) {
                System.out.println("BMI is digit!");
                isDigit = false;
            }
        } while (data < 0 || !isDigit);

        return data;
    }
    public static double get_double (String msg) {
        double data = 0;
        try {
            System.out.print(msg);
            data = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("This value must be number!");
        }

        return data;
    }

    public static boolean checkOperator(String str) {
        String[] listOperator = {"+", "-", "*", "/", "^"};

        for (int i = 0; i < listOperator.length - 1; i++) {
            if (str.equalsIgnoreCase(listOperator[i])) {
                return true;
            }

            if (str.equalsIgnoreCase("^")) return true;
        }

        return false;
    }

    public static boolean checkOperatorEqual(String str) {
        String[] listOperator = {"+", "-", "*", "/", "^"};

        for (int i = 0; i < listOperator.length - 1; i++) {
            if (str.equalsIgnoreCase(listOperator[i])) {
                return true;
            }

            if (str.equalsIgnoreCase("=")) {
                return true;
            }

            if (str.equalsIgnoreCase("^")) return true;
        }

        return false;
    }

    public static String get_operator_equal(String msg) {
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();

            if (data.length() == 0 || !checkOperatorEqual(data)) {
                System.out.println("Please input (+, -, *, /, ^)");
            }
        } while (data.length() == 0 || !checkOperatorEqual(data));

        return data;
    }

    public static String get_operator(String msg) {
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();

            if (data.length() == 0 || !checkOperator(data)) {
                System.out.println("Please input (+, -, *, /, ^)");
            }
        } while (data.length() == 0 || !checkOperator(data));

        return data;
    }
}
