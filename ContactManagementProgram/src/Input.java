import java.util.Scanner;

public class Input {
    public static Scanner sc = new Scanner(System.in);
    public static String input_telephone(String msg) {
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();

            if (data.length() == 0) System.out.println("Telephone cannot blank!");
            if (!Validate.isTelephone(data)) Validate.printLegitTelephone();
        } while (data.length() == 0 || !Validate.isTelephone(data));
        return data;
    }

    public static String input_nonBlankStr(String msg) {
        String data = "";
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();

            if (data.length() == 0) System.out.println("Value cannot blank!");
        } while (data.length() == 0);
        return data;
    }

    public static int input_int(String msg) {
        int data = 0;
        boolean isDigit;
        do {
            try {
                System.out.print(msg);
                data = Integer.parseInt(sc.nextLine());
                isDigit = true;
            } catch (NumberFormatException e) {
                System.out.println("This value must be digit!");
                isDigit = false;
            }
        } while (!isDigit);
        return data;
    }
}
