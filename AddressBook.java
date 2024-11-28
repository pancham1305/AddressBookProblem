import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    List<Contact> AdBook = new ArrayList<>();

    public void AddContact(Contact c) {
        AdBook.add(c);
        System.out.println("Contact added");
    }

    public void ShowContacts() {
        for (Contact c : AdBook) {
            System.out.println(c.getContact() + "\n");
        }
    }

    public void createContact(AddressBook A, Scanner ts) {
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
        A.AddContact(c1);
    }
}
