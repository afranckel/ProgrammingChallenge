/*
 * This class (ParsingBusinessCardsTest.java) is my tester class.  This class
 * provides test cases to ensure that all the information going into a contact list
 * is correct.  Each entry is then printed as output to the console.
 */
package contacts;

public class ParsingBusinessCardsTest {

    public static void main(String[] args) {
        BusinessCardParser parser = new BusinessCardParser();
        String firstEntry = "Entegra Systems\n"
                + "John Doe\n"
                + "Senior Software Engineer\n"
                + "(410)555-1234\n"
                + "john.doe@entegrasystems.com";
        String secondEntry = "Acme Technologies\n"
                + "Analytic Developer\n"
                + "Jane Doe\n"
                + "1234 Roadrunner Way\n"
                + "Columbia, MD 12345\n"
                + "Phone: 410-555-1234\n"
                + "Fax: 410-555-4321\n"
                + "jane.doe@acmetech.com";
        String thirdEntry = "Bob Smith\n"
                + "Software Engineer\n"
                + "Decision & Security Technologies\n"
                + "ABC Technologies\n"
                + "123 North 11th Street\n"
                + "Suite 229\n"
                + "Arlington, VA 22209\n"
                + "Tel: +1 (703) 555-1259\n"
                + "Fax: +1 (703) 555-1200\n"
                + "bsmith@abctech.com";
        //Create objects that contain contact info
        ContactInfo info = parser.getContactInfo(firstEntry);
        ContactInfo infoTwo = parser.getContactInfo(secondEntry);
        ContactInfo infoThree = parser.getContactInfo(thirdEntry);

        //Print out first test case
        System.out.println(info.toString());
        //Print out second test case
        System.out.println(infoTwo.toString());
        //Print out third test case
        System.out.println(infoThree.toString());
    }

}
