public class Contact {
    String FirstName;
    String LastName;
    String city;
    String state;
    String email;
    int phone;
    int zip;

    public Contact(String FirstName, String LastName, String city, String state, String email, int phone, int zip) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.state = state;
        this.zip = zip;
    }

    public String getContact() {
        return FirstName + " " + LastName + " " + city + " " + state + " " + email + " " + phone + " " + zip;
    }
}
