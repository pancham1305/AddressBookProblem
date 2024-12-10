import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AddressBook A = new AddressBook();
        System.out.println("Welcome to Address Book");
        Scanner sc = new Scanner(System.in);
        int i = 1;
        while (i != 0) {
            System.out.println("-> Enter 0 to Exit");
            System.out.println(
                    "-> Enter 1 to Create a contact!\n-> Enter 2 to Display all Contacts\n-> Enter 3 to Edit a contact(Please Provide Index of the contact) ");
            int input = sc.nextInt();
            switch (input) {
                case 1 -> {
                    Contact c = A.createContact(sc);
                    A.AddContact(c);
                }
                case 0 -> {
                    i = 0;
                }
                case 2 -> A.ShowContacts();
                case 3 -> {
                    String name = sc.nextLine();

                    int ind = A.search(name);
                    if (ind == -1) {
                        System.out.println("Please Enter a Valid Name!");
                        continue;
                    }
                    A.editContact(ind, sc);
                }
                default -> {
                    System.out.println("Wrong Input");
                    continue;
                }
            }
        }
        sc.close();
        System.out.println("Thank you for using Address Book!");
    }

}