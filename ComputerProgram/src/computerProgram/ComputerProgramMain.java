package computerProgram;

public class ComputerProgramMain {
    public static void main(String[] args) {
        String[] menuOptions = {"Normal Calculator", "BMI Calculator", "Exit"};
        while (true) {
            Menu.printMenu(menuOptions);
            int choice = Menu.getChoiceFromMenu(menuOptions);

            switch (choice) {
                case 1: MyComputer.NormalCalculator(); break;
                case 2: MyComputer.BMICalculator(); break;
                case 3: System.exit(0); break;
            }
        }
    }
}
