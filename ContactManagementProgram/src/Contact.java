public class Contact {
    private int contactId;
    private String group;
    private String address;
    private String phone;
    private String lastName;
    private String firstName;

    public Contact() {
    }

    public Contact(int contactId, String group, String address, String phone, String lastName, String firstName) {
        this.contactId = contactId;
        this.group = group.trim();
        this.address = address.trim();
        this.phone = phone.trim();
        this.lastName = lastName.trim();
        this.firstName = firstName.trim();
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void display() {
        System.out.printf("%-5d %-15s %-15s %-15s %-10s %-15s %-15s\n", contactId, firstName + " " + lastName, firstName, lastName, group, address, phone);
    }
}
