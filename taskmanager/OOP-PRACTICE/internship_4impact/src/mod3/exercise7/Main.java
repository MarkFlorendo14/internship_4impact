package mod3.exercise7;

public class Main {
    public static void main (String args[]) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Mark Florendo", "09692426542");
        phoneBook.addContact("Kate Hermosa", "09124212412");
        phoneBook.addContact("Sitti Helen", "01231232");
        phoneBook.addContact("Michelle Hermosa", "1123542");
        phoneBook.addContact("Lilibeth Rivera", "01231242");

        phoneBook.lookupByName("Mark Florendo");
        phoneBook.lookupByName("Sitti Helen");

        phoneBook.listAllContacts();

        phoneBook.removeContact("Mark Florendo");
        phoneBook.removeContact("Kate Hermosa");

        phoneBook.listAllContacts();

        phoneBook.addContact("Mark Florendo", "09692426542");
        phoneBook.addContact("Mark Florendo", "09692426542");
    }
}
