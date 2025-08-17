package com;

//AppointmentService.java
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
 private final Map<String, Appointment> appointments = new HashMap<>(); //map is like a Java version of a dictionary

 public void addAppointment(String id, Date appointmentDate, String description) {
     if (appointments.containsKey(id)) {
         throw new IllegalArgumentException("Appointment ID already exists.");
     }
     Appointment appointment = new Appointment(id, appointmentDate, description);
     appointments.put(id, appointment);
 }

 public void deleteAppointment(String id) {
     if (!appointments.containsKey(id)) {
         throw new IllegalArgumentException("Appointment ID not found.");
     }
     appointments.remove(id);
 }

 //getter for testing
 public Appointment getAppointment(String id) {
     return appointments.get(id);
 }
}