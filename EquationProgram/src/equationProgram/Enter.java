package equationProgram;

import java.util.Scanner;

public class Enter {
    public static Scanner sc = new Scanner(System.in);

    public static double get_double(String msg) {
        double data = 0;
        try {
            System.out.print(msg);
            data = Double.parseDouble(sc.nextLine());
        }catch (NumberFormatException e) {
            System.out.println("Value must be number!");
        }
        return data;
    }
}
