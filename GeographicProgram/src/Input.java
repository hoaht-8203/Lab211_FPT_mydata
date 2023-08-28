import java.util.Scanner;

public class Input {
    public static Scanner sc = new Scanner(System.in);

    public static String get_str(String msg) {
        System.out.print(msg);

        return sc.nextLine().trim();
    }
    public static String get_nonBlank_str(String msg) {
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();

            if (data.length() == 0) System.out.println("This value cannot blank!");
        } while (data.length() == 0);
        return data;
    }

    public static float get_float(String msg, float min_value) {
        float data = min_value - 1;
        do {
            try {
                System.out.print(msg);
                data = Float.parseFloat(sc.nextLine().trim());

                if (data < min_value) System.out.println("Value must be greater than " + min_value);
            } catch (NumberFormatException e) {
                System.out.println("This number is not format!");
            }
        } while (data < min_value);
        return data;
    }
}
