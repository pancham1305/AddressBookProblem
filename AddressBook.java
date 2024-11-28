import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    List<Contact> AdBook = new ArrayList<>();

    public void AddContact(Contact c) {
        AdBook.add(c);
        System.out.println("Contact added");
    }
}
