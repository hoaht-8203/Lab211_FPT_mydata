public class ContactManagement {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();

        String[] menuOptions = {"Add a contact", "Display all contacts", "Delete a contact", "Exit"};
        while (true) {
            System.out.println("========= Contact program =========");
            Menu.printMenu(menuOptions);
            int choice = Menu.getChoiceFromMenu(menuOptions);

            switch (choice) {
                case 1: contactList.addContact(); break;
                case 2: contactList.displayAllContact(); break;
                case 3: contactList.deleteContact(); break;
                case 4: System.exit(0);
            }
        }
    }
}
