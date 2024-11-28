import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AddressBook A = new AddressBook();
        System.out.println("Welcome to Address Book");
        Scanner sc = new Scanner(System.in);
        int i = 1;
        while (i != 0) {
            System.out.println("-> Enter 0 to Exit");
            System.out.println("-> Enter 1 to Create a contact!");
            int input = sc.nextInt();
            switch (input) {
                case 1 -> createContact(A);
                case 0 -> {
                    i = 0;
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

    static void createContact(AddressBook A) {
        Scanner ts = new Scanner(System.in);
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