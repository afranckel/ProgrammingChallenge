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

    //Verification of the pattern of the first phone number (410)555-1234
    private static boolean isValidPhoneNum(String s) {
        Pattern numPattern = Pattern.compile("\\(\\d{3}\\)\\d{3}-?\\d{4}");

        Matcher matcher = numPattern.matcher(s);
        return (matcher.find() && matcher.group().equals(s));
    }

    //Method to get contact information 
    ContactInfo getContactInfo(String document) {
        String email = "Unknown";
        String phone = "Unknown";
        String name = "Unknown";
        ArrayList<String> arr = new ArrayList<>();
        if (document == null) {
            return null;
        }
        //separate String into Strings by new line 
        String[] businessInfo = document.split("\\r?\\n");
        for (String line : businessInfo) {
            //If the line is in the required pattern, it is a phone number
            if (isValidPhoneNum(line)) {
                phone = line.replaceAll("[\\s\\-()]", "");
            } //If the line that contains "Tel," it is a phone number
            else if (line.startsWith("Tel:")) {
                phone = line.replaceAll("Tel:", "").replaceAll("[\\s\\-()+]", "");

            } //If the line that contains "Phone," it is a phone number
            else if (line.startsWith("Phone:")) {
                phone = line.replaceAll("Phone:", "").replaceAll("[\\s\\-()]", "");
            } //If line contains "@," it is an email
            else if (line.contains("@")) {
                email = line;
            } //Add all other lines to an ArrayList
            else {
                arr.add(line);
            }
        }
        //Parse through all other lines
        for (String s : arr) {
            //Split the line into two words in a String array
            String[] str = s.split(" ");
            //If the email contains the full second word (a last name), then the whole line is the name
            if (email.contains(str[1].toLowerCase())) {
                name = s;
            }
        }
        //Create an object containing contact info for each person to be added to contact list
        ContactInfo info = new ContactInfo(name, phone, email);
        return info;
    }
}
