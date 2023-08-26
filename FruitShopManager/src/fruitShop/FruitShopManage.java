package fruitShop;

public class FruitShopManage {
    public static void main(String[] args) {
        FruitList fruitList = new FruitList();
        fruitList.test();

        String[] menuOptions = {"Create Fruit", "View Orders", "Shopping", "Exit"};
        while (true) {
            System.out.println("============= Fruit Shop =============");
            Menu.printMenu(menuOptions);
            System.out.println("======================================");
            int choice = Menu.getChoiceFromMenu(menuOptions);

            switch (choice) {
                case 1: fruitList.addFruit(); break;
                case 2: fruitList.viewOrder(); break;
                case 3: fruitList.shopping(); break;
                case 4: System.exit(0); break;
            }
        }
    }
}
