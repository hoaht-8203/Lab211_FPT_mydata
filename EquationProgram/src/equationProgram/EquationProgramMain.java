package equationProgram;

public class EquationProgramMain {
    public static void main(String[] args) {
        String[] menuOptions = {"Calculate Superlative Equation", "Calculate Quadratic Equation", "Exit"};
        while (true) {
            System.out.println("========= Equation Program =========");
            Menu.printMenu(menuOptions);
            int choice = Menu.getChoiceFromMenu(menuOptions);

            switch (choice) {
                case 1: SolveMath.calculateSuperlative(); break;
                case 2: SolveMath.calculateQuadratic(); break;
                case 3: System.exit(0); break;
            }
        }
    }
}
