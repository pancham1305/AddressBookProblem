import java.util.*;
import java.util.stream.Collectors;

class AddressBookSystem {
    private HashMap<String, AddressBook> addressBooks;
    private HashMap<String, List<Contact>> cityToPersonsMap;
    private HashMap<String, List<Contact>> stateToPersonsMap;

    public AddressBookSystem() {
        this.addressBooks = new HashMap<>();
        this.cityToPersonsMap = new HashMap<>();
        this.stateToPersonsMap = new HashMap<>();
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

    // Populate city and state maps
    public void populateCityAndStateMaps() {
        cityToPersonsMap.clear();
        stateToPersonsMap.clear();

        addressBooks.values().forEach(addressBook -> {
            addressBook.getContacts().forEach(contact -> {
                // Update City Map
                cityToPersonsMap
                        .computeIfAbsent(contact.city, k -> new ArrayList<>())
                        .add(contact);

                // Update State Map
                stateToPersonsMap
                        .computeIfAbsent(contact.state, k -> new ArrayList<>())
                        .add(contact);
            });
        });

        System.out.println("City and State maps updated!");
    }

    // View persons by city
    public void viewPersonsByCity(String city) {
        List<Contact> contacts = cityToPersonsMap.getOrDefault(city, new ArrayList<>());
        if (contacts.isEmpty()) {
            System.out.println("No persons found in city: " + city);
        } else {
            System.out.println("Persons in city '" + city + "':");
            contacts.forEach(System.out::println);
        }
    }

    // View persons by state
    public void viewPersonsByState(String state) {
        List<Contact> contacts = stateToPersonsMap.getOrDefault(state, new ArrayList<>());
        if (contacts.isEmpty()) {
            System.out.println("No persons found in state: " + state);
        } else {
            System.out.println("Persons in state '" + state + "':");
            contacts.forEach(System.out::println);
        }
    }

    // Count and display the number of contacts by city
    public void countContactsByCity() {
        if (cityToPersonsMap.isEmpty()) {
            System.out.println("City map is empty! Populate maps first.");
            return;
        }

        System.out.println("Number of Contacts by City:");
        cityToPersonsMap.forEach((city, contacts) -> System.out.println(city + ": " + contacts.size() + " contact(s)"));
    }

    // Count and display the number of contacts by state
    public void countContactsByState() {
        if (stateToPersonsMap.isEmpty()) {
            System.out.println("State map is empty! Populate maps first.");
            return;
        }

        System.out.println("Number of Contacts by State:");
        stateToPersonsMap
                .forEach((state, contacts) -> System.out.println(state + ": " + contacts.size() + " contact(s)"));
    }

}
