package Contact;

//ContactServiceTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//JUnit tests, based on examples from https://www.vogella.com/tutorials/JUnit/article.html
public class ContactServiceTest {
 private ContactService service;

 @BeforeEach
 public void setUp() {
     service = new ContactService();
 }

 //test on valid case
 @Test
 public void testAddContactValid() {
     Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
     service.addContact(contact);
     assertEquals(contact, service.getContact("ID123"));
 }

 //test on invalid additions
 @Test
 public void testAddContactNull() {
     assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
 }

 @Test
 public void testAddDuplicateContact() {
     Contact contact1 = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
     service.addContact(contact1);
     Contact contact2 = new Contact("ID123", "Jane", "Wales", "0987654321", "456 Elm St");
     assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
 }

 //test deleting
 @Test
 public void testDeleteContactExisting() {
     Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
     service.addContact(contact);
     service.deleteContact("ID123");
     assertNull(service.getContact("ID123"));
 }

 //test invalid deletion
 @Test
 public void testDeleteContactNonExisting() {
     service.deleteContact("NONEXIST"); // Should not throw exception, just do nothing
     assertNull(service.getContact("NONEXIST"));
 }

 //valid update tests
 @Test
 public void testUpdateContactAllFields() {
     Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
     service.addContact(contact);
     service.updateContact("ID123", "Jane", "Smith", "0987654321", "456 Elm St");
     Contact updated = service.getContact("ID123");
     assertEquals("Jane", updated.getFirstName());
     assertEquals("Smith", updated.getLastName());
     assertEquals("0987654321", updated.getPhone());
     assertEquals("456 Elm St", updated.getAddress());
 }

 @Test
 public void testUpdateContactPartialFields() {
     Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
     service.addContact(contact);
     service.updateContact("ID123", null, "Smith", null, "456 Elm St");
     Contact updated = service.getContact("ID123");
     assertEquals("John", updated.getFirstName());
     assertEquals("Smith", updated.getLastName());
     assertEquals("1234567890", updated.getPhone());
     assertEquals("456 Elm St", updated.getAddress());
 }

 //test invalid types of updates
 @Test
 public void testUpdateContactNonExisting() {
     assertThrows(IllegalArgumentException.class, () -> service.updateContact("NONEXIST", "Jane", "Smith", "0987654321", "456 Elm St"));
 }

 @Test
 public void testUpdateWithInvalidData() {
     Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
     service.addContact(contact);
     // Since update uses setters, invalid data should throw from setters
     assertThrows(IllegalArgumentException.class, () -> service.updateContact("ID123", "TooLongName", null, null, null));
 }
}
