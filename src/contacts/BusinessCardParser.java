/*
 * This class (BusinessCardParser.java) parses the String document, reads in the information
 * and identifies the contacts name, phone number, and email address.  An object of the
 * ContactInfo class is instantiated with the name, phone number, and email address for each
 * person and is returned by the getContactInfo() method.
 */
package contacts;

import java.util.ArrayList;
import java.util.regex.*;

public class BusinessCardParser {

    String email;
    String phone;
    String name;
    ArrayList<String> arr = new ArrayList<>();

    //Verification of the pattern of the first phone number (410)555-1234
    public static boolean isValidPhoneNum(String s) {
        Pattern numPattern = Pattern.compile("\\(\\d{3}\\)\\d{3}-?\\d{4}");

        Matcher matcher = numPattern.matcher(s);
        return (matcher.find() && matcher.group().equals(s));
    }

    //Method to get contact information 
    ContactInfo getContactInfo(String document) {
        //separate String into Strings by new line 
        String[] businessInfo = document.split("\\r?\\n");
        for (String line : businessInfo) {
            //if a phone number is in required pattern
            if (isValidPhoneNum(line)) {
                phone = line.replaceAll("[\\s\\-()]", "");
            }
            //if a phone number that contains "Tel"
            if (line.startsWith("Tel")) {
                phone = line.replaceAll("Tel: ", "").replaceAll("[\\s\\-()+]", "");

            }
            //if a phone number that contains "Phone"
            if (line.startsWith("Phone")) {
                phone = line.replaceAll("Phone:", "").replaceAll("[\\s\\-()]", "");
            }
            //if line is an e-mail
            if (line.contains("@")) {
                email = line;
            }
            //add all other Strings/lines to an ArrayList
            if (!isValidPhoneNum(line) && !line.contains("Tel") && !line.contains("Phone") && !line.contains("@")) {
                arr.add(line);
            }
        }
        //parse through all other Strings/lines
        for (String s : arr) {
            //split the line into two words in a String array
            String[] str = s.split(" ");
            //if the email contains the full second word (a last name) then the whole line is the name
            if (email.contains(str[1].toLowerCase())) {
                name = s;
            }
        }
        //create an object containing contact info for person to be added to contact list
        ContactInfo info = new ContactInfo(name, phone, email);
        return info;
    }
}
