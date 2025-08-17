package com;

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;


public class AppointmentTest {

 @Test
 void testValidAppointment() {
     Date futureDate = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1));
     Appointment appointment = new Appointment("123", futureDate, "Valid description");
     assertEquals("123", appointment.getId());
     assertEquals(futureDate, appointment.getAppointmentDate());
     assertEquals("Valid description", appointment.getDescription());
 }

 @Test
 void testInvalidIdNull() {
     Date futureDate = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1));
     assertThrows(IllegalArgumentException.class, () -> new Appointment(null, futureDate, "Description"));
 }

 @Test
 void testInvalidIdEmpty() {
     Date futureDate = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1));
     assertThrows(IllegalArgumentException.class, () -> new Appointment("", futureDate, "Description"));
 }

 @Test
 void testInvalidIdTooLong() {
     Date futureDate = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1));
     assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", futureDate, "Description"));
 }

 @Test
 void testInvalidDateNull() {
     assertThrows(IllegalArgumentException.class, () -> new Appointment("123", null, "Description"));
 }

 @Test
 void testInvalidDatePast() { 
     Date pastDate = new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
     assertThrows(IllegalArgumentException.class, () -> new Appointment("123", pastDate, "Description"));
 }

 @Test
 void testInvalidDescriptionNull() { //testing null description
     Date futureDate = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1));
     assertThrows(IllegalArgumentException.class, () -> new Appointment("123", futureDate, null));
 }

 @Test
 void testInvalidDescriptionEmpty() { //testing no description 
     Date futureDate = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1));
     assertThrows(IllegalArgumentException.class, () -> new Appointment("123", futureDate, ""));
 }

 @Test
 void testInvalidDescriptionTooLong() {
     Date futureDate = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1));
     String longDesc = "This description is very very long and well exceeds the fifty character limit.";
     assertThrows(IllegalArgumentException.class, () -> new Appointment("123", futureDate, longDesc));
 }
}
