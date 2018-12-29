/*
 * This class (ContactInfo.java) defines objects of this class through using a
 * constructor which contains all information required (name, phone number, and email).
 * This class also contains getter method which as used to get information from an object
 * of this class.
 */
package contacts;

public class ContactInfo {

    String name;
    String phoneNum;
    String email;

    //Constructor containing name, phone number, and email
    ContactInfo(String name, String phoneNum, String email) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    //returns the name of contact
    String getName() {
        return name;
    }

    //returns the phone number of contact
    String getPhoneNumber() {
        return phoneNum;
    }

    //returns the email address of contact
    String getEmailAddress() {
        return email;
    }
}
