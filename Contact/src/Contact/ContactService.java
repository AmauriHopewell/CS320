package Contact;

//ContactService.java
import java.util.ArrayList;
import java.util.List;

public class ContactService {
 private List<Contact> contacts = new ArrayList<>(); //list of contact objects

 public void addContact(Contact contact) { //add based on unique ID
     if (contact == null) { //ensure ID exists
         throw new IllegalArgumentException("Contact cannot be null");
     }
     for (Contact c : contacts) { //avoid duplicates
         if (c.getContactID().equals(contact.getContactID())) {
             throw new IllegalArgumentException("Contact ID already exists");
         }
     }
     contacts.add(contact); //add if no problems
 }

 public void deleteContact(String contactID) {
     contacts.removeIf(c -> c.getContactID().equals(contactID)); //check if ID exists, remove if so using built-in method
 }

 public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
     for (Contact c : contacts) { //Update based on valid parameters
         if (c.getContactID().equals(contactID)) {
             if (firstName != null) {
                 c.setFirstName(firstName);
             }
             if (lastName != null) {
                 c.setLastName(lastName);
             }
             if (phone != null) {
                 c.setPhone(phone);
             }
             if (address != null) {
                 c.setAddress(address);
             }
             return;
         }
     }
     throw new IllegalArgumentException("Contact not found"); //throw error if any parameters invalid
 }

 // helper method for testing
 public Contact getContact(String contactID) {
     for (Contact c : contacts) {
         if (c.getContactID().equals(contactID)) {
        	 System.out.println (c + " found\n"); 
             return c;
         }
     }
     System.out.println (contactID + " not found\n"); 
     return null;
 }
}