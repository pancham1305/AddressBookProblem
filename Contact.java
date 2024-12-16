import java.util.*;

public class Contact {
    String FirstName, LastName, city, state, email;
    int phone, zip;

    public Contact(String FirstName, String LastName, String city, String state, String email, int phone, int zip) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.city = city;
        this.state = state;
        this.email = email;
        this.phone = phone;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Name: " + FirstName + " " + LastName +
                ", City: " + city +
                ", State: " + state +
                ", Email: " + email +
                ", Phone: " + phone +
                ", Zip: " + zip;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Contact contact = (Contact) obj;
        return FirstName.equals(contact.FirstName) && LastName.equals(contact.LastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstName, LastName);
    }
}
