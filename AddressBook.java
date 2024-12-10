import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private ArrayList<Contact> AdBook = new ArrayList<>();

    public void AddContact(Contact c) {
        AdBook.add(c);
        System.out.println("Contact added");
    }

    public void ShowContacts() {
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
        Contact c1 = new Contact(FirstName, LastName, city, state, email, phone, zip);
        return c1;
    }

    public int search(String name) {
        for (int i = 0; i < AdBook.size(); i++) {
            if (AdBook.get(i).FirstName == name) {
                return i;
            }
        }
        return -1;
    }

    public void editContact(int ind, Scanner sc) {
        System.out.println("Old Contact: ");
        System.out.println(this.AdBook.get(ind));
        System.out.println("Enter new Contact: ");
        Contact c = createContact(sc);
        AdBook.set(ind, c);
        System.out.println("Done!");
        return;
    }
}
