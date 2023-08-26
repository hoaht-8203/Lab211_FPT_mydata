package fruitShop;

import java.util.Scanner;

public class Enter {
    public static Scanner sc = new Scanner(System.in);

    public static String get_str_nonBlank(String msg) {
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();

            if (data.length() == 0) System.out.println("Value cannot blank!");
        } while (data.length() == 0);
        return data;
    }

    public static double get_price(String msg, double minValue) {
        double data = minValue - 1;
        do {
            try {
                System.out.print(msg);
                data = Double.parseDouble(sc.nextLine().trim());

                if (data < minValue) System.out.println("Value must be greater than " + minValue);
            }catch (NumberFormatException e) {
                System.out.println("This value is not format");
            }
        } while (data < minValue);
        return data;
    }

    public static int get_int(String msg, int minValue) {
        int data = minValue - 1;
        do {
            try {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine().trim());

                if (data < minValue) System.out.println("Value must be greater than " + minValue);
            }catch (NumberFormatException e) {
                System.out.println("This value is not format");
            }
        } while (data < minValue);
        return data;
    }

    public static int get_int(String msg, int minValue, int maxValue) {
        int data = minValue - 1;
        do {
            try {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine().trim());

                if (data < minValue || data > maxValue) {
                    System.out.println("Value must be from " + minValue + " to " + maxValue);
                }
            }catch (NumberFormatException e) {
                System.out.println("This value is not format");
            }
        } while (data < minValue || data > maxValue);
        return data;
    }

    public static int get_int(String msg, int minValue, int maxValue, String error) {
        int data = minValue - 1;
        do {
            try {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine().trim());

                if (data < minValue || data > maxValue) {
                    System.out.println(error);
                }
            }catch (NumberFormatException e) {
                System.out.println("This value is not format");
            }
        } while (data < minValue || data > maxValue);
        return data;
    }

    public static boolean get_boolean(String msg) {
        String data = "";
        do {
            data = get_str_nonBlank(msg);

            if (!data.equalsIgnoreCase("Y") && !data.equalsIgnoreCase("N")) {
                System.out.println("Value must be Y or N!");
            }
        } while (!data.equalsIgnoreCase("Y") && !data.equalsIgnoreCase("N"));
        return data.equalsIgnoreCase("Y");
    }
}
