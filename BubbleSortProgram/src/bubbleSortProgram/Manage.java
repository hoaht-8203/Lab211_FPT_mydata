package bubbleSortProgram;

public class Manage {
    public static void main(String[] args) {
        int[] arrayInt = new int[0];

        String[] menuOptions = {"Input Element", "Sort Ascending", "Sort Descending", "Exit"};
        while (true) {
            System.out.println("========= Bubble Sort program =========");
            Menu.printMenu(menuOptions);
            int choice = Menu.getChoiceFromMenu(menuOptions);

            switch (choice) {
                case 1:
                    arrayInt = BubbleSortProgram.input_arr();
                    break;
                case 2:
                    int[] sortAscending = BubbleSortProgram.sortAscending(arrayInt);
                    System.out.println("----- Descending -----");
                    System.out.println(BubbleSortProgram.arrayToString(sortAscending));
                    break;
                case 3:
                    int[] sortDescending = BubbleSortProgram.sortDescending(arrayInt);
                    System.out.println("----- Ascending -----");
                    System.out.println(BubbleSortProgram.arrayToString(sortDescending));
                    break;
                case 4: System.exit(0);
            }
        }
    }
}
