/*
 * This class (ContactInfo.java) defines a
 * constructor which contains all information required (name, phone number, and email).
 * This class also contains getter methods which as used to get information from an object
 * of this class.
 */


public class ContactInfo {

   private String name;
   private String phoneNum;
   private String email;

    //Constructor containing name, phone number, and email
    ContactInfo(String name, String phoneNum, String email) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    //Returns the name of contact
    String getName() {
        return name;
    }

    //Returns the phone number of contact
    String getPhoneNumber() {
        return phoneNum;
    }

    //Returns the email address of contact
    String getEmailAddress() {
        return email;
    }
    //toString() method to return information for each contact
    public String toString(){
        return "Name: " + name + "\n" + "Phone: " + phoneNum + "\n" + "Email: " + email + "\n";
    }
}
