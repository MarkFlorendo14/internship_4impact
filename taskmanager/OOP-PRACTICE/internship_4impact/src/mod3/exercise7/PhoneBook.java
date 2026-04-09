package mod3.exercise7;
import java.util.HashMap;

public class PhoneBook {
    HashMap<String, String> contacts = new HashMap<>();


    public void addContact(String name, String phone){
        if (contacts.containsKey(name)) {
            System.out.println("Contact " + name + " already exists!");
            return;
        }
        contacts.put(name, phone);
        System.out.println("Contact added!");
        System.out.println("| Name: " + name + " |");
        System.out.println("| Number: " + phone + " |\n");
    }

    public void lookupByName(String name){
        if (contacts.containsKey(name)) {
            System.out.println ("Contact: " + name + " has the number of: " + contacts.get(name));
        } else {
           System.out.print("Contact not found!");
        }
    }

    public void removeContact(String name){
        contacts.remove(name);
        System.out.println("\n>>>>>> Removed contacts: " + name);

    }

    public void listAllContacts() {
        System.out.println("\n************ Contacts **************");
            for (var entry : contacts.entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        System.out.println("--------------------------------------");
    }
}

