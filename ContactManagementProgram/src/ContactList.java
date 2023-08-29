import java.util.ArrayList;

public class ContactList extends ArrayList<Contact> {
    public ContactList() {
    }

    public void addContact() {
        System.out.println("-------- Add a Contact --------");
        int contactId;
        if (this.isEmpty()) {
            contactId = 1;
        } else {
            contactId = this.get(this.size() - 1).getContactId() + 1;
        }

        String name = Input.input_nonBlankStr("Enter Name: ");
        String group = Input.input_nonBlankStr("Enter Group: ");
        String address = Input.input_nonBlankStr("Enter Address: ");
        String phone = Input.input_telephone("Enter phone: ");
        String[] nameSplit = name.split("\\s+");
        String firstName = nameSplit[0];
        String lastName = nameSplit[1];
        Contact c = new Contact(contactId, group, address, phone, lastName, firstName);
        this.add(c);
        System.out.println("Successful");
    }

    public void displayAllContact() {
        System.out.println("--------------------------------- Display all Contact ----------------------------");
        System.out.printf("%-5s %-15s %-15s %-15s %-10s %-15s %-15s\n", "ID", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
        for (Contact c : this) {
            c.display();
        }
    }

    public int searchId(int id) {
        for (Contact c : this) {
            if (c.getContactId() == id) {
                return this.indexOf(c);
            }
        }

        return -1;
    }

    public void deleteContact() {
        int id = Input.input_int("Enter ID: ");

        int index = searchId(id);

        if (index < 0) {
            System.out.println("This ID is not exist!");
        } else {
            this.remove(this.get(index));
            System.out.println("Successful");
        }

    }
}
