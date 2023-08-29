import java.util.List;

public class Validate {
    private static final String[] patternsTelephone = {"^[0-9]{10}$", "^\\d{3}-\\d{3}-\\d{4}$", "^\\d{3}-\\d{3}-\\d{4} x\\d{4}$", "^\\d{3}-\\d{3}-\\d{4} ext\\d{4}$", "^(\\d{3})-\\d{3}-\\d{4}", "^\\d{3}.\\d{3}.\\d{4}", "^\\d{3} \\d{3} \\d{4}"};

    public static boolean isTelephone(String tel) {
        for (String s : patternsTelephone) {
            if (tel.matches(s)) {
                return true;
            }
        }
        return false;
    }

    public static void printLegitTelephone() {
        System.out.println("Please input Phone flow");
        System.out.println(" - 1234567890\n" +
                " - 123-456-7890 \n" +
                " - 123-456-7890 x1234\n" +
                " - 123-456-7890 ext1234\n" +
                " - (123)-456-7890\n" +
                " - 123.456.7890\n" +
                " - 123 456 7890\n");
    }
}
