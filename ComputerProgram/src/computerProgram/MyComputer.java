package computerProgram;

public class MyComputer {
    public static void BMICalculator() {
        double weight = Enter.get_bmi("Enter Weight: ");
        double height = Enter.get_bmi("Enter Height: ");

        String result = "";
        double bmi = weight / (height/100 * height/100);
        if (bmi < 19) {
            result = "Under-standard";
        }else if (bmi >= 1 && bmi <= 25) {
            result = "Standard";
        }else if (bmi >= 25 && bmi <= 30) {
            result = "Overweight";
        }else if (bmi >= 30 && bmi <= 40) {
            result = "Fat - should lose weight";
        }else {
            result = "Very fat - should lose weight immediately";
        }

        System.out.printf("BMI Number: %.2f\n", bmi);
        System.out.printf("BMI Status: %s\n", result);
    }
    public static void NormalCalculator() {
        String operator = "";
        double num1, num2, memory = 0;

        num1 = Enter.get_double("Enter number: ");
        operator = Enter.get_operator("Enter Operator: ");
        num2 = Enter.get_double("Enter number: ");
        memory = calculateNumber(num1, num2, operator);
        System.out.printf("Memory: %.3f\n", memory);

        while (true) {
            operator = Enter.get_operator_equal("Enter Operator: ");

            if (operator.equalsIgnoreCase("=")) {
                break;
            }

            double num3 = Enter.get_double("Enter number: ");
            memory = calculateNumber(memory, num3, operator);
            System.out.printf("Memory: %.3f\n", memory);
        }
        System.out.printf("Result: %.3f\n", memory);
    }

    public static double calculateNumber(double num1, double num2, String operator) {
        if (operator.equalsIgnoreCase("+")) {
            return num1 + num2;
        } else if (operator.equalsIgnoreCase("-")) {
            return num1 - num2;
        } else if (operator.equalsIgnoreCase("*")) {
            return num1 * num2;
        } else if (operator.equalsIgnoreCase("/")) {
            if (num2 == 0) {
                System.out.println("Cannot divided by 0");
                return num1;
            }
            return num1 / num2;
        } else if (operator.equalsIgnoreCase("^")) {
            return Math.pow(num1, num2);
        } else {
            return 0;
        }
    }
}
