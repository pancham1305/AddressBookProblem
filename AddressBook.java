import java.util.*;

class AddressBook {
    private ArrayList<Contact> AdBook = new ArrayList<>();

    public void AddContact(Contact c) {
        boolean exists = AdBook.stream().anyMatch(contact -> contact.equals(c));
        if (exists) {
            System.out.println("Duplicate contact! Contact not added.");
            return;
        }
        AdBook.add(c);
        System.out.println("Contact added");
    }

    public void ShowContacts() {
        if (AdBook.isEmpty()) {
            System.out.println("No contacts in this Address Book!");
            return;
        }
        int ind = 0;
        for (Contact c : AdBook) {
            System.out.println(ind + ": " + c);
            ind++;
        }
    }

    public Contact createContact(Scanner ts) {
        System.out.println("Enter FirstName:");
        String FirstName = ts.next();
        System.out.println("Enter LastName:");
        String LastName = ts.next();
        System.out.println("Enter city:");
        String city = ts.next();
        System.out.println("Enter state:");
        String state = ts.next();
        System.out.println("Enter email:");
        String email = ts.next();
        System.out.println("Enter phone:");
        int phone = ts.nextInt();
        System.out.println("Enter zip:");
        int zip = ts.nextInt();

        return new Contact(FirstName, LastName, city, state, email, phone, zip);
    }

    public int search(String name) {
        for (int i = 0; i < AdBook.size(); i++) {
            if (AdBook.get(i).FirstName.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public int deleteContact(String name) {
        int ind = search(name);
        if (ind == -1) {
            System.out.println("There is no such name!");
            return 0;
        }
        AdBook.remove(ind);
        System.out.println("Contact deleted. Updated list:");
        ShowContacts();
        return 1;
    }

    public void editContact(int ind, Scanner sc) {
        System.out.println("Old Contact: ");
        System.out.println(this.AdBook.get(ind));
        System.out.println("Enter new Contact: ");
        Contact c = createContact(sc);
        boolean exists = AdBook.stream().anyMatch(contact -> contact.equals(c));
        if (exists) {
            System.out.println("Duplicate contact! Edit cancelled.");
            return;
        }
        AdBook.set(ind, c);
        System.out.println("Contact updated!");
    }

    public ArrayList<Contact> getContacts() {
        return AdBook;
    }

}
