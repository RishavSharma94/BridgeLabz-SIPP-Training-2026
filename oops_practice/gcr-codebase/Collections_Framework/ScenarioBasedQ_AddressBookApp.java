import java.util.*;

public class ScenarioBasedQ_AddressBookApp {

    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();

        addressBook.addContact("Rishav", "9876543210", "rishav@gmail.com");
        addressBook.addContact("Aman", "9876501234", "aman@gmail.com");
        addressBook.addContact("Rahul", "9876543211", "rahul@gmail.com");
        addressBook.addContact("Rohit", "9876543210", "rohit@gmail.com");

        System.out.println("\nSearch Contact:");
        addressBook.searchContact("Aman");

        System.out.println("\nDelete Contact:");
        addressBook.deleteContact("Rahul");

        System.out.println("\nSorted Contact List:");
        addressBook.displayContacts();
    }
}

class Contact {

    String name;
    String phone;
    String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}

class AddressBook {

    ArrayList<Contact> contactList = new ArrayList<>();
    HashMap<String, Contact> contactMap = new HashMap<>();
    HashSet<String> phoneNumbers = new HashSet<>();

    public void addContact(String name, String phone, String email) {

        if (phoneNumbers.contains(phone)) {
            System.out.println("Duplicate Phone Number: " + phone);
            return;
        }

        Contact contact = new Contact(name, phone, email);

        contactList.add(contact);
        contactMap.put(name, contact);
        phoneNumbers.add(phone);

        System.out.println("Contact Added: " + name);
    }

    public void searchContact(String name) {

        Contact contact = contactMap.get(name);

        if (contact != null) {
            System.out.println(contact.name + " | " + contact.phone + " | " + contact.email);
        } else {
            System.out.println("Contact Not Found");
        }
    }

    public void deleteContact(String name) {

        Contact contact = contactMap.remove(name);

        if (contact != null) {

            contactList.remove(contact);
            phoneNumbers.remove(contact.phone);

            System.out.println("Contact Deleted");
        } else {
            System.out.println("Contact Not Found");
        }
    }

    public void displayContacts() {

        Collections.sort(contactList, new Comparator<Contact>() {

            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.name.compareTo(c2.name);
            }
        });

        for (Contact contact : contactList) {
            System.out.println(contact.name + " | " + contact.phone + " | " + contact.email);
        }
    }
}