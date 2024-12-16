import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

class AddressBook {
    private ArrayList<Contact> AdBook = new ArrayList<>();
    private static final String FILE_NAME = "AddressBook.txt";

    public void AddContact(Contact c) {
        boolean exists = AdBook.stream().anyMatch(contact -> contact.equals(c));
        if (exists) {
            System.out.println("Duplicate contact! Contact not added.");
            return;
        }
        AdBook.add(c);
        System.out.println("Contact added.");
    }

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

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Contact contact : AdBook) {
                writer.write(contact.toString());
                writer.newLine();
            }
            System.out.println("Contacts saved to file: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving contacts to file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            AdBook.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(", ");
                Map<String, String> fieldMap = Arrays.stream(fields)
                        .map(field -> field.split(": "))
                        .collect(Collectors.toMap(
                                split -> split[0].trim(),
                                split -> split[1].trim()));

                Contact contact = new Contact(
                        fieldMap.get("Name").split(" ")[0],
                        fieldMap.get("Name").split(" ")[1],
                        fieldMap.get("City"),
                        fieldMap.get("State"),
                        fieldMap.get("Email"),
                        Integer.parseInt(fieldMap.get("Phone")),
                        Integer.parseInt(fieldMap.get("Zip")));
                AdBook.add(contact);
            }
            System.out.println("Contacts loaded from file: " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error loading contacts from file: " + e.getMessage());
        }
    }

    public void sortContactsByName() {
        if (AdBook.isEmpty()) {
            System.out.println("No contacts to sort!");
            return;
        }

        AdBook.stream()
                .sorted(Comparator.comparing(contact -> contact.FirstName + " " + contact.LastName))
                .forEach(System.out::println);
    }

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

    public int search(String name) {
        for (int i = 0; i < AdBook.size(); i++) {
            if (AdBook.get(i).FirstName.equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

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

    public ArrayList<Contact> getContacts() {
        return AdBook;
    }
}
