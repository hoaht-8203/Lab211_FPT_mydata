package equationProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SolveMath {
    public static Scanner sc = new Scanner(System.in);

    public static String getListOddNum(List<Double> listNumber) {
        String data = "";
        System.out.print("Number is Odd: ");
        for (double num : listNumber) {
            if (num % 2 != 0) {
                data = data + num + ", ";
            }
        }
        return data.substring(0, data.length()-2);
    }

    public static String getListEvenNum(List<Double> listNumber) {
        String data = "";
        System.out.print("Number is Even: ");
        for (double num : listNumber) {
            if (num % 2 == 0) {
                data = data + num + ", ";
            }
        }
        return data.substring(0, data.length()-2);
    }

    public static boolean isPerfectNum(double number) {
        if (number < 1) {
            return false;
        }

        return (int) Math.sqrt(number) * (int) Math.sqrt(number) == (int) number;
    }

    public static String getListPerfectSquareNum(List<Double> listNum) {
        String data = "";
        System.out.print("Number is Perfect Square: ");
        for (double num : listNum) {
            if (isPerfectNum(num)) {
                data = data + num + ", ";
            }
        }

        return data.substring(0, data.length() - 2);
    }

    public static void calculateSuperlative() {
        List<Double> listNumber = new ArrayList<>();

        System.out.println("----- Calculate Equation -----");
        System.out.println("Please input number");
        double a = Enter.get_double("Enter A: ");
        listNumber.add(a);
        double b = Enter.get_double("Enter B: ");
        listNumber.add(b);
        double result = -b / a;
        listNumber.add(result);
        System.out.printf("Solution: %.3f\n", result);
        System.out.println(getListOddNum(listNumber));
        System.out.println(getListEvenNum(listNumber));
        System.out.println(getListPerfectSquareNum(listNumber));
    }

    public static void calculateQuadratic() {
        List<Double> listNumber = new ArrayList<>();

        System.out.println("----- Calculate Quadratic Equation -----");
        System.out.println("Please input number");
        double a = Enter.get_double("Enter A: ");
        listNumber.add(a);
        double b = Enter.get_double("Enter B: ");
        listNumber.add(b);
        double c = Enter.get_double("Enter C: ");
        listNumber.add(c);

        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            System.out.println("The equation has no solution");
        } else if (delta == 0) {
            double result = - b / (2 * a);
            listNumber.add(result);
            listNumber.add(result);
            System.out.printf("Solution: x1 = %.3f and x2 = %.3f\n", result, result);
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2*a);
            double x2 = (-b - Math.sqrt(delta)) / (2*a);
            listNumber.add(x1);
            listNumber.add(x2);
            System.out.printf("Solution: x1 = %.3f and x2 = %.3f\n", x1, x2);
        }

        System.out.println(getListOddNum(listNumber));
        System.out.println(getListEvenNum(listNumber));
        System.out.println(getListPerfectSquareNum(listNumber));
    }
}
