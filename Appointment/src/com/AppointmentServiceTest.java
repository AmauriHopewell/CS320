package com;

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

//JUnit tests for defined use cases
public class AppointmentServiceTest {

 @Test
 void testAddAppointment() {
     AppointmentService service = new AppointmentService();
     Date futureDate = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1));
     service.addAppointment("123", futureDate, "Test appointment");
     Appointment appointment = service.getAppointment("123");
     assertNotNull(appointment);
     assertEquals("123", appointment.getId());
     assertEquals("Test appointment", appointment.getDescription());
 }

 @Test
 void testAddDuplicateAppointment() {
     AppointmentService service = new AppointmentService();
     Date futureDate = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1));
     service.addAppointment("123", futureDate, "Test appointment");
     assertThrows(IllegalArgumentException.class, () -> service.addAppointment("123", futureDate, "Duplicate"));
 }

 @Test
 void testDeleteAppointment() {
     AppointmentService service = new AppointmentService();
     Date futureDate = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1));
     service.addAppointment("123", futureDate, "Test appointment");
     service.deleteAppointment("123");
     assertNull(service.getAppointment("123"));
 }

 @Test
 void testDeleteNonExistentAppointment() {
     AppointmentService service = new AppointmentService();
     assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("nonexistent"));
 }
}