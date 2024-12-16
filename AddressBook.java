import java.util.*;
import java.util.stream.Collectors;

class AddressBook {
    private ArrayList<Contact> AdBook = new ArrayList<>();

    // Add a contact to the Address Book
    public void AddContact(Contact c) {
        boolean exists = AdBook.stream().anyMatch(contact -> contact.equals(c));
        if (exists) {
            System.out.println("Duplicate contact! Contact not added.");
            return;
        }
        AdBook.add(c);
        System.out.println("Contact added.");
    }

    // Display all contacts
    public void ShowContacts() {
        if (AdBook.isEmpty()) {
            System.out.println("No contacts in this Address Book!");
            return;
        }

        System.out.println("Contacts in Address Book:");
        for (int i = 0; i < AdBook.size(); i++) {
            System.out.println(i + ": " + AdBook.get(i));
        }
    }

    // Sort contacts by Name
    public void sortContactsByName() {
        if (AdBook.isEmpty()) {
            System.out.println("No contacts to sort!");
            return;
        }

        AdBook.stream()
                .sorted(Comparator.comparing(contact -> contact.FirstName + " " + contact.LastName))
                .forEach(System.out::println);
    }

    // Create a new contact from user input
    public Contact createContact(Scanner ts) {
        System.out.println("Enter First Name:");
        String FirstName = ts.next();
        System.out.println("Enter Last Name:");
        String LastName = ts.next();
        System.out.println("Enter City:");
        String city = ts.next();
        System.out.println("Enter State:");
        String state = ts.next();
        System.out.println("Enter Email:");
        String email = ts.next();
        System.out.println("Enter Phone:");
        int phone = ts.nextInt();
        System.out.println("Enter ZIP:");
        int zip = ts.nextInt();

        return new Contact(FirstName, LastName, city, state, email, phone, zip);
    }

    // Search for a contact by name
    public int search(String name) {
        for (int i = 0; i < AdBook.size(); i++) {
            if (AdBook.get(i).FirstName.equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    // Delete a contact by name
    public int deleteContact(String name) {
        int ind = search(name);
        if (ind == -1) {
            System.out.println("No such name found!");
            return 0;
        }
        AdBook.remove(ind);
        System.out.println("Contact deleted. Updated list:");
        ShowContacts();
        return 1;
    }

    // Edit an existing contact
    public void editContact(int ind, Scanner sc) {
        System.out.println("Old Contact: " + AdBook.get(ind));
        System.out.println("Enter new details for the contact:");
        Contact c = createContact(sc);
        boolean exists = AdBook.stream().anyMatch(contact -> contact.equals(c));
        if (exists) {
            System.out.println("Duplicate contact! Edit cancelled.");
            return;
        }
        AdBook.set(ind, c);
        System.out.println("Contact updated!");
    }

    // Get all contacts
    public ArrayList<Contact> getContacts() {
        return AdBook;
    }
}
