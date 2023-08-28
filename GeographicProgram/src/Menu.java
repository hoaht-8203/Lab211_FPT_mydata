import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);

    public static void printMenu(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i+1) + ". " + options[i]);
        }
    }

    public static int getChoiceFromMenu(String[] options) {
        int choice = 0;
        do {
            try {
                System.out.print("Enter your choice [1-" + options.length + "]: ");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("This value must be number!");
            }
        } while (choice < 1 || choice > options.length);

        return choice;
    }
}
