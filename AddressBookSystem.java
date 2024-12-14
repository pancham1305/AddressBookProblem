import java.util.HashMap;

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
}
