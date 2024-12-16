import java.util.Scanner;

// Main class remains mostly the same, but now manages multiple address books
public class Main {
    public static void main(String[] args) {
        // Create a system to manage multiple address books
        AddressBookSystem addressBookSystem = new AddressBookSystem();

        Scanner sc = new Scanner(System.in);
        int i = 1;

        while (i != 0) {
            System.out.println("Address Book Management System");
            System.out.println("-> Enter 0 to Exit");
            System.out.println("-> Enter 1 to Create a new Address Book");
            System.out.println("-> Enter 2 to Select an Address Book");
            System.out.println("-> Enter 3 to List All Address Books");

            int input = sc.nextInt();

            switch (input) {
                case 0 -> {
                    i = 0;
                }
                case 1 -> {
                    System.out.println("Enter a unique name for the new Address Book:");
                    String addressBookName = sc.next();
                    addressBookSystem.createAddressBook(addressBookName);
                }
                case 2 -> {
                    System.out.println("Enter the name of the Address Book you want to work with:");
                    String addressBookName = sc.next();
                    AddressBook selectedAddressBook = addressBookSystem.getAddressBook(addressBookName);

                    if (selectedAddressBook != null) {
                        addressBookMenu(selectedAddressBook, sc);
                    } else {
                        System.out.println("Address Book not found!");
                    }
                }
                case 3 -> {
                    addressBookSystem.listAddressBooks();
                }
                default -> {
                    System.out.println("Wrong Input");
                }
            }
        }

        sc.close();
        System.out.println("Thank you for using Address Book Management System!");
    }

    private static void addressBookMenu(AddressBook addressBook, Scanner sc) {
        int i = 1;
        while (i != 0) {
            System.out.println("-> Enter 0 to Exit");
            System.out.println("-> Enter 1 to Create a contact!");
            System.out.println("-> Enter 2 to Display all Contacts");
            System.out.println("-> Enter 3 to Edit a contact");
            System.out.println("-> Enter 4 to Delete a Contact");
            System.out.println("-> Enter 5 to Save Contacts to File");
            System.out.println("-> Enter 6 to Load Contacts from File");

            int input = sc.nextInt();

            switch (input) {
                case 1 -> {
                    Contact c = addressBook.createContact(sc);
                    addressBook.AddContact(c);
                }
                case 0 -> {
                    i = 0;
                }
                case 2 -> addressBook.ShowContacts();
                case 3 -> {
                    System.out.println("Enter the name you want to edit:");
                    String name = sc.next();
                    int ind = addressBook.search(name);
                    if (ind == -1) {
                        System.out.println("Please Enter a Valid Name!");
                        continue;
                    }
                    addressBook.editContact(ind, sc);
                }
                case 4 -> {
                    System.out.println("Enter the name you want to delete:");
                    String name = sc.next();
                    addressBook.deleteContact(name);
                }
                case 5 -> addressBook.saveToFile();
                case 6 -> addressBook.loadFromFile();
                default -> {
                    System.out.println("Wrong Input");
                }
            }
        }
    }

}
