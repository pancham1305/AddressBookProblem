import java.util.*;
import java.util.stream.Collectors;

class AddressBookSystem {
    private HashMap<String, AddressBook> addressBooks;

    public AddressBookSystem() {
        this.addressBooks = new HashMap<>();
    }

    // Create a new address book
    public void createAddressBook(String name) {
        if (addressBooks.containsKey(name)) {
            System.out.println("An Address Book with this name already exists!");
            return;
        }

        AddressBook newAddressBook = new AddressBook();
        addressBooks.put(name, newAddressBook);
        System.out.println("Address Book '" + name + "' created successfully!");
    }

    // Retrieve an address book by name
    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

    // List all address books
    public void listAddressBooks() {
        if (addressBooks.isEmpty()) {
            System.out.println("No Address Books exist!");
            return;
        }

        System.out.println("Existing Address Books:");
        for (String name : addressBooks.keySet()) {
            System.out.println("- " + name);
        }
    }

    // Search for persons in a given city across all address books
    public List<Contact> searchPersonsByCity(String city) {
        return addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContacts().stream())
                .filter(contact -> contact.city.equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    // Search for persons in a given state across all address books
    public List<Contact> searchPersonsByState(String state) {
        return addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContacts().stream())
                .filter(contact -> contact.state.equalsIgnoreCase(state))
                .collect(Collectors.toList());
    }

    // Display search results
    public void displaySearchResults(List<Contact> results) {
        if (results.isEmpty()) {
            System.out.println("No matching contacts found!");
        } else {
            System.out.println("Search Results:");
            results.forEach(System.out::println);
        }
    }
}
