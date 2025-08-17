package Contact;

//ContactTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


//JUnit tests, based on examples from https://www.vogella.com/tutorials/JUnit/article.html
public class ContactTest {

 @Test
 public void testValidContactCreation() { //valid case
     Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
     assertEquals("ID123", contact.getContactID());
     assertEquals("John", contact.getFirstName());
     assertEquals("Doe", contact.getLastName());
     assertEquals("1234567890", contact.getPhone());
     assertEquals("123 Main St", contact.getAddress());
 }

 //unit tests for invalid cases
 
 @Test
 public void testInvalidContactIDNull() {  //test when ID is null
     assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
 }

 @Test
 public void testInvalidContactIDTooLong() { 
     assertThrows(IllegalArgumentException.class, () -> new Contact("ID123456789", "John", "Doe", "1234567890", "123 Main St"));
 }

 @Test
 public void testInvalidFirstNameNull() {
     assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", null, "Doe", "1234567890", "123 Main St"));
 }

 @Test
 public void testInvalidFirstNameTooLong() {
     assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", "Johnathanxx", "Doe", "1234567890", "123 Main St"));
 }

 @Test
 public void testInvalidLastNameNull() {
     assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", "John", null, "1234567890", "123 Main St"));
 }

 @Test
 public void testInvalidLastNameTooLong() {
     assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", "John", "DoeTooLongx", "1234567890", "123 Main St"));
 }

 @Test
 public void testInvalidPhoneNull() {
     assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", "John", "Doe", null, "123 Main St"));
 }

 @Test
 public void testInvalidPhoneNotTenDigits() {
     assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", "John", "Doe", "123456789", "123 Main St"));
 }

 @Test
 public void testInvalidPhoneNonDigits() {
     assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", "John", "Doe", "123456789a", "123 Main St"));
 }

 @Test
 public void testInvalidAddressNull() {
     assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", "John", "Doe", "1234567890", null));
 }

 @Test
 public void testInvalidAddressTooLong() {
     assertThrows(IllegalArgumentException.class, () -> new Contact("ID123", "John", "Doe", "1234567890", "This address is way too long for the limit of thirty characters"));
 }

 //tests for update functionality
 @Test
 public void testUpdateFirstNameValid() {
     Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
     contact.setFirstName("Jane");
     assertEquals("Jane", contact.getFirstName());
 }

 @Test
 public void testUpdateFirstNameInvalid() {
     Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
     assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("JaneTooLong"));
 }

 @Test
 public void testUpdateLastNameValid() {
     Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
     contact.setLastName("Smith");
     assertEquals("Smith", contact.getLastName());
 }

 @Test
 public void testUpdateLastNameInvalid() {
     Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
     assertThrows(IllegalArgumentException.class, () -> contact.setLastName("SmithTooLong"));
 }

 @Test
 public void testUpdatePhoneValid() {
     Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
     contact.setPhone("0987654321");
     assertEquals("0987654321", contact.getPhone());
 }

 //tests for invalid updates
 @Test
 public void testUpdatePhoneInvalid() {
     Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
     assertThrows(IllegalArgumentException.class, () -> contact.setPhone("098765432"));
 }

 @Test
 public void testUpdateAddressValid() {
     Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
     contact.setAddress("456 Elm St");
     assertEquals("456 Elm St", contact.getAddress());
 }

 @Test
 public void testUpdateAddressInvalid() {
     Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");
     assertThrows(IllegalArgumentException.class, () -> contact.setAddress("This updated address is way too long for the limit"));
 }
}