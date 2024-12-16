import java.util.*;

class AddressBookSystem {
    private HashMap<String, AddressBook> addressBooks = new HashMap<>();
    private HashMap<String, List<Contact>> cityToPersonsMap = new HashMap<>();
    private HashMap<String, List<Contact>> stateToPersonsMap = new HashMap<>();

    public void createAddressBook(String name) {
        if (addressBooks.containsKey(name)) {
            System.out.println("An Address Book with this name already exists!");
            return;
        }

        addressBooks.put(name, new AddressBook());
        System.out.println("Address Book '" + name + "' created successfully!");
    }

    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

    public void listAddressBooks() {
        if (addressBooks.isEmpty()) {
            System.out.println("No Address Books exist!");
            return;
        }

        System.out.println("Existing Address Books:");
        addressBooks.keySet().forEach(System.out::println);
    }

    public void populateCityAndStateMaps() {
        cityToPersonsMap.clear();
        stateToPersonsMap.clear();

        addressBooks.values().forEach(addressBook -> {
            addressBook.getContacts().forEach(contact -> {
                cityToPersonsMap
                        .computeIfAbsent(contact.city, k -> new ArrayList<>())
                        .add(contact);
                stateToPersonsMap
                        .computeIfAbsent(contact.state, k -> new ArrayList<>())
                        .add(contact);
            });
        });

        System.out.println("City and State maps updated!");
    }

    public void viewPersonsByCity(String city) {
        List<Contact> contacts = cityToPersonsMap.getOrDefault(city, new ArrayList<>());
        if (contacts.isEmpty()) {
            System.out.println("No persons found in city: " + city);
        } else {
            System.out.println("Persons in city '" + city + "':");
            contacts.forEach(System.out::println);
        }
    }

    public void viewPersonsByState(String state) {
        List<Contact> contacts = stateToPersonsMap.getOrDefault(state, new ArrayList<>());
        if (contacts.isEmpty()) {
            System.out.println("No persons found in state: " + state);
        } else {
            System.out.println("Persons in state '" + state + "':");
            contacts.forEach(System.out::println);
        }
    }

    public void countContactsByCity() {
        if (cityToPersonsMap.isEmpty()) {
            System.out.println("City map is empty! Populate maps first.");
            return;
        }

        System.out.println("Number of Contacts by City:");
        cityToPersonsMap.forEach((city, contacts) -> System.out.println(city + ": " + contacts.size() + " contact(s)"));
    }

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
